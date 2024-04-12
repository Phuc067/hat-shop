package com.hatshop.service;

import com.hatshop.entity.RefreshToken;
import com.hatshop.entity.TaiKhoan;
import com.hatshop.model.ResponseObject;


public interface RefreshTokenService {
	RefreshToken createRefreshToken(TaiKhoan taiKhoan);

	ResponseObject genarateAccessToken(String request);
}
