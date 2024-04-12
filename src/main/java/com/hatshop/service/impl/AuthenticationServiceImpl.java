package com.hatshop.service.impl;

import static org.mockito.ArgumentMatchers.nullable;

import java.util.Optional;
import java.util.concurrent.ScheduledFuture;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hatshop.constant.SessionConstant;
import com.hatshop.dto.AuthenticationResponse;
import com.hatshop.dto.LoginDto;
import com.hatshop.dto.RegisterDto;
import com.hatshop.dto.ResetPasswordRequest;
import com.hatshop.dto.VerificationRequest;
import com.hatshop.entity.KhachHang;
import com.hatshop.entity.Quyen;
import com.hatshop.entity.RefreshToken;
import com.hatshop.entity.TaiKhoan;
import com.hatshop.mapper.TaiKhoanMapper;
import com.hatshop.model.ResponseObject;
import com.hatshop.repository.KhachHangRepository;
import com.hatshop.repository.QuyenRepository;
import com.hatshop.repository.TaiKhoanRepository;
import com.hatshop.service.AuthenticationService;
import com.hatshop.service.EmailSenderService;
import com.hatshop.service.JwtService;
import com.hatshop.service.RefreshTokenService;
import com.hatshop.util.StringUtils;
import com.hatshop.util.TaskManager;
import com.hatshop.util.VerificationCodeGenerator;
import com.hatshop.util.VerifyCodeManager;

import jakarta.mail.MessagingException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private RefreshTokenService refreshTokenService;
	
	@Autowired
	private TaiKhoanRepository taiKhoanRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private TaiKhoanMapper taiKhoanMapper;
	
	@Autowired
	private QuyenRepository quyenRepository;
	
	@Autowired
	private KhachHangRepository khachHangRepository;
	
	@Autowired
	private EmailSenderService emailSenderService;

	@Override
	public ResponseObject login(LoginDto loginDto) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
		TaiKhoan taiKhoan = (TaiKhoan) authentication.getPrincipal();
		if (ObjectUtils.isNotEmpty(taiKhoan) && !taiKhoan.getTrangThai()) {
			return new ResponseObject(HttpStatus.UNAUTHORIZED, null);
		}
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(taiKhoan);
		String jwtToken = jwtService.generateToken(taiKhoan);
		return new ResponseObject(HttpStatus.OK, new AuthenticationResponse(jwtToken, refreshToken.getToken()));
	}

	@Override
	public ResponseObject register(RegisterDto registerDto) throws MessagingException {

		if (taiKhoanRepository.existsById(registerDto.getUsername())) {
			return new ResponseObject(HttpStatus.CONFLICT, null);
		}
		if (taiKhoanRepository.existsByEmail(registerDto.getEmail())) {
			return new ResponseObject(HttpStatus.PRECONDITION_FAILED, null);
		}
		
		String hashPassword = passwordEncoder.encode(registerDto.getPassword());
		registerDto.setPassword(hashPassword);
		TaiKhoan taiKhoan = taiKhoanMapper.registerToTaiKhoan(registerDto);
		Optional<Quyen> quyen = quyenRepository.findById("us");
		if(quyen.isPresent())
		taiKhoan.setQuyen(quyen.get());
		taiKhoanRepository.save(taiKhoan);
		
		KhachHang khachHang = new KhachHang();
		String maxId = khachHangRepository.findMaxId();
		String maKhachHang =  String.format("KH%07d", Integer.parseInt(maxId.substring(2)) + 1);
		khachHang.setMaKhachHang(maKhachHang);
		khachHang.setTaiKhoan(taiKhoan);
		khachHangRepository.save(khachHang);
		
		String email = StringUtils.hideEmail(registerDto.getEmail());

		return new ResponseObject(HttpStatus.CREATED, email);
	}

	@Override
	public ResponseObject verification(VerificationRequest verificationDto) {
		Optional<TaiKhoan> taiKhoanDB = taiKhoanRepository.findById(verificationDto.getUsername());
		TaiKhoan taiKhoan ;
		if(!taiKhoanDB.isPresent()) return new ResponseObject(HttpStatus.NOT_FOUND, null);
		else taiKhoan = taiKhoanDB.get();
		
		if (taiKhoan.getTrangThai() == true) return new ResponseObject(HttpStatus.ALREADY_REPORTED,null);
		
		String verificationCode = new String();
		if (ObjectUtils.isNotEmpty(taiKhoan)) verificationCode = taiKhoan.getOtp();
		else return new ResponseObject(HttpStatus.UNAUTHORIZED, null);
		if (ObjectUtils.isNotEmpty(verificationDto.getVerificationCode()) && ObjectUtils.isNotEmpty(verificationCode)
				&& verificationDto.getVerificationCode().equals(verificationCode)) {
			taiKhoan.setTrangThai(true);
			taiKhoan.setOtp(null);
			taiKhoanRepository.save(taiKhoan);
			TaskManager.cancelTask("otp-" + verificationDto.getUsername());
			return new ResponseObject(HttpStatus.ACCEPTED, null);
		}
		return new ResponseObject(HttpStatus.BAD_REQUEST, null);
	}

	@Override
	public ResponseObject getNewVerification(String username) throws MessagingException {
		Optional<TaiKhoan> taiKhoanDB = taiKhoanRepository.findById(username);
		TaiKhoan taiKhoan;
		if(!taiKhoanDB.isPresent())return new ResponseObject(HttpStatus.NOT_FOUND, null);
		else taiKhoan = taiKhoanDB.get();
		
		if(taiKhoan.getTrangThai() == true)
		{
			return new ResponseObject(HttpStatus.ALREADY_REPORTED, null);
		}
		
		String verifyCode = VerificationCodeGenerator.generate();
		emailSenderService.sendVerificationEmail(taiKhoan.getEmail(), taiKhoan.getUsername(), verifyCode);
		taiKhoan.setOtp(verifyCode);
		taiKhoanRepository.save(taiKhoan);
		VerifyCodeManager verifyCodeManager = new VerifyCodeManager();
		ScheduledFuture<?> scheduledFuture =  verifyCodeManager.scheduleVerificationCleanup(SessionConstant.OTP_EXPIRE_TIME * 1000, taiKhoan.getUsername(),
				taiKhoanRepository);
		TaskManager.addTask("otp-" + taiKhoan.getUsername(), scheduledFuture);
		String email = StringUtils.hideEmail(taiKhoan.getEmail());
		return new ResponseObject(HttpStatus.ACCEPTED, email);
	}

	@Override
	public ResponseObject forget(String username) throws MessagingException {
		Optional<TaiKhoan> taiKhoanDB = taiKhoanRepository.findById(username);
		TaiKhoan taiKhoan;
		if(!taiKhoanDB.isPresent())return new ResponseObject(HttpStatus.NOT_FOUND, null);
		else taiKhoan = taiKhoanDB.get();
		
		if(taiKhoan.getTrangThai() == false)
		{
			return new ResponseObject(HttpStatus.UNAUTHORIZED , null);
		}
		String verifyCode = VerificationCodeGenerator.generate();
		emailSenderService.sendVerificationEmail(taiKhoan.getEmail(), taiKhoan.getUsername(), verifyCode);
		taiKhoan.setOtp(verifyCode);
		taiKhoanRepository.save(taiKhoan);
		VerifyCodeManager verifyCodeManager = new VerifyCodeManager();
		ScheduledFuture<?>  scheduledFuture = verifyCodeManager.scheduleVerificationCleanup(SessionConstant.OTP_EXPIRE_TIME * 1000, taiKhoan.getUsername(), taiKhoanRepository);
		TaskManager.addTask("otp-" + username, scheduledFuture);
		String email = StringUtils.hideEmail(taiKhoan.getEmail());
		return new ResponseObject(HttpStatus.OK, email);
	}

	@Override
	public ResponseObject resetPassword(ResetPasswordRequest request) {
		Optional<TaiKhoan> taiKhoanDB = taiKhoanRepository.findById(request.getUsername());
		TaiKhoan taiKhoan;
		if(!taiKhoanDB.isPresent())return new ResponseObject(HttpStatus.NOT_FOUND, null);
		else taiKhoan = taiKhoanDB.get();
		
		if(taiKhoan.getTrangThai() == false)
		{
			return new ResponseObject(HttpStatus.UNAUTHORIZED, null);
		}
		if(!request.getVerificationCode().equals(taiKhoan.getOtp()))
		{
			return new ResponseObject(HttpStatus.BAD_REQUEST, null);
		}
		String hashPasword = passwordEncoder.encode(request.getPassword());
		taiKhoan.setPassword(hashPasword);
		taiKhoan.setOtp(null);
		TaskManager.cancelTask("otp-" + request.getUsername());
		taiKhoanRepository.save(taiKhoan);
		return new ResponseObject(HttpStatus.ACCEPTED, null);
	}
}
