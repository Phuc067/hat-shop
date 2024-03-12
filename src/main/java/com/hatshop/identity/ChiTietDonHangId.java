package com.hatshop.identity;

import java.io.Serializable;

import com.hatshop.entity.DonHang;
import com.hatshop.entity.SanPham;

import jakarta.persistence.Embeddable;

@Embeddable
public class ChiTietDonHangId implements Serializable{
	private String maDonHang;
	
	private String maSanPham;

	public ChiTietDonHangId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietDonHangId(String maDonHang, String maSanPham) {
		super();
		this.maDonHang = maDonHang;
		this.maSanPham = maSanPham;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	
}
