package org.example.Menus;

import org.example.Command;
import org.example.Course;
import org.example.Education;
import org.example.Student;
import org.example.dao.CourseDao;
import org.example.dao.EducationDao;
import org.example.impl.CourseImpl;
import org.example.impl.EducationImpl;

import java.util.Scanner;

public class CourseMenu implements Command {
    EducationDao educationDao = new EducationImpl();
    CourseDao courseDao = new CourseImpl();
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
                courseDao.create(new Course(name(sc)),getEducationId(sc));
            }
            case "update" -> {
                System.out.println("Write the id of the education you want to update and the updated name");
                getCourseId(sc).setName(name(sc));
                courseDao.update(course);
            }
            case "id" -> {
                System.out.println("to search for specific education just write the id here: ");
                System.out.println(getCourseId(sc));
            }
            case "delete" -> {
                System.out.println("Write the id of the education you want to delete");
                getCourseId(sc);
                courseDao.delete(course);
            }
            case "all" -> courseDao.getAll().forEach(System.out::println);
            case "getbyeducation" -> {
                System.out.println("to see all courses connected to a specfic education, just write the education id");
                courseDao.getByEducation(sc.nextInt()).forEach(System.out::println);
            }
            case "commands" -> {
                System.out.println("Commands: add, update, id, delete, all, get by education");
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
    private Education getEducationId(Scanner sc){
        return education = educationDao.getById(sc.nextInt());
    }
    private Course getCourseId(Scanner sc){
        return course = courseDao.getById(sc.nextInt());
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
