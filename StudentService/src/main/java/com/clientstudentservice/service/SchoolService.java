package com.clientstudentservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientstudentservice.model.SchoolInfo;
import com.clientstudentservice.repository.SchoolRepository;

@Service
public class SchoolService {
	
	@Autowired
	private SchoolRepository repo;
	
	
	public Optional<SchoolInfo> findByUserId(long id) {
		return repo.findById(id);
	}

	public SchoolInfo findBySchoolNameCustom(String schoolname) {
		return repo.findByName(schoolname);
	}

	public SchoolInfo findBySchoolName(String schoolname) {
		return repo.findBySchoolName(schoolname);
	}

	public List<SchoolInfo> findAllSchool() {
		return repo.findAll();
	}

}
