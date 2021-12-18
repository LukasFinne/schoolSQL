package org.example.dao;

import org.example.tables.Course;
import org.example.tables.Education;
import org.example.tables.Teacher;

import java.util.List;

public interface TeacherDao {
    void create(Teacher teacher, Education education);
    Teacher getById(int id);
    void update(Teacher teacher);
    void delete(Teacher teacher);
    void setCourse(List<Course> test, Teacher teacher);
    void deleteFromCourse(int teacherId, int courseId);
    List<Teacher> getAll();
}
