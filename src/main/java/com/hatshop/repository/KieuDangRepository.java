package com.hatshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hatshop.entity.KieuDang;

@Repository
public interface KieuDangRepository extends JpaRepository<KieuDang, String>{
}
