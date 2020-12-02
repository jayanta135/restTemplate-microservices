
package com.clientstudentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clientstudentservice.model.StudentInfo;

@Repository
public interface StudentRepository extends JpaRepository<StudentInfo, Long> {

	List<StudentInfo> findByName(String school);

	/*
	 * @Query("SELECT d FROM SchoolInfo e, StudentInfo d WHERE d.school_id = e")
	 * public List<SchoolInfo> findSchoolInfoNameById(@Param("id") long id);
	 */

}
