package com.hatshop.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hatshop.dto.SanPhamDto;
import com.hatshop.entity.SanPham;
import com.hatshop.mapper.SanPhamMapper;
import com.hatshop.model.ResponseObject;
import com.hatshop.repository.SanPhamRepository;
import com.hatshop.service.SanPhamService;

@Service
public class SanPhamServiceImpl implements SanPhamService{
	
	@Autowired
	private SanPhamRepository sanPhamRepository;
	
	@Autowired
	private SanPhamMapper sanPhamMapper;

	@Override
	public ResponseObject findAll() {
		List<SanPham> sanPhams = sanPhamRepository.findAll();
		List<SanPhamDto> sanPhamDtos = sanPhamMapper.entityToDtos(sanPhams);
		return new ResponseObject(HttpStatus.OK, sanPhamDtos);
	}

	@Override
	public ResponseObject findByMaSanPham(String maSanPham) {
		Optional<SanPham> sanPham = sanPhamRepository.findById(maSanPham);
		SanPhamDto sanPhamDto;
		if(sanPham.isPresent())
		{
			sanPhamDto = sanPhamMapper.entityToDto(sanPham.get());
			return new ResponseObject(HttpStatus.OK, sanPhamDto);
		}
		else return new ResponseObject(HttpStatus.NOT_FOUND, null);
			
		
		
	}

}
