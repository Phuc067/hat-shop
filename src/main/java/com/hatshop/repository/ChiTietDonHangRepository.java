package com.hatshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hatshop.entity.ChiTietDonHang;
import com.hatshop.identity.ChiTietDonHangId;

import java.util.Optional;


@Repository
public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang, ChiTietDonHangId>
{
	public Optional<ChiTietDonHang> findById(ChiTietDonHangId id); 

}
