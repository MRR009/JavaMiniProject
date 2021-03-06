package com.stg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.College;
import com.stg.exception.CustomExcepHandler;
import com.stg.service.CollegeService;

@RestController
@RequestMapping(value = "college")
public class CollegeController {
	
	@Autowired
	private CollegeService collegeService ;
	
	// Creating College
	@PostMapping(value="add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public College createCollege(@RequestBody College college) {
		return collegeService.createCollege(college);
	}
	
	// Reading data from the database 
	@GetMapping(value = "getall")
	public List<College> readAllColleges(){
		return collegeService.getAllColleges();
	}
	
	@GetMapping(value = "getbycode")
	public College readCollegeByCode(@RequestParam String code) {
		return collegeService.readCollegeByCode(code);
	}
	
	
	// updating the college
	@PutMapping(value="update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public College updateCollege(@RequestBody College college) {
		return collegeService.updateCollege(college);
	}
	
	
	//Deleting the college
	
	@DeleteMapping(value="deletebycode/")
	public String deleteCollegeByCode(@RequestParam String code) {
		System.out.println("message " + collegeService.deleteCollegeByCode(code));
		return collegeService.deleteCollegeByCode(code);
	}
	
	//Handling Exception
	@ExceptionHandler(value= CustomExcepHandler.class)
	public String handleException(CustomExcepHandler exc) {
		return exc.getMessage();
	}
	
	
}
