package com.stg.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.University;
import com.stg.exception.CustomExcepHandler;
import com.stg.repository.UniversityRepository;

@Service
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	private UniversityRepository universityRepository;

	@Override
	public University createUniversity(University university)throws CustomExcepHandler {

		return universityRepository.save(university);
	}

	@Override
	public University readUniversityByCode(String code)  throws CustomExcepHandler  {
		University tempUniversity = universityRepository.findByUniversityCode(code);

		if (tempUniversity !=null) {
			return universityRepository.findByUniversityCode(code);

		} else {

			throw new CustomExcepHandler("University not exist");
		}
		

	}

	@Override
	public List<University> getAllUniversities()throws CustomExcepHandler {

		return universityRepository.findAll();
	}

	@Override
	public University updateUniversity(University university) {
		

		return universityRepository.save(university);
	}

	@Override
	@Transactional
	public String deleteUniversityByCode(String uniCode) throws CustomExcepHandler{
		universityRepository.deleteByUniversityCode(uniCode);
		return "deleted";
	}

	@Override
	public University searchUniversityById(int id) throws CustomExcepHandler{

		return universityRepository.findById(id).orElse(null);
	}

	@Override
	public List<University> getMulUniversitiesWithCode(String code) {
		
		return null;
	}

	@Override
	@Transactional
	public String deleteUniversityByName(String name) throws CustomExcepHandler{
		universityRepository.deleteByUniversityName(name);
		return "deleted university by given name";
	}

	@Override
	public University updateUniversity(String uniCode, String location)throws CustomExcepHandler {
		University university = universityRepository.findByUniversityCode(uniCode);
		university.setUniversityLocation(location);
		return universityRepository.save(university);
	}

}
