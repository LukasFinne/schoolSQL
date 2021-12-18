package org.example.dao;

import org.example.Course;
import org.example.Education;

import java.util.List;
import java.util.Set;

public interface CourseDao {
    void create(Course course, Education education);
    Course getById(int id);
    List<Course> toSet(Course course);
    void update(Course course);
    void delete(Course course);
    List<Course> getAll();
    List<Course> getByEducation(int EducationId);

}
