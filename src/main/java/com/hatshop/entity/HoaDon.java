package com.hatshop.entity;

import java.io.Serializable;
import java.time.Instant;

import com.hatshop.identity.ChiTietDonHangId;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class HoaDon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8309639016029767770L;

	
	@Id
	private String maHoaDon;
	
	private Instant ngayTao;
	
	private Double tongGiaTri;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaDonHang", referencedColumnName = "maDonHang")
	private DonHang donHang;

}
