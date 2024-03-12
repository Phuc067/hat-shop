package com.hatshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hatshop.entity.ChiTietDonHang;
import com.hatshop.identity.ChiTietDonHangId;
import com.hatshop.repository.ChiTietDonHangRepository;
import com.hatshop.service.ChiTietDonHangService;

@Service
public class ChiTietDonHangServiceImpl implements ChiTietDonHangService{

	@Autowired
	private ChiTietDonHangRepository chiTietDonHangRepository;
	
	@Override
	public ChiTietDonHang findByID(ChiTietDonHangId id) {
		return chiTietDonHangRepository.findById(id).get();
	}

}
