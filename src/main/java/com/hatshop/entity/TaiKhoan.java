package com.hatshop.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class TaiKhoan  implements Serializable, UserDetails{

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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maQuyen", referencedColumnName = "maQuyen")
	private Quyen quyen;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 return Collections.singleton(new SimpleGrantedAuthority(quyen.getTenQuyen()));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
