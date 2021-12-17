package org.example.dao;

import org.example.Course;
import org.example.Education;

import java.util.ArrayList;
import java.util.List;

public interface EducationDao {
    void create(Education education);
    Education getById(int id);
    void update(Education education);
    void delete(Education education);
    void setCour(Education education, List<Course> list);
    List<Education> getAll();


}
