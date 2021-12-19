package org.example.dao;

import org.example.tables.Course;
import org.example.tables.Education;

import java.util.List;

public interface EducationDao {
    void create(Education education);

    Education getById(int id);

    void update(Education education);

    void delete(Education education);

    void setCour(Education education, List<Course> list);

    List<Education> getAll();


}
