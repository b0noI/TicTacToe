package com.java.laiy.view;

import com.java.laiy.controller.Game;
import com.java.laiy.controller.GameStarter;
import com.java.laiy.model.exceptions.InvalidBoardSizeException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMenuView {

    private static final int START_CODE = 1;

    private static final int LOAD_CODE = 2;

    private static final int SETTINGS_CODE = 3;

    private static final int EXIT_CODE = 4;

    private static int BOARD_SIZE;

    private static final int MIN_SIZE = 3;

    public static void showMenuWithResult() {

        System.out.println("++++  XO Magic  ++++");
        System.out.println(START_CODE + " - Play");
        System.out.println(LOAD_CODE + " - Load");
        System.out.println(SETTINGS_CODE + " - Set up and play");
        System.out.println(EXIT_CODE + " - Exit");
        System.out.print("> ");

        try {
            final Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case START_CODE:
                    System.out.println("A new game started");
                    GameStarter.defaultStart().theGame();
                    break;
                case LOAD_CODE:
                    System.out.println("Loading...");
                    //TODO
                    break;
                case SETTINGS_CODE:
                    customInput().theGame();
                    break;
                case EXIT_CODE:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Choice is incorrect, please try again");
                    showMenuWithResult();
                    break;
            }
        }
        catch (final InputMismatchException e)
        {
            System.out.println("Please enter correct choice");
            showMenuWithResult();
        }

    }

    protected static Game customInput() {
        Scanner input = new Scanner(System.in);
        final String gameName = "XO";
        System.out.println("Enter player one name:");
        String playerOneName = input.nextLine();
        System.out.println("Enter player two name:");
        String playerTwoName = input.nextLine();
        final int boardSize = enterSize();
        return GameStarter.customStart(boardSize,playerOneName,playerTwoName, gameName);
    }

    protected static int enterSize(){
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter board size:");
            BOARD_SIZE = input.nextInt();
            if (BOARD_SIZE < MIN_SIZE){
                throw new InvalidBoardSizeException();
            }
        }
        catch (final InputMismatchException | InvalidBoardSizeException e){
            System.out.println("Input is wrong, please enter correct integer greater than 3");
            enterSize();
        }
        return BOARD_SIZE;
    }

}
