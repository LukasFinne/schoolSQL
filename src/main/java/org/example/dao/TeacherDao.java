package org.example.dao;

import org.example.Education;
import org.example.Teacher;

public interface TeacherDao {
    void create(Teacher teacher, Education education);
    Teacher getById(int id);
    void update(Teacher teacher);
    void delete(Teacher teacher);
}
