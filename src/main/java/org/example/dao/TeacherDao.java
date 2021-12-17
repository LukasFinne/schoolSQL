package org.example.dao;

import org.example.Course;
import org.example.Education;
import org.example.Teacher;

import java.util.List;
import java.util.Set;

public interface TeacherDao {
    void create(Teacher teacher, Education education);
    Teacher getById(int id);
    void update(Teacher teacher);
    void delete(Teacher teacher);
    void setCourse(Course course, Set<Course> test, Teacher teacher);
    List<Teacher> getAll();
}
