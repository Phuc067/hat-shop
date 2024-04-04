package com.hatshop.dto;

import com.hatshop.entity.KieuDang;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SanPhamDto {
	@Size(max = 15, message = "Mã sản phẩm không vượt quá 15 ký tự!")
	private String maSanPham;
	
	@NotBlank
	@Size(max = 100, message = "Tên sản phẩm không vượt quá 100 ký tự!")
	private String tenSanPham;
	
	@NotBlank
	private int soLuong;
	
	private String gioiTinh;
	
	@Size(max = 30, message = "Màu sắc không vượt quá 100 ký tự!")
	private String mauSac;
	
	private String hinhAnh;
	
	@NotBlank
	private Boolean trangThai;
	
	@NotBlank
	private KieuDang kieuDang;
	
	@NotBlank
	private Double gia;
	
}
