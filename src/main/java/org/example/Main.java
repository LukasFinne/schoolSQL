package org.example;


import org.example.menu.*;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final Command[] commands = new Command[6];

    public Main() {
        commands[1] = new EducationMenu();
        commands[2] = new CourseMenu();
        commands[3] = new StudentMenu();
        commands[4] = new TeacherMenu();
        commands[5] = new StatsMenu();
        commands[0] = this::shutdown;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void shutdown() {
        System.exit(0);
    }

    private void run() {
        int choice = 0;
        do {
            printMenuOption();
            choice = readChoice(sc);
            executeChoice(choice);
        } while (choice != 0);
    }

    private void executeChoice(int choice) {
        commands[choice].execute();
    }

    private int readChoice(Scanner sc) {
        return sc.nextInt();
    }

    private void printMenuOption() {
        System.out.println("1. Education");
        System.out.println("2. Course");
        System.out.println("3. Student");
        System.out.println("4. Teacher");
        System.out.println("5. Stats");
        System.out.println("0. Exit");
    }

}
