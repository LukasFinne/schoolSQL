package org.example.menu;

import org.example.Command;
import org.example.tables.Education;
import org.example.dao.EducationDao;
import org.example.impl.EducationImpl;

import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EducationMenu implements Command {

    EducationDao dao = new EducationImpl();
    Education education;

    private void searchMethod() {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine().toLowerCase();
        command = command.replaceAll("\\s+", "");
        switch (command) {
            case "add" -> {
                System.out.println("Write the name of the education you want to create");
                dao.create(new Education(name(sc)));
            }
            case "update" -> {
                System.out.println("Write the id of the education you want to update and the updated name");
                getId(sc).setName(name(sc));
                dao.update(education);
            }
            case "id" -> {
                System.out.println("to search for specific education just write the id here: ");
                System.out.println(getId(sc));
            }
            case "delete" -> {
                System.out.println("Write the id of the education you want to delete");
                getId(sc);
                dao.delete(education);
            }
            case "all" -> dao.getAll().forEach(System.out::println);
            case "commands" -> {
                System.out.println("Commands: add, update, id, delete, all");
                searchMethod();
            }
            default -> {
                System.out.println("Försök igen!");
                execute();
            }
        }

    }

    private String name(Scanner sc) {
        return sc.next();
    }

    private Education getId(Scanner sc) {
        return education = dao.getById(sc.nextInt());
    }

    private void printMenuOption() {
        System.out.println("Here you can search, add, remove, update anything related to the education table");
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
        }catch (IllegalArgumentException | NullPointerException e){
            System.out.println("That id doesnt exist");
        }
    }
}
