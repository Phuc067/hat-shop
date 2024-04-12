package com.hatshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hatshop.entity.TaiKhoan;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan,String >{
	Boolean existsByEmail(String email);
	
	@Modifying(clearAutomatically = true)
	@Transactional(value = TxType.REQUIRED)
	@Query(value = "UPDATE TAIKHOAN SET OTP = NULL WHERE USERNAME = ?1", nativeQuery = true)
	void removeVerificationCode(String username);
}
