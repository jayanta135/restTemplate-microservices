package com.clientstudentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clientstudentservice.model.SchoolInfo;
import com.clientstudentservice.model.StudentInfo;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolInfo, Long> {

	@Query("SELECT schoolAddress FROM SchoolInfo s WHERE s.schoolName = :schoolname")
	SchoolInfo findByName(String schoolname);
	
	@Query("SELECT s FROM SchoolInfo s WHERE s.schoolName = :schoolname")
	SchoolInfo findBySchoolName(String schoolname);
	
	public final static String school_student ="Select std from StudentInfo std Join std.schoolinfo sch Where sch.id = :id";
	@Query(school_student)
	public List<StudentInfo> findBySchoolId(@Param("id") long id);

	public final static String school_studentInfo ="Select std from StudentInfo std Join std.schoolinfo sch Where sch.schoolName = :schoolname";
	@Query(school_studentInfo)
	public List<StudentInfo> findByStudentBySchoolName(@Param("schoolname") String schoolname);

}