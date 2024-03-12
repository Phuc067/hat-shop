package com.hatshop.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Quyen")
public class Quyen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2272899358635613062L;
	
	@Id
	private String maQuyen;
	
	@Column
	private String tenQuyen;

	public Quyen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quyen(String maQuyen, String tenQuyen) {
		super();
		this.maQuyen = maQuyen;
		this.tenQuyen = tenQuyen;
	}

	public String getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(String maQuyen) {
		this.maQuyen = maQuyen;
	}

	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
