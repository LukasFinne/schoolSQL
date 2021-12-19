package org.example.menu;

import org.example.Command;
import org.example.tables.Course;
import org.example.tables.Education;
import org.example.dao.CourseDao;
import org.example.dao.EducationDao;
import org.example.impl.CourseImpl;
import org.example.impl.EducationImpl;
import org.example.tables.Student;

import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CourseMenu implements Command {
    EducationDao educationDao = new EducationImpl();
    CourseDao courseDao = new CourseImpl();
    Education education;
    Course course;

    private void searchMethod() {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine().toLowerCase();
        command = command.replaceAll("\\s+", "");
        switch (command) {
            case "add" -> {
                System.out.println("Write the education id then the name of the course you want to add");
                System.out.println("For example: 1 John Doe ");
                idCheck(sc);
            }
            case "update" -> {
                System.out.println("Write the id of the course you want to update and then the updated name");
                getCourseId(sc).setName(name(sc));
                courseDao.update(course);
            }
            case "id" -> {
                System.out.println("to search for specific education just write the id here: ");
                System.out.println(getCourseId(sc));
            }
            case "delete" -> {
                System.out.println("Write the id of the course you want to delete");
                getCourseId(sc);
                courseDao.delete(course);
            }
            case "all" -> courseDao.getAll().forEach(System.out::println);
            case "updateeducation" -> {
                System.out.println("To edit a course education write student id then the education or null if you want to remove it");
                System.out.println("For example (course id)1, (education id)1");
                getCourseId(sc).setEducation(getEducationId(sc));
                courseDao.update(course);
            }
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

    private void idCheck(Scanner sc) {
        Education idCheck = getEducationId(sc);
        if (idCheck == null)
            System.out.println("That id doesn't exist");
        else
            courseDao.create(new Course(name(sc)), idCheck);
    }

    private String name(Scanner sc) {
        return sc.next();
    }

    private Education getEducationId(Scanner sc) {
        return education = educationDao.getById(sc.nextInt());
    }

    private Course getCourseId(Scanner sc) {
        return course = courseDao.getById(sc.nextInt());
    }

    private void printMenuOption() {
        System.out.println("Here you can search, add, remove, update anything related to the course table");
        System.out.println("write \"commands\" to get all the available");
    }

    @Override
    public void execute() {
        printMenuOption();
        try {
            searchMethod();
        } catch (InputMismatchException e) {
            System.out.println("Wrong input, just numbers please! no alphabets");
        } catch (RollbackException e) {
            System.out.println("Already exists");
        } catch (IllegalArgumentException | PersistenceException | NullPointerException e) {
            System.out.println("That id doesnt exist");
        }
    }
}
