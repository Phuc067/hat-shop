package com.hatshop.service;

import jakarta.mail.MessagingException;

public interface EmailSenderService {
	void sendVerificationEmail(String toEmail,String username, String verificationCode) throws MessagingException;
}
