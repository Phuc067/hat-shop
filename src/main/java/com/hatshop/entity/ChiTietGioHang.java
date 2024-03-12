package com.hatshop.entity;

import java.io.Serializable;

import com.hatshop.identity.ChiTietDonHangId;
import com.hatshop.identity.ChiTietGioHangId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class ChiTietGioHang implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6620439321292227240L;

	@EmbeddedId
	private ChiTietGioHangId id;
	
	private int soLuong;
	
	private Double donGia;

	public ChiTietGioHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietGioHang(ChiTietGioHangId id, int soLuong, Double donGia) {
		super();
		this.id = id;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public ChiTietGioHangId getId() {
		return id;
	}

	public void setId(ChiTietGioHangId id) {
		this.id = id;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Double getDonGia() {
		return donGia;
	}

	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
