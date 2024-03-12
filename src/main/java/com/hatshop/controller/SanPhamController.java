package com.hatshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hatshop.entity.SanPham;
import com.hatshop.service.SanPhamService;

@RestController
@RequestMapping(value = "api/sanPham")
public class SanPhamController {
	
	@Autowired
	private SanPhamService sanPhamService;
	
	@GetMapping(value = "")
	public ResponseEntity<?> doGetAllSanPham()
	{
		List<SanPham> sanPhams = sanPhamService.findAll();
		return ResponseEntity.ok(sanPhams);
	}
}
