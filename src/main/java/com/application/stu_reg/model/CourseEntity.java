package com.application.stu_reg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_COURSES")
public class CourseEntity {

    @Id
    @Column(name = "id", length = 50)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "course_name", length = 255)
    private String coursename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return coursename;
    }

    public void setCourseName(String coursename) {
        this.coursename = coursename;
    }

    @Override
    public String toString() {
        return "CourseEntity [id=" + id + ", coursename=" + coursename + "]";
    }
}