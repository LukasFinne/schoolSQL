package org.example.Menus;

import org.example.Command;
import org.example.Education;
import org.example.dao.EducationDao;
import org.example.impl.EducationImpl;

import java.util.Scanner;

public class EducationMenu implements Command {

    EducationDao dao = new EducationImpl();
    Education education;

    private void searchMethod(){
        Scanner sc = new Scanner(System.in);
        switch (sc.next().toLowerCase()) {
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
            case "all" -> System.out.println(dao.getAll());
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

    private String name(Scanner sc){
        return sc.next();
    }
    private Education getId(Scanner sc){
       return education = dao.getById(sc.nextInt());
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
