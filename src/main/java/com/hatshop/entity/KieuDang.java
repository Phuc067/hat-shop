package com.hatshop.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "KieuDang")
public class KieuDang implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7906479815631242251L;

	@Id
	private String maKieuDang;
	
	@Column
	private String tenKieuDang;

	public KieuDang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KieuDang(String maKieuDang, String tenKieuDang) {
		super();
		this.maKieuDang = maKieuDang;
		this.tenKieuDang = tenKieuDang;
	}

	public String getMaKieuDang() {
		return maKieuDang;
	}

	public void setMaKieuDang(String maKieuDang) {
		this.maKieuDang = maKieuDang;
	}

	public String getTenKieuDang() {
		return tenKieuDang;
	}

	public void setTenKieuDang(String tenKieuDang) {
		this.tenKieuDang = tenKieuDang;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
