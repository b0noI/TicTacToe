package com.java.laiy.view;


import com.java.laiy.controller.GameController;
import com.java.laiy.model.Board;

import java.util.Scanner;

public class ConsoleView {

    public final GameController game;


    public ConsoleView(final GameController game) {
        this.game = game;
    }

    public  void showGameName() {
        System.out.println(game.getGameName());
    }

    public void showPlayersName() {
        System.out.println(game.getPlayersName());
    }

    public static void printLine(final Character lineCharacter, final int lineSize) {
        for (int i = 0; i < lineSize; i++) {
            System.out.print(lineCharacter);

        }
    }

    public void drawBoard(Board board) {
        System.out.println(board.setBoard());
    }



    public void makeMove() {
        int xCoord = this.askForX(game.getCurrentPlayer());
        int yCoord = this.askForY(game.getCurrentPlayer());
        game.move(xCoord, yCoord);

    }

    public int askForX(int playerNumber) {
        System.out.print(game.getPlayersName() + ", " + "Enter X coord: ");
        Scanner sc = new Scanner(System.in);
        int xCoord = sc.nextInt();
        return xCoord;
    }

    public int askForY(int playerNumber) {
        System.out.print(game.getPlayersName() + ", " + "Enter Y coord: ");
        Scanner sc = new Scanner(System.in);
        int yCoord = sc.nextInt();
        return yCoord;
    }



}
