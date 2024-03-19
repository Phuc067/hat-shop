package com.hatshop.entity;

import java.io.Serializable;
import java.time.Instant;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Gia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3280353155339313842L;

	@Id
	private String maGia;
	
	private Instant ngayHieuLuc;
	
	private Instant ngayHetHan;
	
	private Double gia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maSanPham", referencedColumnName = "maSanPham")
	private SanPham sanPham;

	
}
