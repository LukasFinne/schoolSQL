package org.example.impl;

import org.example.tables.CourseGrade;
import org.example.tables.CourseGradeKey;
import org.example.dao.CourseGradeDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.List;


public class CourseGradeImpl implements CourseGradeDao {
    EntityManagerFactory emf;
    EntityManager em;

    public CourseGradeImpl() {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
    }

    @Override
    @Transactional
    public void create(CourseGrade courseGrade) {
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO course_grade(course_id, student_id, grade) VALUES (?,?,?)")
                .setParameter(1,courseGrade.getCourse())
                .setParameter(2,courseGrade.getStudent())
                .setParameter(3,courseGrade.getGrade())
                .executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public void update(CourseGrade courseGrade) {
        em.getTransaction().begin();
        em.merge(courseGrade);
        em.getTransaction().commit();
    }

    @Override
    public void remove(CourseGrade courseGrade) {
        em.getTransaction().begin();
        em.remove(courseGrade);
        em.getTransaction().commit();
    }

    @Override
    public CourseGrade getById(CourseGradeKey id) {
        return em.find(CourseGrade.class, id);
    }

    @Override
    public List<CourseGrade> getAll() {
        return em.createQuery("SELECT course_grade FROM CourseGrade course_grade", CourseGrade.class).getResultList();
    }


}
