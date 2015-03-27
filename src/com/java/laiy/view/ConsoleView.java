package io.hexlet.java.m101.xo.view;

import io.hexlet.java.m101.xo.controller.GameController;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ConsoleView {

    protected final GameController gameController;

    private static final String LineCharacter = "~";

    private static final int LineSize = 12;

    private static final Scanner IN = new Scanner(System.in);

    public ConsoleView(final GameController gameController) {

        assert gameController != null;

        this.gameController = gameController;

    }

    public void start() {

        System.out.println("Please input coordinates");
        int x = getCoordinate("X ");
        int y = getCoordinate("Y ");


    }

    public void showGameName() {
        System.out.println(gameController.getGameName());
    }

    public void showPlayersName() {
        System.out.println(gameController.getPlayers());
    }

    public void showBoard() {
        for (int i = 0; i < 3; i = i + 1) {
            showBoardLine(i);
            showLine(LineSize);
        }
    }

    public void showCurrentPlayer() {

        System.out.println(gameController.currentPlayer().toString());

    }

    protected void showBoardLine(final int row) {
        for (int i = 0; i < 3; i = i + 1) {

            System.out.print((gameController.getBoard().getFigure(row, i)));
        }
        System.out.println();
    }

    private void showLine(final int size) {
        for (int i = 0; i < size; i = i + 1) {
            System.out.print(LineCharacter);
        }
        System.out.println();

    }

    private int getCoordinate(final String coordinateName) {

        int counter = 0;

        do {
            System.out.print(String.format("Input coordinate " + coordinateName));

            try {
                final Scanner in = new Scanner(System.in);

                return in.nextInt();

            } catch (final InputMismatchException e) {
                System.out.println("Coordinate is incorrect");
                counter += 1;
            }
        } while (counter < 3);

        return -1;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}







