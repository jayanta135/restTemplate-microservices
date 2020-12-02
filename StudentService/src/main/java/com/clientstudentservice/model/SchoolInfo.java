package com.clientstudentservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Jay
 *
 */
@Entity
@Table
public class SchoolInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	private String schoolName;
	
	@Column
	private String schoolAddress;
	
	@OneToMany(mappedBy = "schoolinfo", cascade = { CascadeType.PERSIST,CascadeType.REMOVE})
	private List<StudentInfo> student;

	public SchoolInfo() {
		super();
	}

	public SchoolInfo(long id, String schoolName, String schoolAddress) {
		super();
		this.id = id;
		this.schoolName = schoolName;
		this.schoolAddress = schoolAddress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	@Override
	public String toString() {
		return "SchoolInfo [id=" + id + ", schoolName=" + schoolName + ", schoolAddress=" + schoolAddress + "]";
	}

	
}
