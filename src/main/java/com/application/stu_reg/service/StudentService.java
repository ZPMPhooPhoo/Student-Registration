package com.application.stu_reg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.stu_reg.exception.RecordNotFoundException;
import com.application.stu_reg.model.StudentEntity;
import com.application.stu_reg.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	public List<StudentEntity> getAllStudents() {
		List<StudentEntity> result = (List<StudentEntity>) repository.findAll();

		if (result.size() > 0) {
			return result;
		} else {
			return new ArrayList<StudentEntity>();
		}
	}

	public StudentEntity getStudentById(Integer id) throws RecordNotFoundException {
		Optional<StudentEntity> student = repository.findById(id);

		if (student.isPresent()) {
			return student.get();
		} else {
			throw new RecordNotFoundException("No student record exist for given id");
		}
	}

	public StudentEntity createOrUpdateStudent(StudentEntity entity) {
		if (entity.getId() == null) {
			entity = repository.save(entity);

			return entity;
		} else {
			Optional<StudentEntity> student = repository.findById(entity.getId());

			if (student.isPresent()) {
				StudentEntity newEntity = student.get();
				newEntity.setStudentName(entity.getStudentName());
				newEntity.setStudentAge(entity.getStudentAge());
				newEntity.setStudentCourse(entity.getStudentCourse());
				newEntity.setStudentGender(entity.getStudentGender());
				newEntity.setStudentDOB(entity.getStudentDOB());
				newEntity.setStudentAddress(entity.getStudentAddress());

				newEntity = repository.save(newEntity);

				return newEntity;
			} else {
				entity = repository.save(entity);

				return entity;
			}
		}
	}

	public void deleteStudentById(Integer id) throws RecordNotFoundException {
		Optional<StudentEntity> student = repository.findById(id);

		if (student.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No student record exist for given id");
		}
	}
}