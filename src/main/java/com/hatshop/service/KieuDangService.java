package com.hatshop.service;

import java.util.List;

import com.hatshop.entity.KieuDang;
import com.hatshop.model.ResponseObject;

public interface KieuDangService {
	public ResponseObject findAll();
	public ResponseObject add(KieuDang kieuDang);
	public ResponseObject edit(KieuDang kieuDang);
	public ResponseObject delete(int id);
}
