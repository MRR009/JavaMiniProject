package com.stg.service;

import java.util.List;

import com.stg.entity.University;
import com.stg.exception.CustomExcepHandler;

public interface UniversityService {
	public abstract University createUniversity(University university)throws CustomExcepHandler;
	
	public abstract University searchUniversityById(int id)throws CustomExcepHandler;
	
	public abstract University readUniversityByCode(String code) throws CustomExcepHandler;
	
	public abstract List<University> getAllUniversities()throws CustomExcepHandler;
	
	public abstract University updateUniversity(University university)throws CustomExcepHandler; 
	
	public abstract String deleteUniversityByCode(String uniCode)throws CustomExcepHandler;
	
	public abstract List<University> getMulUniversitiesWithCode(String code)throws CustomExcepHandler;
	
	public abstract String deleteUniversityByName(String name)throws CustomExcepHandler;
	
	public University updateUniversity(String uniCode, String location)throws CustomExcepHandler;
	
}
