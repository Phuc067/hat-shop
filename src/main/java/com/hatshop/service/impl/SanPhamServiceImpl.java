package com.hatshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hatshop.entity.SanPham;
import com.hatshop.repository.SanPhamRepository;
import com.hatshop.service.SanPhamService;

@Service
public class SanPhamServiceImpl implements SanPhamService{
	
	@Autowired
	private SanPhamRepository sanPhamRepository;

	@Override
	public List<SanPham> findAll() {
		
		return sanPhamRepository.findAll();
	}

}
