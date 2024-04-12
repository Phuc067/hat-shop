package com.hatshop.service;

import com.hatshop.dto.ChangePasswordDto;
import com.hatshop.model.ResponseObject;

public interface TaiKhoanService {
	ResponseObject changePassword(ChangePasswordDto changePasswordDto);
}
