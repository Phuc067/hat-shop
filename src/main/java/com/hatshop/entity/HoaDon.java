package com.hatshop.entity;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class HoaDon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8309639016029767770L;

	
	@Id
	private String maHoaDon;
	
	private Instant ngayTao;
	
	private Double tongGiaTri;
	
	@OneToOne
	@JoinColumn(name = "MaDonHang", referencedColumnName = "maDonHang")
	private DonHang donHang;

	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String maHoaDon, Instant ngayTao, Double tongGiaTri, DonHang donHang) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayTao = ngayTao;
		this.tongGiaTri = tongGiaTri;
		this.donHang = donHang;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public Instant getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Instant ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Double getTongGiaTri() {
		return tongGiaTri;
	}

	public void setTongGiaTri(Double tongGiaTri) {
		this.tongGiaTri = tongGiaTri;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
