package com.stg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.College;
import com.stg.entity.University;

public interface CollegeRepository extends JpaRepository<College, String> {
	
	//@Query(value="SELECT * FROM college where college_code = :clg_code", nativeQuery=true)
	public College findByCollegeCode(String code);
	
	//@Query(value="DELETE FROM college  WHERE college_code = :clg_code", nativeQuery=true)
	public void deleteByCollegeCode(String code);
	
}
