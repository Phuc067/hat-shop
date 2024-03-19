package com.hatshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hatshop.entity.KieuDang;
import com.hatshop.model.ResponseObject;
import com.hatshop.service.KieuDangService;

@RestController
@RequestMapping(value = "api/kieu-dang")
public class KieuDangController {
	@Autowired
	private KieuDangService kieuDangService;
	
	
	@GetMapping("")
	public ResponseEntity<Object> doGetAllKieuDang() {
		ResponseObject responseObject= kieuDangService.findAll();
		return ResponseEntity.status(responseObject.getHttpStatus()).body(responseObject.getObject());
	}
	
	@PostMapping("")
	public ResponseEntity<?> doAddKieuDang(@RequestBody KieuDang kieuDang)
	{
		ResponseObject responseObject = kieuDangService.add(kieuDang);
		return ResponseEntity.status(responseObject.getHttpStatus()).body(responseObject.getObject());
	}
	
	@PutMapping("")
	public ResponseEntity<?> doEditKieuDang(@RequestBody KieuDang kieuDang)
	{
		ResponseObject responseObject = kieuDangService.edit(kieuDang);
		return ResponseEntity.status(responseObject.getHttpStatus()).body(responseObject.getObject());
	}
	
	
}
