package com.hatshop.entity;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
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
	
	@ManyToOne
	@JoinColumn(name = "MaKhachHang", referencedColumnName = "maKhachHang")
	private KhachHang khachHang;

	public DonHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DonHang(String maDonHang, Instant ngayDat, Instant ngayGiao, String trangThai, String tenNguoiNhan,
			String diaChiNguoiNhan, String sdtNguoiNhan, KhachHang khachHang) {
		super();
		this.maDonHang = maDonHang;
		this.ngayDat = ngayDat;
		this.ngayGiao = ngayGiao;
		this.trangThai = trangThai;
		this.tenNguoiNhan = tenNguoiNhan;
		this.diaChiNguoiNhan = diaChiNguoiNhan;
		this.sdtNguoiNhan = sdtNguoiNhan;
		this.khachHang = khachHang;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public Instant getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Instant ngayDat) {
		this.ngayDat = ngayDat;
	}

	public Instant getNgayGiao() {
		return ngayGiao;
	}

	public void setNgayGiao(Instant ngayGiao) {
		this.ngayGiao = ngayGiao;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getTenNguoiNhan() {
		return tenNguoiNhan;
	}

	public void setTenNguoiNhan(String tenNguoiNhan) {
		this.tenNguoiNhan = tenNguoiNhan;
	}

	public String getDiaChiNguoiNhan() {
		return diaChiNguoiNhan;
	}

	public void setDiaChiNguoiNhan(String diaChiNguoiNhan) {
		this.diaChiNguoiNhan = diaChiNguoiNhan;
	}

	public String getSdtNguoiNhan() {
		return sdtNguoiNhan;
	}

	public void setSdtNguoiNhan(String sdtNguoiNhan) {
		this.sdtNguoiNhan = sdtNguoiNhan;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
