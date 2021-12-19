package org.example;

import org.example.tables.CourseGrade;

import java.util.List;
import java.util.Optional;

public interface Stats {
    List<Object[]> AverageGradeByStudent();
    List<Object[]> AverageGradeByCourse();
    List<Integer> AverageGrade();

}
