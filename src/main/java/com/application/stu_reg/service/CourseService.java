package com.application.stu_reg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.stu_reg.exception.RecordNotFoundException;
import com.application.stu_reg.model.CourseEntity;
import com.application.stu_reg.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    CourseRepository repository;

    public List<CourseEntity> getAllCourses() {
        List<CourseEntity> result = (List<CourseEntity>) repository.findAll();

        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<CourseEntity>();
        }
    }

    public CourseEntity getCourseById(Integer id) throws RecordNotFoundException {
        Optional<CourseEntity> course = repository.findById(id);

        if (course.isPresent()) {
            return course.get();
        } else {
            throw new RecordNotFoundException("No course record exist for given id");
        }
    }

    public CourseEntity createOrUpdateCourse(CourseEntity entity) {
        if (entity.getId() == null) {
            entity = repository.save(entity);

            return entity;
        } else {
            Optional<CourseEntity> course = repository.findById(entity.getId());

            if (course.isPresent()) {
                CourseEntity newEntity = course.get();
                newEntity.setCourseName(entity.getCourseName());

                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                entity = repository.save(entity);

                return entity;
            }
        }
    }

    public void deleteCourseById(Integer id) throws RecordNotFoundException {
        Optional<CourseEntity> course = repository.findById(id);

        if (course.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No course record exist for given id");
        }
    }
}