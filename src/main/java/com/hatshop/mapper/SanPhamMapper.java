package com.hatshop.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hatshop.component.ApplicationContextProvider;
import com.hatshop.dto.SanPhamDto;
import com.hatshop.entity.Gia;
import com.hatshop.entity.KieuDang;
import com.hatshop.entity.SanPham;
import com.hatshop.repository.GiaRepository;

@Mapper
public interface SanPhamMapper {	
	
	SanPhamMapper INSTANT  = Mappers.getMapper(SanPhamMapper.class);
	
	@Mapping(source = "sanpham.kieuDang.maKieuDang", target = "maKieuDang")
	@Mapping(target = "gia", expression = "java(getGia(sanpham))")
	SanPhamDto entityToDto(SanPham sanpham);
	
	default String mapKieuDangMaKieuDang(KieuDang kieuDang) {
        return kieuDang != null ? kieuDang.getMaKieuDang() : null;
    }
	
	default Double getGia(SanPham sanpham) {
        if (sanpham == null || sanpham.getMaSanPham() == null) {
            return null;
        }
        GiaRepository giaRepository = ApplicationContextProvider.getBean(GiaRepository.class); // Lấy bean của GiaRepository từ Spring context
        SanPhamDto sanPhamDto = new SanPhamDto();
        sanPhamDto.setMaSanPham(sanpham.getMaSanPham());
        Gia gia = giaRepository.findBySanPhamAndNgayHetHan(sanpham, null);
        return gia != null ? gia.getGia() : null;
    }
	
	List<SanPhamDto> entityToDtos(List<SanPham> sanPhams);
	
	@InheritInverseConfiguration
	SanPham dtoToEntity(SanPhamDto sanPhamDto);
}
