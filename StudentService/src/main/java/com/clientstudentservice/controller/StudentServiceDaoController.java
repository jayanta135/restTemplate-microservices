package com.clientstudentservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clientstudentservice.model.StudentInfo;
import com.clientstudentservice.repository.StudentRepository;
import com.clientstudentservice.service.StudentService;

@RestController
public class StudentServiceDaoController {
	
	@Autowired
	private StudentService service;
	
	@Autowired
	private StudentRepository repo;
	
	@RequestMapping(value = "/getStudentDetailsForSchool", method = RequestMethod.GET)
	public List<StudentInfo> getStudentsByName() {
		System.out.println("Getting Student details for ");

		List<StudentInfo> studentList = service.getAllStudent();
		
		return studentList;
	}
	
	@GetMapping(value = "/studentsname/{studentname}") 
	public List<StudentInfo> findStudentByName(@PathVariable("studentname") String studentname) {
		
		return repo.findByName(studentname);
	}
	
	@PostMapping("/newstudent")
	public StudentInfo createEmployee(@Valid @RequestBody StudentInfo student) {
	 return repo.save(student);
	}
	
	@DeleteMapping(value = "/studentid/{id}") 
	public void deleteStudentById(@PathVariable("id") Long id) {
		
		repo.deleteById(id);
	}
	
	@PutMapping(value = "/updatestudent/{id}") 
	public ResponseEntity<StudentInfo> updateStudentById(@PathVariable("id") Long id, @Valid @RequestBody StudentInfo studentDetails) throws ResourceNotFoundException {
		
		StudentInfo student = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student Not Found for this id: "+ id));
		student.setName(studentDetails.getName());
		student.setClassName(studentDetails.getClassName());
		final StudentInfo updatedStudent = repo.save(student);
		return ResponseEntity.ok(updatedStudent);
	}
	
	/*
	 * @PutMapping("/employees/{id}") public ResponseEntity<Employee>
	 * updateEmployee(@PathVariable(value = "id") Long employeeId,
	 * 
	 * @Valid @RequestBody Employee employeeDetails) throws
	 * ResourceNotFoundException { Employee employee =
	 * employeeRepository.findById(employeeId) .orElseThrow(() -> new
	 * ResourceNotFoundException("Employee not found for this id :: " +
	 * employeeId));
	 * 
	 * employee.setEmailId(employeeDetails.getEmailId());
	 * employee.setLastName(employeeDetails.getLastName());
	 * employee.setFirstName(employeeDetails.getFirstName()); final Employee
	 * updatedEmployee = employeeRepository.save(employee); return
	 * ResponseEntity.ok(updatedEmployee); }
	 */
	
}
