package com.application.stu_reg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.stu_reg.model.CourseEntity;

@Repository
public interface CourseRepository
		extends CrudRepository<CourseEntity, Integer> {

}
