package io.hexlet.java.m101.xo.view;

import java.util.Scanner;

public class MenuView {

    private static final int START_CODE = 1;
    private static final int LOAD_CODE = 2;
    private static final int SETTINGS_CODE = 3;
    private static final int EXIT_CODE = 4;

    public int showMenuWithResult() {

        System.out.println(START_CODE+" - Start");
        System.out.println(LOAD_CODE+" - Load");
        System.out.println(SETTINGS_CODE+" - Settings");
        System.out.println(EXIT_CODE+" - Exit");
        System.out.print("> ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice){

            case START_CODE:
                System.out.println("STAAART!!!");
                break;

            case LOAD_CODE:
                System.out.println("Load...");
                break;
            case SETTINGS_CODE:
                System.out.println("Settings %+-/*");
                break;
            case EXIT_CODE:
                System.out.println("Exit :(");
                break;

            default:
                System.out.println("Really ?!?!");
                break;
        }

        return 0;

    }


}
