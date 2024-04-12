package com.hatshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.hatshop.dto.RegisterDto;
import com.hatshop.entity.TaiKhoan;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface TaiKhoanMapper {
	
	TaiKhoanMapper INSTANCE = Mappers.getMapper(TaiKhoanMapper.class);
	
	
	@Mapping(target = "trangThai", constant = "false") 
    TaiKhoan registerToTaiKhoan(RegisterDto registerDto);
}
