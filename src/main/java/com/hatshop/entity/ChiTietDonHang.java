package com.hatshop.entity;

import java.io.Serializable;

import com.hatshop.identity.ChiTietDonHangId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class ChiTietDonHang implements Serializable {

	private static final long serialVersionUID = 3192485885859239691L;

	@EmbeddedId
	private ChiTietDonHangId id;
	
	private int soLuong;
	
	private double donGia;

	
}


