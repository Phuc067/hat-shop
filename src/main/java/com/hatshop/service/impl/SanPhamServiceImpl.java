package com.hatshop.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hatshop.dto.SanPhamDto;
import com.hatshop.entity.Gia;
import com.hatshop.entity.SanPham;
import com.hatshop.mapper.SanPhamMapper;
import com.hatshop.model.ResponseObject;
import com.hatshop.repository.GiaRepository;
import com.hatshop.repository.SanPhamRepository;
import com.hatshop.service.SanPhamService;
import com.hatshop.util.TimeUtil;

import jakarta.transaction.Transactional;

@Service
public class SanPhamServiceImpl implements SanPhamService{
	
	@Autowired
	private SanPhamRepository sanPhamRepository;
	
	@Autowired
	private SanPhamMapper sanPhamMapper;
	
	@Autowired 
	private GiaRepository giaRepository;

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

	@Override
	@Transactional
	public ResponseObject insert(SanPhamDto sanPham) {
		if(sanPhamRepository.existsById(sanPham.getMaSanPham()))
		{
			return new ResponseObject(HttpStatus.CONFLICT, null);
		}
		SanPham sanPhamResponse = sanPhamRepository.save(sanPhamMapper.dtoToEntity(sanPham));
		Gia gia = new Gia();
		Instant now = TimeUtil.getInstantNow();
		String maxId = giaRepository.findMaxId();
		String maGia =  String.format("G%07d", Integer.parseInt(maxId.substring(1)) + 1);
		gia.setMaGia(maGia);
		gia.setGia(sanPham.getGia());
		gia.setNgayHieuLuc(now);
		gia.setSanPham(sanPhamResponse);
		giaRepository.save(gia);
		SanPhamDto sanPhamDto = sanPhamMapper.entityToDto(sanPhamResponse);
		if(ObjectUtils.isNotEmpty(sanPhamResponse ))
		{
			return new ResponseObject(HttpStatus.OK, sanPhamDto);
		}
		else return new ResponseObject(HttpStatus.NOT_FOUND, null);
			
	}

	@Override
	@Transactional
	public ResponseObject update(SanPhamDto sanPhamDto) {
		SanPham sanPham = sanPhamMapper.dtoToEntity(sanPhamDto);
		SanPham sanPhamResponse = sanPhamRepository.saveAndFlush(sanPham);
		Gia gia = giaRepository.findBySanPhamAndNgayHetHan(new SanPham(sanPhamDto.getMaSanPham()), null);
		if(Double.compare(gia.getGia(), sanPhamDto.getGia()) !=0)
		{
			Gia newGia = new Gia();
			Instant now = TimeUtil.getInstantNow();
			String maxId = giaRepository.findMaxId();
			String maGia =  String.format("G%07d", Integer.parseInt(maxId.substring(1)) + 1);
			newGia.setMaGia(maGia);
			newGia.setGia(sanPhamDto.getGia());
			newGia.setNgayHieuLuc(now);
			newGia.setSanPham(sanPhamResponse);
			giaRepository.save(newGia);
			
			gia.setNgayHetHan(now);
			giaRepository.saveAndFlush(gia);
		}
		
		return new ResponseObject(HttpStatus.ACCEPTED, sanPhamResponse);
	}

	@Override
	public ResponseObject delete(String id) {
		try {
			sanPhamRepository.deleteById(id);
			return new ResponseObject(HttpStatus.ACCEPTED, null);
		}
		catch (Exception e) {	
			e.printStackTrace();
			return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
		
	}
	


}
