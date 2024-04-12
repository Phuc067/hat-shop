package com.hatshop.service.impl;

import java.time.Instant;
import java.util.UUID;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hatshop.constant.SessionConstant;
import com.hatshop.entity.RefreshToken;
import com.hatshop.entity.TaiKhoan;
import com.hatshop.model.ResponseObject;
import com.hatshop.repository.RefreshTokenRepository;
import com.hatshop.service.JwtService;
import com.hatshop.service.RefreshTokenService;


@Service
public class RefreshTokenServiceImpl implements RefreshTokenService{

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	@Autowired
	private JwtService jwtService;
	
	@Override
	public RefreshToken createRefreshToken(TaiKhoan taiKhoan)
	{
		RefreshToken refreshToken = refreshTokenRepository.findByTaiKhoan(taiKhoan);
		if(refreshToken!=null)
		{
			if(isExpired(refreshToken))
			{
				refreshTokenRepository.delete(refreshToken);
				RefreshToken newRefreshToken = new RefreshToken();
				newRefreshToken.setTaiKhoan(taiKhoan);
				newRefreshToken.setExpriryDate(Instant.now().plusMillis(SessionConstant.REFRESH_TOKEN_EXPRIRY_TIME));
				newRefreshToken.setToken(UUID.randomUUID().toString());
				return refreshTokenRepository.save(newRefreshToken);
			}
			else return refreshToken;
		}
		else {
			RefreshToken newRefreshToken = new RefreshToken();
			newRefreshToken.setTaiKhoan(taiKhoan);
			newRefreshToken.setExpriryDate(Instant.now().plusMillis(SessionConstant.REFRESH_TOKEN_EXPRIRY_TIME));
			newRefreshToken.setToken(UUID.randomUUID().toString());
			return refreshTokenRepository.save(newRefreshToken);
		}
	}

	@Override
	public ResponseObject genarateAccessToken(String request) {
		RefreshToken refreshToken = refreshTokenRepository.findByToken(request);
		if(ObjectUtils.isEmpty(refreshToken) )
		{
			return new ResponseObject(HttpStatus.NOT_FOUND, null);
		}
		if(isExpired(refreshToken))
		{
			refreshTokenRepository.delete(refreshToken);
			return new ResponseObject(HttpStatus.BAD_REQUEST, null);
		}
		String accessToken = jwtService.generateToken(refreshToken.getTaiKhoan());
		return new ResponseObject(HttpStatus.OK, accessToken);
	}
	
	public Boolean isExpired(RefreshToken refreshToken)
	{
		return refreshToken.getExpriryDate().compareTo(Instant.now()) < 0 ? true : false;
	}
}
