package com.hatshop.service;

import com.hatshop.entity.ChiTietDonHang;
import com.hatshop.identity.ChiTietDonHangId;

public interface ChiTietDonHangService {
	public ChiTietDonHang findByID(ChiTietDonHangId id);
}
