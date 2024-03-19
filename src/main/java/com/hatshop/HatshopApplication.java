package com.hatshop;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.hatshop.entity.Gia;
import com.hatshop.entity.SanPham;
import com.hatshop.mapper.SanPhamMapper;
import com.hatshop.mapper.SanPhamMapperImpl;
import com.hatshop.repository.GiaRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class HatshopApplication {
	
	@Autowired
	private GiaRepository giaRepository;

	public static void main(String[] args) {
		SpringApplication.run(HatshopApplication.class, args);
	}
	 @Bean
	  public SanPhamMapper sanPhamMapper() {
	    return new SanPhamMapperImpl();
	  }

	@PostConstruct
	public void run() {
		Gia gia = giaRepository.findBySanPhamAndNgayHetHan(new SanPham("h019177"), null);
		if(ObjectUtils.isNotEmpty(gia))
		{
		}
		
	}
}
