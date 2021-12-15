package org.example.impl;

import org.example.Education;
import org.example.Teacher;
import org.example.dao.TeacherDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TeacherImpl implements TeacherDao {
    EntityManagerFactory emf;
    EntityManager em;

    public TeacherImpl() {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
    }

    @Override
    public void create(Teacher teacher, Education education) {
        em.getTransaction().begin();
        teacher.setEducation(education);
        em.persist(teacher);
        em.getTransaction().commit();
    }

    @Override
    public Teacher getById(int id) {
        return em.find(Teacher.class, id);
    }

    @Override
    public void update(Teacher teacher) {
        em.getTransaction().begin();
        em.merge(teacher);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Teacher teacher) {
        em.getTransaction().begin();
        em.merge(teacher);
        em.getTransaction().commit();
    }
}
