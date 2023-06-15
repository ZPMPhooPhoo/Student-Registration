package com.application.stu_reg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.stu_reg.exception.RecordNotFoundException;
import com.application.stu_reg.model.CourseEntity;
import com.application.stu_reg.model.StudentEntity;
import com.application.stu_reg.service.CourseService;
import com.application.stu_reg.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentMvcController {
	@Autowired
	StudentService service;

	@Autowired
	CourseService courseService;

	@RequestMapping
	public String getAllStudents(Model model) {
		List<StudentEntity> list = service.getAllStudents();

		model.addAttribute("students", list);
		return "list-students";
	}

	@RequestMapping(path = { "/edit", "/edit/{id}" })
	public String editStudentById(Model model, @PathVariable("id") Optional<Integer> id)
			throws RecordNotFoundException {
		if (id.isPresent()) {
			StudentEntity entity = service.getStudentById(id.get());
			model.addAttribute("student", entity);
		} else {
			model.addAttribute("student", new StudentEntity());
		}

		List<CourseEntity> courseList = courseService.getAllCourses();
		model.addAttribute("courseList", courseList);
		return "add-edit-student";
	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteStudentById(Model model, @PathVariable("id") Integer id)
			throws RecordNotFoundException {
		service.deleteStudentById(id);
		return "redirect:/student";
	}

	@RequestMapping(path = "/createStudent", method = RequestMethod.POST)
	public String createOrUpdateStudent(StudentEntity student) {
		service.createOrUpdateStudent(student);
		return "redirect:/student";
	}
}
