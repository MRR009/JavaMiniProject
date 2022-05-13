package com.stg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.College;
import com.stg.entity.University;
import com.stg.exception.CustomExcepHandler;
import com.stg.repository.CollegeRepository;
import com.stg.repository.UniversityRepository;

@Service
public class CollegeServiceImpl implements CollegeService {
	@Autowired
	private CollegeRepository collegeRepository;
	
	@Autowired
	private UniversityRepository universityRepository;
	
	@Override
	public College createCollege(College college)throws CustomExcepHandler {
		University university = universityRepository.findByUniversityCode(college.getUniversity().getUniversityCode());
		if(university !=null) {
		int uniCode = university.getUniversityId();
		university = null;
		college.getUniversity().setUniversityId(uniCode);
		return collegeRepository.save(college);
		} else {
			throw new CustomExcepHandler("Please check your values once");
		}
	}
	
	@Override
	public College readCollegeByCode(String code) throws CustomExcepHandler{
		College tempCollege = collegeRepository.findByCollegeCode(code);
		if(tempCollege != null) {
		return collegeRepository.findByCollegeCode(code);
		}
		else {
			throw new CustomExcepHandler("No college Found with the given Code");
		}
	}
	
	@Override
	public List<College> getAllColleges() throws CustomExcepHandler{
		
		return collegeRepository.findAll();
	}
	
	@Override
	public College updateCollege(College college) throws CustomExcepHandler{
	
		return collegeRepository.save(college);
	}
	
	@Transactional
	public String deleteCollegeByCode(String clgCode)throws CustomExcepHandler {
		
		collegeRepository.deleteByCollegeCode(clgCode);
		return "Requested College Deleted";
	}

}
