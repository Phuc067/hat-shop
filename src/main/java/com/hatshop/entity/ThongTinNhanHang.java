package com.hatshop.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ThongTinNhanHang implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4894807050701972511L;
	
	@Id
	private String maTT;
	
	private String tenNguoiNhan;
	
	private String diaChiNguoiNhan;
	
	private String sdtNguoiNhan;
	
	@ManyToOne
	@JoinColumn(name = "MaKhachHang", referencedColumnName = "maKhachHang")
	private KhachHang khachHang;

	public ThongTinNhanHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThongTinNhanHang(String maTT, String tenNguoiNhan, String diaChiNguoiNhan, String sdtNguoiNhan,
			KhachHang khachHang) {
		super();
		this.maTT = maTT;
		this.tenNguoiNhan = tenNguoiNhan;
		this.diaChiNguoiNhan = diaChiNguoiNhan;
		this.sdtNguoiNhan = sdtNguoiNhan;
		this.khachHang = khachHang;
	}

	public String getMaTT() {
		return maTT;
	}

	public void setMaTT(String maTT) {
		this.maTT = maTT;
	}

	public String getTenNguoiNhan() {
		return tenNguoiNhan;
	}

	public void setTenNguoiNhan(String tenNguoiNhan) {
		this.tenNguoiNhan = tenNguoiNhan;
	}

	public String getDiaChiNguoiNhan() {
		return diaChiNguoiNhan;
	}

	public void setDiaChiNguoiNhan(String diaChiNguoiNhan) {
		this.diaChiNguoiNhan = diaChiNguoiNhan;
	}

	public String getSdtNguoiNhan() {
		return sdtNguoiNhan;
	}

	public void setSdtNguoiNhan(String sdtNguoiNhan) {
		this.sdtNguoiNhan = sdtNguoiNhan;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
