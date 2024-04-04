package com.hatshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hatshop.dto.SanPhamDto;
import com.hatshop.entity.SanPham;
import com.hatshop.model.ResponseObject;
import com.hatshop.service.SanPhamService;

@RestController
@RequestMapping(value = "api/products")
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
	
	@PostMapping("")
	public ResponseEntity<Object> themSanPham(@RequestBody SanPhamDto sanPham)
	{
		ResponseObject responseObject = sanPhamService.insert(sanPham);
		return ResponseEntity.status(responseObject.getHttpStatus()).body(responseObject.getObject());
	}
	
	@PutMapping("")
	public ResponseEntity<Object> suaSanPham(@RequestBody SanPhamDto sanPham)
	{
		ResponseObject responseObject = sanPhamService.update(sanPham);
		return ResponseEntity.status(responseObject.getHttpStatus()).body(responseObject.getObject());
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> xoaSanPham(@PathVariable("id") String id)
	{
		ResponseObject responseObject = sanPhamService.delete(id);
		return ResponseEntity.status(responseObject.getHttpStatus()).body(responseObject.getObject());
	}
}
