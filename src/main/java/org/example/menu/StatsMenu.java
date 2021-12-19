package org.example.menu;

import org.example.Command;
import org.example.Stats;
import org.example.impl.StatsImpl;
import org.example.tables.CourseGrade;
import org.example.tables.CourseGradeKey;

import java.util.Arrays;
import java.util.Scanner;

public class StatsMenu implements Command {

    Stats stats = new StatsImpl();

    private void searchMethod() {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine().toLowerCase();
        command = command.replaceAll("\\s+", "");
        switch (command) {
            case "avggradebystudents" -> {
                System.out.println("-- Students average grade -- ");
                System.out.println("F=0 E=1 D=2 C=3 B=4 A=5 ");
                stats.AverageGradeByStudent().forEach(r -> System.out.println(Arrays.toString(r)));
            }
            case "avggradebycourse" -> {
                System.out.println("-- Course average grade -- ");
                System.out.println("F=0 E=1 D=2 C=3 B=4 A=5 ");
                stats.AverageGradeByCourse().forEach(r -> System.out.println(Arrays.toString(r)));
            }
            case "avggrade" -> {
                System.out.println("-- Average grade of all students --");
                System.out.println("F=0 E=1 D=2 C=3 B=4 A=5 ");
                stats.AverageGrade().forEach(System.out::println);
            }
            case "commands" -> {
                System.out.println("Commands: avg grade by students, avg grade by course, avg grade");
                searchMethod();
            }
            default -> {
                System.out.println("Try again please");
                execute();
            }
        }

    }

    private void printMenuOption() {
        System.out.println("Here you can find different interesting stats about this school!");
        System.out.println("write \"commands\" to get all the available");
    }


    @Override
    public void execute() {
        printMenuOption();
        searchMethod();
    }
}
