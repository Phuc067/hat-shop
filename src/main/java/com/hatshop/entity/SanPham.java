package com.hatshop.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPham  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3185265525973284080L;

	@Id
	private String maSanPham;
	
	@Column
	private String tenSanPham;
	
	@Column
	private int soLuong;
	
	private String gioiTinh;
	
	private String mauSac;
	
	private String hinhAnh;
	
	private Boolean trangThai;
	
	@ManyToOne
	@JoinColumn(name = "MaKieuDang", referencedColumnName = "maKieuDang")
	private KieuDang kieuDang;

	public SanPham(String maSanPham) {
		super();
		this.maSanPham = maSanPham;
	}
}
