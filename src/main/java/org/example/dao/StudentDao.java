package org.example.dao;

import org.example.*;

import java.util.List;
import java.util.Set;

public interface StudentDao {

    void create(Student student, Education education);
    Student getById(int id);
    void update(Student student);
    void delete(Student student);
    void setCourseAndGrade(Student student,Course course);
    List<Student> getAll();
}
