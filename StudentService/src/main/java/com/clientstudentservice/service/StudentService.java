package com.clientstudentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientstudentservice.model.StudentInfo;
import com.clientstudentservice.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public List<StudentInfo> getAllStudent() {
		
		return repo.findAll();
	}
	
	public List<StudentInfo> findByName(String school) {
		
		return repo.findByName(school);
	}

}
