package com.java.laiy.view;

import com.java.laiy.controller.Game;
import com.java.laiy.controller.GameController;
import com.java.laiy.model.Board;
import com.java.laiy.model.Figure;
import com.java.laiy.model.Player;

import javax.xml.soap.SOAPPart;
import java.util.Scanner;

public class ConsoleMenuView {

    private static final int START_CODE = 1;

    private static final int LOAD_CODE = 2;

    private static final int SETTINGS_CODE = 3;

    private static final int EXIT_CODE = 4;

    public static void showMenuWithResult() {

        System.out.println("++++  XO Magic  ++++");
        System.out.println(START_CODE + " - Play");
        System.out.println(LOAD_CODE + " - Load");
        System.out.println(SETTINGS_CODE + " - Set up and play");
        System.out.println(EXIT_CODE + " - Exit");
        System.out.print("> ");

        final Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case START_CODE:
                System.out.println("A new game started");
                defaultStart();
                break;
            case LOAD_CODE:
                System.out.println("Loading...");
                //TODO
                break;
            case SETTINGS_CODE:
                customInput();
                break;
            case EXIT_CODE:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Choice is incorrect, please try again");
                break;
        }
    }

    private static void defaultStart(){
        final String gameName = "XO";
        final int boardSize = 3;
        final String playerOneName = "PLAYER X";
        final String playerTwoName = "PLAYER O";
        customStart(boardSize,playerOneName,playerTwoName, gameName);
    }

    private static void customInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter game name:");
        String gameName = input.nextLine();
        System.out.println("Enter player one name:");
        String playerOneName = input.nextLine();
        System.out.println("Enter player two name:");
        String playerTwoName = input.nextLine();
        System.out.println("Enter board size:");
        int boardSize = input.nextInt();
        customStart(boardSize,playerOneName,playerTwoName, gameName);
    }

    private static void customStart(final int boardSize, final String playerOneName, final String playerTwoName, final String gameName){
        final Board board = new Board(boardSize);
        final Player[] players = new Player[2];
        players[0] = new Player(playerOneName, Figure.X);
        players[1] = new Player(playerTwoName, Figure.O);
        final GameController gameController = new GameController(gameName, players, board);
        final ConsoleView consoleView = new ConsoleView(gameController);
        final Game game = new Game(consoleView,gameController);
        game.theGame();
    }
}
