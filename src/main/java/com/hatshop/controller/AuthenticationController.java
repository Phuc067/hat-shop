package com.hatshop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hatshop.dto.LoginDto;
import com.hatshop.dto.RegisterDto;
import com.hatshop.dto.VerificationRequest;
import com.hatshop.model.ResponseObject;
import com.hatshop.service.AuthenticationService;

import jakarta.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("")
	public ResponseEntity<Object> dangNhap(@RequestBody LoginDto loginDto) {
		ResponseObject responseObject = authenticationService.login(loginDto);
		return ResponseEntity.status(responseObject.getHttpStatus()).body(responseObject.getObject());
	}
	
	@PostMapping("/register")
	public ResponseEntity<Object> dangKy(@RequestBody RegisterDto registerDto) throws MessagingException
	{
		ResponseObject responseObject = authenticationService.register(registerDto);
		return ResponseEntity.status(responseObject.getHttpStatus()).body(responseObject.getObject());
	}
	
	@PostMapping("/verification")
	public ResponseEntity<Object> yeuCauXacMinh(@RequestBody LoginDto loginDto) throws MessagingException
	{
		ResponseObject responseObject = authenticationService.getNewVerification(loginDto.getUsername());
		return ResponseEntity.status(responseObject.getHttpStatus()).body(responseObject.getObject());
	}
	
	@PutMapping("/verification")
	public ResponseEntity<Object> xacMinh(@RequestBody VerificationRequest request)
	{
		ResponseObject responseObject = authenticationService.verification(request);
		return ResponseEntity.status(responseObject.getHttpStatus()).body(responseObject.getObject());
	}
}
