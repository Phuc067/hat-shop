package com.hatshop.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maQuyen", referencedColumnName = "maQuyen")
	private Quyen quyen;

}
