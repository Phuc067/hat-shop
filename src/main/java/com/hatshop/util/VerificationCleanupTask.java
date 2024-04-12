package com.hatshop.util;

import java.util.TimerTask;

import com.hatshop.repository.TaiKhoanRepository;


public class VerificationCleanupTask extends TimerTask {
	private String username;

    private TaiKhoanRepository loginRepository;
    
    
    public VerificationCleanupTask(String username, TaiKhoanRepository loginRepository) {
		super();
		this.username = username;
		this.loginRepository = loginRepository;
	}

	@Override
	
    public void run() {     
       loginRepository.removeVerificationCode(username);
    }
}
