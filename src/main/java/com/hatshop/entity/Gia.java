package com.hatshop.entity;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Gia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3280353155339313842L;

	@Id
	private String maGia;
	
	private Instant ngayHieuLuc;
	
	private Instant ngayHetHan;
	
	private Double gia;
	
	@ManyToOne
	@JoinColumn(name = "MaSanPham", referencedColumnName = "maSanPham")
	private SanPham sanPham;

	public Gia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gia(String maGia, Instant ngayHieuLuc, Instant ngayHetHan, Double gia, SanPham sanPham) {
		super();
		this.maGia = maGia;
		this.ngayHieuLuc = ngayHieuLuc;
		this.ngayHetHan = ngayHetHan;
		this.gia = gia;
		this.sanPham = sanPham;
	}

	public String getMaGia() {
		return maGia;
	}

	public void setMaGia(String maGia) {
		this.maGia = maGia;
	}

	public Instant getNgayHieuLuc() {
		return ngayHieuLuc;
	}

	public void setNgayHieuLuc(Instant ngayHieuLuc) {
		this.ngayHieuLuc = ngayHieuLuc;
	}

	public Instant getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(Instant ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public Double getGia() {
		return gia;
	}

	public void setGia(Double gia) {
		this.gia = gia;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
