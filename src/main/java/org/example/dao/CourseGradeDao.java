package org.example.dao;

import org.example.Course;
import org.example.CourseGrade;
import org.example.CourseGradeKey;
import org.example.Student;

import java.util.List;

public interface CourseGradeDao {
    void create(CourseGrade courseGrade);
    void create2(CourseGrade courseGrade);
    void update(CourseGrade courseGrade);
    void remove(CourseGrade courseGrade);
    CourseGrade getById(CourseGradeKey id);
    List<CourseGrade> getAll();

}
