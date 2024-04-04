package com.hatshop.repository;

import java.time.Instant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hatshop.entity.Gia;
import com.hatshop.entity.SanPham;

@Repository
public interface GiaRepository extends JpaRepository<Gia, String>
{
	Gia findBySanPhamAndNgayHetHan(SanPham maSanPham, Instant ngayHetHan);
	
    @Query(value = "SELECT MAX(maGia) FROM Gia ")
    String findMaxId();
}