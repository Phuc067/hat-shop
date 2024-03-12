package com.hatshop.identity;

import jakarta.persistence.Embeddable;

@Embeddable
public class ChiTietGioHangId {
	private String maKhachHang;
	private String maSanPham;
	public ChiTietGioHangId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietGioHangId(String maKhachHang, String maSanPham) {
		super();
		this.maKhachHang = maKhachHang;
		this.maSanPham = maSanPham;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	
}
