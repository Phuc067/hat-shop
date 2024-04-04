package com.hatshop.service;

import java.util.List;

import com.hatshop.dto.SanPhamDto;
import com.hatshop.entity.SanPham;
import com.hatshop.model.ResponseObject;

public interface SanPhamService {
	ResponseObject findAll();
	ResponseObject findByMaSanPham(String maSanPham);
	ResponseObject insert(SanPhamDto sanPham);
	ResponseObject update(SanPhamDto sanPhamDto);
	ResponseObject delete(String id);
}
