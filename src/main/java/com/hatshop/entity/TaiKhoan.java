package com.hatshop.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3726346264899186974L;

	@Id
	private String username;
	
	@Column(name = "Pass")
	private String password;
	
	@Email
	@Column
	private String email;
	
	@Column
	private String otp;
	
	@Column
	private Boolean trangThai;
	
	@ManyToOne
	@JoinColumn(name = "maQuyen", referencedColumnName = "maQuyen")
	private Quyen quyen;

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan(String username, String password, @Email String email, String otp, Boolean trangThai, Quyen quyen) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.otp = otp;
		this.trangThai = trangThai;
		this.quyen = quyen;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public Quyen getQuyen() {
		return quyen;
	}

	public void setQuyen(Quyen quyen) {
		this.quyen = quyen;
	}
}
