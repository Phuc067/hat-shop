package com.hatshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hatshop.dto.ChangePasswordDto;
import com.hatshop.model.ResponseObject;
import com.hatshop.service.TaiKhoanService;

@RestController
@RequestMapping("/api/logins")
public class TaiKhoanController {
	
	@Autowired
	private TaiKhoanService taiKhoanService;
	
	@PostMapping("/change-password")
	public ResponseEntity<Object> doiMatKhau(@RequestBody ChangePasswordDto changePasswordDto)
	{
		ResponseObject responseObject = taiKhoanService.changePassword(changePasswordDto);
		return ResponseEntity.status(responseObject.getHttpStatus()).body(responseObject.getObject());
	}
}
