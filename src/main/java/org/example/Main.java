package org.example;


import org.example.dao.CourseDao;
import org.example.dao.EducationDao;
import org.example.dao.StudentDao;
import org.example.dao.TeacherDao;
import org.example.impl.CourseImpl;
import org.example.impl.EducationImpl;
import org.example.impl.StudentImpl;
import org.example.impl.TeacherImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class Main {
    public static void main( String[] args ) {
        EducationDao educationDao = new EducationImpl();
        StudentDao studentDao = new StudentImpl();
        TeacherDao teacherDao = new TeacherImpl();
        CourseDao courseDao = new CourseImpl();

     //   educationDao.create(new Education("Javautvecklare"));
        Education education = educationDao.getById(1);
      //   studentDao.create(new Student("Lukas","Finne"), education);
       // teacherDao.create(new Teacher("Daniel", "Danielsson"), education);
       // System.out.println(education);

        //courseDao.create(new Course("Javatest"));
       //courseDao.create(new Course(education,"javatest" ));
       courseDao.create(new Course(education,"utveckling mot databaser" ));
        //educationDao.setCour(education,list);




    }
}
