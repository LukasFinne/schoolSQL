package org.example.impl;

import org.example.Stats;
import org.example.tables.CourseGrade;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StatsImpl implements Stats {

    EntityManagerFactory emf;
    EntityManager em;

    public StatsImpl() {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
    }

    @Override
    public List<Object[]> AverageGradeByStudent() {

        Query query = em.createQuery("SELECT CONCAT(s.firstName , ' ' , s.lastName) AS NAME, FLOOR(AVG(course_grade.grade)) AS GRADE FROM CourseGrade course_grade INNER JOIN Student s on course_grade.student.id = s.id GROUP BY s.id");
        return query.getResultList();


    }

    @Override
    public List<Object[]> AverageGradeByCourse() {

        Query query = em.createQuery("SELECT c.name, FLOOR(AVG(course_grade.grade)) AS GRADE FROM CourseGrade course_grade INNER JOIN Course c on course_grade.course.id = c.id GROUP BY c.id");
        return query.getResultList();
    }

    @Override
    public List<Integer> AverageGrade() {
        TypedQuery<Integer> query = em.createQuery("SELECT FLOOR(AVG(course_grade.grade)) AS Grade FROM CourseGrade course_grade", Integer.class);
        return query.getResultList();
    }


}
