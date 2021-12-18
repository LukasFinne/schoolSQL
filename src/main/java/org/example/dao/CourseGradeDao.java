package org.example.dao;

import org.example.tables.CourseGrade;
import org.example.tables.CourseGradeKey;

import java.util.List;

public interface CourseGradeDao {
    void create(CourseGrade courseGrade);
    void update(CourseGrade courseGrade);
    void remove(CourseGrade courseGrade);
    CourseGrade getById(CourseGradeKey id);
    List<CourseGrade> getAll();

}
