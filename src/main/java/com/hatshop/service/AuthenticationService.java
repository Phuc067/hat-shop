package com.hatshop.service;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;

import com.hatshop.dto.LoginDto;
import com.hatshop.dto.RegisterDto;
import com.hatshop.dto.ResetPasswordRequest;
import com.hatshop.dto.VerificationRequest;
import com.hatshop.model.ResponseObject;

import jakarta.mail.MessagingException;


public interface AuthenticationService {
	ResponseObject login(LoginDto loginDto);
	ResponseObject register(RegisterDto registerDto) throws MessagingException;
	ResponseObject verification(VerificationRequest verificationDto) ;
	ResponseObject getNewVerification(String username) throws MessagingException;
	ResponseObject forget(String username) throws MessagingException;
	ResponseObject resetPassword(ResetPasswordRequest request);
}
