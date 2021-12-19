package org.example.dao;

import org.example.tables.Course;
import org.example.tables.Education;
import org.example.tables.Student;

import java.util.List;

public interface StudentDao {

    void create(Student student, Education education);

    Student getById(int id);

    void update(Student student);

    void delete(Student student);

    void setCourseAndGrade(Student student, Course course);

    List<Student> getAll();

    List<Student> getByEducation(int educationId);
}
