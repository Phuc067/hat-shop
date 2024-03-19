package com.hatshop.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaKhachHang", referencedColumnName = "maKhachHang")
	private KhachHang khachHang;

	
}
