package com.hatshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hatshop.entity.RefreshToken;
import com.hatshop.entity.TaiKhoan;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer>{
	RefreshToken findByToken(String token);
	RefreshToken findByTaiKhoan(TaiKhoan taiKhoan);
}
