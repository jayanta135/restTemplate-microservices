package com.clientstudentservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clientstudentservice.model.SchoolInfo;
import com.clientstudentservice.model.StudentInfo;
import com.clientstudentservice.repository.SchoolRepository;
import com.clientstudentservice.service.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {
	
	@Autowired
	private SchoolService service;
	
	@Autowired
	private SchoolRepository repo;
	
	@GetMapping("/{id}")
	public Optional<SchoolInfo> getUserById(@PathVariable("id") long id) {
		return service.findByUserId(id);
	}
	
	@GetMapping("/name/{schoolname}")
	public SchoolInfo getSchoolByName(@PathVariable("schoolname") String schoolname) {
		
		return service.findBySchoolName(schoolname);
	}
	
	@GetMapping("/schools")
	public List<SchoolInfo> getAllSchool() {
		
		return service.findAllSchool();
	}
	
	@GetMapping("/schoolid/{id}")
	public List<StudentInfo> getStudentById(@PathVariable("id") long id) {
		
		return repo.findBySchoolId(id);
	}
	
	@GetMapping(value = "/schoolname/{schoolname}") 
	public List<StudentInfo> getStudentByName(@PathVariable("schoolname") String schoolname) {
		
		return repo.findByStudentBySchoolName(schoolname);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {

		return "Welcome To Index Page";
	}


}
