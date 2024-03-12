package com.hatshop.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
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
	
	@ManyToOne
	@JoinColumn(name = "MaKieuDang", referencedColumnName = "maKieuDang")
	private KieuDang kieuDang;

	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanPham(String maSanPham, String tenSanPham, int soLuong, KieuDang kieuDang) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.kieuDang = kieuDang;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public KieuDang getkieuDang() {
		return kieuDang;
	}

	public void setkieuDang(KieuDang kieuDang) {
		this.kieuDang = kieuDang;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
