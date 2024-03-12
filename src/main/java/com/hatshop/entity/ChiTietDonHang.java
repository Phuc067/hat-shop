package com.hatshop.entity;

import java.io.Serializable;

import com.hatshop.identity.ChiTietDonHangId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ChiTietDonHang implements Serializable {

	private static final long serialVersionUID = 3192485885859239691L;

	@EmbeddedId
	private ChiTietDonHangId id;
	
	private int soLuong;
	
	private double donGia;

	public ChiTietDonHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietDonHang(ChiTietDonHangId id, int soLuong, double donGia) {
		super();
		this.id = id;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public ChiTietDonHangId getId() {
		return id;
	}

	public void setId(ChiTietDonHangId id) {
		this.id = id;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}


