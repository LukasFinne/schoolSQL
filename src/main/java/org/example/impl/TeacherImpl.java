package org.example.impl;

import org.example.Course;
import org.example.Education;
import org.example.Student;
import org.example.Teacher;
import org.example.dao.TeacherDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

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
        em.remove(teacher);
        em.getTransaction().commit();
    }

    @Override
    public void setCourse(List<Course> test,Teacher teacher) {
        em.getTransaction().begin();
        teacher.addTest(test);
       // teacher.setCourses(test);
        em.persist(teacher);
        em.getTransaction().commit();
    }

    @Override
    public void deleteFromCourse(int courseId , int teacherId) {
        em.getTransaction().begin();
        em.createNativeQuery("DELETE FROM teacher_courses WHERE courses_id = ? AND teacher_id = ?")
                .setParameter(1,courseId)
                .setParameter(2, teacherId)
                .executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public List<Teacher> getAll() {
       return em.createQuery("SELECT teacher FROM Teacher teacher", Teacher.class).getResultList();
    }
}
