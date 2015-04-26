package com.java.laiy.view;


import com.java.laiy.controller.GameController;
import com.java.laiy.model.Player;
import com.java.laiy.helpers.CoordinateHelper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private static final int LINE_SIZE = 3;

    private static final String CHARACTER_HYPHEN = "-";

    private static final String EMPTY_FIGURE = " ";

    private static final String COORDINATE_X = "X";

    private static final String COORDINATE_Y = "Y";

    private static final String INPUT_ERROR = "Coordinate is incorrect, please try again";

    public final GameController game;

    public ConsoleView(final GameController game) {
        assert game != null;
        this.game = game;
    }

    public int start(String coordinate, Player player) {
        int x = 0;
        switch(coordinate) {
            case "X":
                x = getCoordinate(COORDINATE_X, player);
                break;
            case "Y":
                x = getCoordinate(COORDINATE_Y, player);
                break;
            default:
                System.out.println();;
                break;
        }
        return x;
    }

    public void showGameName() {
        System.out.println(game.getGameName());
    }

    public void showPlayers() {
         for (Player player : game.getPlayers()) {
             System.out.println(player.getName() + ": " + player.getFigure().toString() );
         }
    }

    public void showBoard() {
        for (int i = 0 ; i < game.getBoard().getFiguresArray().length; i++) {
            showBoardLine(i);
            printLine(CHARACTER_HYPHEN, LINE_SIZE);
        }
    }

    public void showBoardLine(final int row) {
        for (int i = 0; i < game.getBoard().getRowLength(row); i++) {
            if (game.getBoard().getFigure(row, i) == null) {
                System.out.print(EMPTY_FIGURE);
            } else {
                System.out.print(game.getBoard().getFigure(row, i).toString());
            }
        }
        System.out.println();
    }

    public static void printLine(final String lineCharacter, final int lineSize) {
        for (int i = 0; i < lineSize; i++) {
            System.out.print(lineCharacter);
        }
        System.out.println();
    }

    private int getCoordinate(final String coordinateName, final Player player) {
        while (true) {
            System.out.print(player.getName() + ", ");
            System.out.print(String.format("input the coordinate %s:", coordinateName));
            try {
                final Scanner in = new Scanner(System.in);
                int coordinate = in.nextInt() - 1;
                if (CoordinateHelper.checkCoordinate(coordinate)) {
                    return coordinate;
                }
                else {
                    System.out.println(INPUT_ERROR);
                }
            }
            catch (final InputMismatchException e) {
                System.out.println(INPUT_ERROR);
                }
            }

    }

}
