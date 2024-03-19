package com.hatshop.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "KhachHang")
public class KhachHang implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4977556365635417141L;

	
	@Id
	private String maKhachHang;
	
	@Column
	private String ho;
	
	@Column
	private String ten;
	
	@Column
	private String email;
	
	@Column
	private String sdt;
	
	@Column
	private String gioiTinh;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Username", referencedColumnName = "username")
	private TaiKhoan taiKhoan;

}
