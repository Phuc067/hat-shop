package com.hatshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hatshop.entity.Quyen;

@Repository
public interface QuyenRepository extends JpaRepository<Quyen, String>{
	
}
