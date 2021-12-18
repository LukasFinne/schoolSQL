package org.example.dao;

import org.example.tables.Course;
import org.example.tables.Education;

import java.util.List;

public interface CourseDao {
    void create(Course course, Education education);
    Course getById(int id);
    List<Course> toSet(Course course);
    void update(Course course);
    void delete(Course course);
    List<Course> getAll();
    List<Course> getByEducation(int EducationId);

}
