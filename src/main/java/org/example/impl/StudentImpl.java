package org.example.impl;

import org.example.Education;
import org.example.Student;
import org.example.dao.StudentDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentImpl implements StudentDao {
    EntityManagerFactory emf;
    EntityManager em;

    public StudentImpl() {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
    }

    @Override
    public void create(Student student, Education education) {
        em.getTransaction().begin();
        student.setEducation(education);
        em.persist(student);
        em.getTransaction().commit();
    }

    @Override
    public Student getById(int id) {
        return em.find(Student.class,id);
    }

    @Override
    public void update(Student student) {
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Student student) {
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
    }
}
