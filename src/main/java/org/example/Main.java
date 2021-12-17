package org.example;


import org.example.Menus.EducationMenu;

import java.util.Scanner;

public class Main {
    private static final Scanner sc  = new Scanner(System.in);
    private static final Command[] commands = new Command[5];

    public Main(){
        commands[1] = new EducationMenu();
        commands[0] = this::shutdown;
    }

    public static void main( String[] args ) {
        Main main  = new Main();
        main.run();
    }

    private void shutdown(){
        System.exit(0);
    }

    private void run(){
        int choice = 0;
        do {
            printMenuOption();
            choice = readChoice(sc);
            executeChoice(choice);
        }while(choice != 0);
    }

    private void executeChoice(int choice){
        commands[choice].execute();
    }
    private int readChoice(Scanner sc){
        return sc.nextInt();
    }

    private void printMenuOption(){
        System.out.println("1. Education");
        System.out.println("2. Course");
        System.out.println("3. Student");
        System.out.println("4. Grade");
        System.out.println("0. Exit");
    }

}
