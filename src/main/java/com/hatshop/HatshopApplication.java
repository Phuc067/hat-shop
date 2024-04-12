package com.hatshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.hatshop.repository.GiaRepository;
import com.hatshop.repository.QuyenRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class HatshopApplication {

	@Autowired
	private GiaRepository giaRepository;

	@Autowired
	private QuyenRepository quyenRepository;

	public static void main(String[] args) {
		SpringApplication.run(HatshopApplication.class, args);
	}

	@PostConstruct
	public void run() {
	}
}
