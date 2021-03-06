package com.stg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.University;
import com.stg.exception.CustomExcepHandler;
import com.stg.service.UniversityService;

@RestController
@RequestMapping(value = "university")
public class UniversityController {

	@Autowired
	private UniversityService universityService;

	// Creating University
	@PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public University createUniversity(@RequestBody University university) {
		return universityService.createUniversity(university);
	}

	// Reading University Data
	
	@GetMapping(value="getbyid")
	public University searchUniversityById(@RequestParam int id) {
		return universityService.searchUniversityById(id);
	}
	
	@GetMapping(value = "getbycode")
	public University readUniversityByCode(@RequestParam String uniCode) {
		return universityService.readUniversityByCode(uniCode);
	}

	@GetMapping(value = "getall")
	public List<University> getAllUniversities() {
		return universityService.getAllUniversities();
	}
	
	@GetMapping(value="getmuluni")
	public List<University> getMulUniByCode(@RequestParam String code){
		return universityService.getMulUniversitiesWithCode(code);
	}

	// Updating University
	@PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public University updateUniversity(@RequestBody University university) {
		return universityService.updateUniversity(university);
	}
	
	@PutMapping(value="updatebycode")
	public University updateUniversityByCode(@RequestParam String uniCode, @RequestParam String location) {
		return universityService.updateUniversity(uniCode, location);
	}

	// Deleting University Data
	@DeleteMapping(value = "deletebycode")
	public String deleteUniversityByCode(String code) {
		return universityService.deleteUniversityByCode(code);
	}
	
	@DeleteMapping(value="deletebyname")
	public String deleteUniversityByname(@RequestParam String name) {
		return universityService.deleteUniversityByName(name);
	}

	// Handling Exception
	@ExceptionHandler(value = CustomExcepHandler.class)
	public String handleException(CustomExcepHandler exc) {
		return exc.getMessage();
	}

}
