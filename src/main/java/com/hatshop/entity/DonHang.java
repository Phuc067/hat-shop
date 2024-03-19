package com.hatshop.entity;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DonHang implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7943092468625276174L;
	
	@Id
	private String maDonHang;
	
	private Instant ngayDat;
	
	private Instant ngayGiao;
	
	private String trangThai;
	
	private String tenNguoiNhan;
	
	private String diaChiNguoiNhan;
	
	private String sdtNguoiNhan;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaKhachHang", referencedColumnName = "maKhachHang")
	private KhachHang khachHang;
	
}
