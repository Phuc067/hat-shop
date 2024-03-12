package com.hatshop.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
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
	
	@OneToOne
	@JoinColumn(name = "Username", referencedColumnName = "username")
	private TaiKhoan taiKhoan;

	public KhachHang(String maKhachHang, String ho, String ten, String email, String sdt, String gioiTinh,
			TaiKhoan taiKhoan) {
		super();
		this.maKhachHang = maKhachHang;
		this.ho = ho;
		this.ten = ten;
		this.email = email;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.taiKhoan = taiKhoan;
	}

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
