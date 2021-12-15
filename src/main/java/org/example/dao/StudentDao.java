package org.example.dao;

import org.example.Education;
import org.example.Student;

public interface StudentDao {

    void create(Student student, Education education);
    Student getById(int id);
    void update(Student student);
    void delete(Student student);

}
