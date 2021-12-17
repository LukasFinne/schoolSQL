package org.example;


import org.example.dao.*;
import org.example.impl.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main( String[] args ) {
        EducationDao educationDao = new EducationImpl();
        StudentDao studentDao = new StudentImpl();
        TeacherDao teacherDao = new TeacherImpl();
        CourseDao courseDao = new CourseImpl();
        CourseGradeDao courseGradeDao = new CourseGradeImpl();

        Education education = educationDao.getById(1);
        Student student = studentDao.getById(2);
        Course course = courseDao.getById(1);
        Teacher teacher = teacherDao.getById(1);

     //   educationDao.create(new Education("Javautvecklare"));

      //  studentDao.create(new Student("Yinn","Lee"), education);
       // teacherDao.create(new Teacher("Daniel", "Danielsson"), education);
       // System.out.println(education);

        //courseDao.create(new Course("Javatest"));
       //courseDao.create(new Course(education,"javatest" ));
       //courseDao.create(new Course(education,"utveckling mot databaser" ));

        //Gets the course and created a Set
       /* Set<Course> test = new LinkedHashSet<>();
        Course course = courseDao.getById(1);
        Course course2 = courseDao.getById(2);*/

        //Adds courses to the set and then to the teacher class
       // teacherDao.setCourse(course,test,teacherDao.getById(1));
       // teacherDao.setCourse(course2,test, teacherDao.getById(1));


        /*CourseGrade courseGrade = new CourseGrade();
        courseGrade.setCourse(course);
        courseGrade.setStudent(student);
        courseGrade.setGrade(1);*/
        //courseGradeDao.create2(new CourseGrade(3,student, course));


        //Update - Education
      /*  education.setName("Java");
        educationDao.update(education);*/

        //Update - Student
       /* student.setFirstName("Luke");
        studentDao.update(student);*/

        //Update - Teacher
      /*  teacher.setFirstName("Danne");
        teacherDao.update(teacher);*/

        //Update - Course
        /*course.setName("Javautveckling");
        courseDao.update(course);*/

        //Update - CourseGrade
       /*  CourseGrade courseGrade = courseGradeDao.getById(new CourseGradeKey(1, 1));
         courseGrade.setGrade(4);
        courseGradeDao.update(courseGrade);*/

        //getAll - Education
       //educationDao.getAll().forEach(System.out::println);
        //getAll - Student
       // studentDao.getAll().forEach(System.out::println);
        //getAll - Teacher
       // teacherDao.getAll().forEach(System.out::println);
        //getAll - Course
        //courseDao.getAll().forEach(System.out::println);
        //getALl - CourseGrade
       // courseGradeDao.getAll().forEach(System.out::println);

        //getByEducation - Course
       // courseDao.getByEducation(1).forEach(System.out::println);
        //getByEducaiton - Student
       // studentDao.getByEducation(1).forEach(System.out::println);

        //remove student form eduaction
        /*student.setEducation(null);
        studentDao.update(student);*/

        //add student to education
       /* student.setEducation(education);
        studentDao.update(student);*/

    }
}
