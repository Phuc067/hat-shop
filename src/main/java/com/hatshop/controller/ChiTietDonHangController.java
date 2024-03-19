package com.hatshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hatshop.identity.ChiTietDonHangId;
import com.hatshop.service.ChiTietDonHangService;

@RestController
@RequestMapping(value = "api/chi-tiet-don-hang")
public class ChiTietDonHangController {
	
	@Autowired
	private ChiTietDonHangService chiTietDonHangService;
	
	@GetMapping(value = "")
	public ResponseEntity<?> doGetChiTietDonHang(@RequestBody ChiTietDonHangId id)
	{
		return ResponseEntity.ok(chiTietDonHangService.findByID(id));
	}
	
	
}
