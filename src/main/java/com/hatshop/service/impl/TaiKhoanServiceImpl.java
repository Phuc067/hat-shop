package com.hatshop.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hatshop.dto.ChangePasswordDto;
import com.hatshop.entity.TaiKhoan;
import com.hatshop.model.ResponseObject;
import com.hatshop.repository.TaiKhoanRepository;
import com.hatshop.service.TaiKhoanService;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
	
	@Autowired
	private TaiKhoanRepository taiKhoanRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public ResponseObject changePassword(ChangePasswordDto changePasswordDto) {
		Optional<TaiKhoan> taiKhoanDB = taiKhoanRepository.findById(changePasswordDto.getUsername());
		TaiKhoan taiKhoan;
		if(!taiKhoanDB.isPresent()) return new ResponseObject(HttpStatus.NOT_FOUND, null);
		else taiKhoan = taiKhoanDB.get();
			
		if(taiKhoan.getTrangThai() == false) return new ResponseObject(HttpStatus.UNAUTHORIZED, null);
		
		if(passwordEncoder.matches(changePasswordDto.getOldPassword(), taiKhoan.getPassword()))
		{
			String hashPassword = passwordEncoder.encode(changePasswordDto.getNewPassword());
			taiKhoan.setPassword(hashPassword);
			taiKhoanRepository.save(taiKhoan);
			return new ResponseObject(HttpStatus.ACCEPTED, null);
		}
		else return new ResponseObject(HttpStatus.BAD_REQUEST, null);
		
	
		
	}
	
}
