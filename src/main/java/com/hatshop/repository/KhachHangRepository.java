package com.hatshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hatshop.entity.KhachHang;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, String>{
	 @Query(value = "SELECT MAX(MaKhachHang) FROM khachHang", nativeQuery = true)
	 String findMaxId();
}
