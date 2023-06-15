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
import com.application.stu_reg.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseMvcController {
    @Autowired
    CourseService service;

    @RequestMapping
    public String getAllCourses(Model model) {
        List<CourseEntity> list = service.getAllCourses();

        model.addAttribute("courses", list);
        return "list-courses";
    }

    @RequestMapping(path = { "/edit", "/edit/{id}" })
    public String editCourseById(Model model, @PathVariable("id") Optional<Integer> id)
            throws RecordNotFoundException {
        if (id.isPresent()) {
            CourseEntity entity = service.getCourseById(id.get());
            model.addAttribute("course", entity);
        } else {
            model.addAttribute("course", new CourseEntity());
        }
        return "add-edit-course";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteCourseById(Model model, @PathVariable("id") Integer id)
            throws RecordNotFoundException {
        service.deleteCourseById(id);
        return "redirect:/course";
    }

    @RequestMapping(path = "/createCourse", method = RequestMethod.POST)
    public String createOrUpdateCourse(CourseEntity course) {
        service.createOrUpdateCourse(course);
        return "redirect:/course";
    }
}
