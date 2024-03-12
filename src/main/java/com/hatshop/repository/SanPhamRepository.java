package com.hatshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hatshop.entity.SanPham;

@Repository
public interface SanPhamRepository  extends JpaRepository<SanPham, String>{
	List<SanPham> findAll();
}
