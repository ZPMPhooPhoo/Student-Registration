package com.application.stu_reg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.stu_reg.model.StudentEntity;

@Repository
public interface StudentRepository
		extends CrudRepository<StudentEntity, Integer> {

}
