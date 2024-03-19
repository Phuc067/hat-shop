package com.hatshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hatshop.model.ResponseObject;
import com.hatshop.service.SanPhamService;

@RestController
@RequestMapping(value = "api/san-pham")
public class SanPhamController {
	
	@Autowired
	private SanPhamService sanPhamService;
	
	@GetMapping("")
	public ResponseEntity<Object> layTatCaSanPham()
	{
		ResponseObject responseObject = sanPhamService.findAll();
		return ResponseEntity.status(responseObject.getHttpStatus()).body(responseObject.getObject());
	}
	
	@GetMapping("/{maSanPham}")
	public ResponseEntity<Object> laySanPhamSanPhamTheoMa(@PathVariable("maSanPham") String maSanPham)
	{
		ResponseObject responseObject = sanPhamService.findByMaSanPham(maSanPham);
		return ResponseEntity.status(responseObject.getHttpStatus()).body(responseObject.getObject());
	}
}
