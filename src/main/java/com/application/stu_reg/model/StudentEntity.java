package com.application.stu_reg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_STUDENTS")
public class StudentEntity {

	@Id
	@Column(name = "id", length = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "student_name", length = 255)
	private String studentname;

	@Column(name = "student_age", length = 50)
	private int studentage;

	@Column(name = "student_course", length = 50)
	private String studentcourse;

	@Column(name = "student_gender", length = 50)
	private String studentgender;

	@Column(name = "student_dob", length = 50)
	private String studentdob;

	@Column(name = "student_address", length = 255)
	private String studentaddress;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentname;
	}

	public void setStudentName(String studentname) {
		this.studentname = studentname;
	}

	public Integer getStudentAge() {
		// // Sample birthdate
		// LocalDate birthdate = LocalDate.of(1990, 5, 15);

		// // Calculate age
		// LocalDate currentDate = LocalDate.now();
		// Period age = Period.between(birthdate, currentDate);
		return studentage;
	}

	public void setStudentAge(Integer studentage) {
		this.studentage = studentage;
	}

	public String getStudentCourse() {
		return studentcourse;
	}

	public void setStudentCourse(String studentcourse) {
		this.studentcourse = studentcourse;
	}

	public String getStudentGender() {
		return studentgender;
	}

	public void setStudentGender(String studentgender) {
		this.studentgender = studentgender;
	}

	public String getStudentDOB() {
		return studentdob;
	}

	public void setStudentDOB(String studentdob) {
		this.studentdob = studentdob;
	}

	public String getStudentAddress() {
		return studentaddress;
	}

	public void setStudentAddress(String studentaddress) {
		this.studentaddress = studentaddress;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", studentname=" + studentname +
				", studentage=" + studentage + ", studentcourse=" + studentcourse + ", studentgender=" + studentgender
				+ ", studentdob=" + studentdob + ", studentaddress=" + studentaddress + "]";
	}
}