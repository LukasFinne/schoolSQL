package org.example.Menus;

import org.example.*;
import org.example.dao.CourseDao;
import org.example.dao.CourseGradeDao;
import org.example.dao.EducationDao;
import org.example.dao.StudentDao;
import org.example.impl.CourseGradeImpl;
import org.example.impl.CourseImpl;
import org.example.impl.EducationImpl;
import org.example.impl.StudentImpl;

import java.util.Scanner;

public class StudentMenu implements Command {

    StudentDao studentDao = new StudentImpl();
    EducationDao educationDao = new EducationImpl();
    CourseGradeDao courseGradeDao = new CourseGradeImpl();
    CourseDao courseDao = new CourseImpl();
    Student student;
    Education education;
    Course course;


    private void searchMethod(){
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine().toLowerCase();
        command = command.replaceAll("\\s+", "");
        switch (command) {
            case "add" -> {
                System.out.println("Write the name of the student you want to add then the education id you want to him/her to");
                System.out.println("For example: John Doe 1");
                studentDao.create(new Student(name(sc), name(sc)), getEducationId(sc));
            }
            case "update" -> {
                System.out.println("Write the student id then the students updated name");
                System.out.println("For example: 1 John Doe");
                getStudentId(sc).setName(name(sc), name(sc));
                studentDao.update(student);
            }
            case "id" -> {
                System.out.println("To search for specific student write the student id here: ");
                System.out.println(getStudentId(sc));
            }
            case "delete" -> {
                System.out.println("Write the id of the student you want to delete");
                getStudentId(sc);
                studentDao.delete(student);
            }
            case "all" -> studentDao.getAll().forEach(System.out::println);
            case "getbyeducation" -> {
                System.out.println("to see a student specific education just write the id of the education");
                studentDao.getByEducation(sc.nextInt()).forEach(System.out::println);
            }
            case "getgradebyid" -> {
                System.out.println("To see a specific students grades please write the student id and course id");
                System.out.println("For example: (student id)1 (course id)1");
                System.out.println(courseGradeDao.getById(new CourseGradeKey(sc.nextInt(), sc.nextInt())));
            }
            case "getallgrades" -> {
                courseGradeDao.getAll().forEach(System.out::println);
            }
            case "addgrade" -> {
                System.out.println("To add a grade to a student just write, the grade, student id and course id");
                System.out.println("In this school the grade system is like this: F=0 E=1 D=2 C=3 B=4 A=5");
                System.out.println("For example: (grade)1 (student id)2 (course id)3");
                courseGradeDao.create(new CourseGrade(sc.nextInt(),getStudentId(sc),getCourseId(sc)));
            }
            case "deletegrade" -> {
                System.out.println("To delete a students grade from a course just write, the students id and course id");
                System.out.println("For example: (student id)1 (course id)2");
                CourseGrade courseGrade = courseGradeDao.getById(new CourseGradeKey(sc.nextInt(), sc.nextInt()));
                courseGradeDao.remove(courseGrade);
            }
            case "commands" -> {
                System.out.println("Commands: add, update, id, delete, all, add grade, delete grade");
                System.out.println("get all grades,get grade by id, get by education ");
                searchMethod();
            }
            default -> {
                System.out.println("Försök igen!");
                execute();
            }
        }

    }

    private String name(Scanner sc){
        return sc.next();
    }
    private Student getStudentId(Scanner sc){
        return student = studentDao.getById(sc.nextInt());
    }
    private Course getCourseId(Scanner sc){
        return course = courseDao.getById(sc.nextInt());
    }
    private Education getEducationId(Scanner sc){
        return education = educationDao.getById(sc.nextInt());
    }

    private void printMenuOption(){
        System.out.println("Here you can search, add, remove, update anything related to the eduation table");
        System.out.println("write \"commands\" to get all the available");
    }

    @Override
    public void execute() {
        printMenuOption();
        searchMethod();
    }
}
