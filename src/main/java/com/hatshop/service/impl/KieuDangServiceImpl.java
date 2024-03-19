package com.hatshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hatshop.entity.KieuDang;
import com.hatshop.model.ResponseObject;
import com.hatshop.repository.KieuDangRepository;
import com.hatshop.service.KieuDangService;

@Service
public class KieuDangServiceImpl implements KieuDangService {

	@Autowired
	private KieuDangRepository kieuDangRepository;

	@Override
	public ResponseObject findAll() {
		try {
			List<KieuDang> kieuDangs = kieuDangRepository.findAll();
			return new ResponseObject(HttpStatus.OK, kieuDangs);
		} catch (Exception e) {
			return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}

	}

	@Override
	public ResponseObject add(KieuDang kieuDang) {
		try {
			if (kieuDangRepository.existsById(kieuDang.getMaKieuDang())) {
				return new ResponseObject(HttpStatus.CONFLICT, null);
			}
			kieuDangRepository.save(kieuDang);
			return new ResponseObject(HttpStatus.ACCEPTED, null);
		} catch (Exception e) {
			return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@Override
	public ResponseObject edit(KieuDang kieuDang) {
		try {
			if (kieuDangRepository.existsById(kieuDang.getMaKieuDang())) {
				kieuDangRepository.save(kieuDang);
				return new ResponseObject(HttpStatus.ACCEPTED, null);
			}
			else return new ResponseObject(HttpStatus.NOT_FOUND, null);
		} catch (Exception e) {
			return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@Override
	public ResponseObject delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
