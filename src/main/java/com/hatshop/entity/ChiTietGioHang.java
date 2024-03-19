package com.hatshop.entity;

import java.io.Serializable;

import com.hatshop.identity.ChiTietDonHangId;
import com.hatshop.identity.ChiTietGioHangId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class ChiTietGioHang implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6620439321292227240L;

	@EmbeddedId
	private ChiTietGioHangId id;
	
	private int soLuong;
	
	private Double donGia;
}
