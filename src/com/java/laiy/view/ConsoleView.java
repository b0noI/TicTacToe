package com.java.laiy.view;


import com.java.laiy.controller.GameController;
import com.java.laiy.model.Player;
import com.java.laiy.helpers.CoordinateHelper;
import com.java.laiy.model.Point;
import com.java.laiy.model.exceptions.InvalidPointException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView implements IView {

    private static final int LINE_SIZE = 3;

    private static final String CHARACTER_HYPHEN = "_";

    private static final String EMPTY_FIGURE = " ";

    private static final String INPUT_ERROR = "Coordinate is incorrect, please try again";

    protected final GameController game;

    public ConsoleView(final GameController game) {
        assert game != null;
        this.game = game;
    }

    public Point startTurn() {
        System.out.println("Next turn!");
        return new Point(getCoordinate(),getCoordinate());
    }

    public  void showGameName() {
        System.out.println(game.getGameName());
    }

    public void showPlayers() {
         for (Player player : game.getPlayers()) {
             System.out.println(player.getName() + ": " + player.getFigure().toString());
         }
    }

    public void showBoard() {
        for (int i = 0 ; i < game.getBoard().getFiguresArray().length; i++) {
            showBoardLine(i);
            printLine(CHARACTER_HYPHEN, LINE_SIZE);
        }
    }

    private void printLine(final String lineCharacter, final int lineSize) {
        for (int i = 0; i < lineSize; i++) {
            System.out.print(lineCharacter);
        }
        System.out.println();
    }

    private void showBoardLine(final int row)  {
        for (int i = 0; i < game.getBoard().getRowLength(row); i++) {
            try {
                if (game.getBoard().getFigure(row, i) == null) {
                    System.out.print(EMPTY_FIGURE);
                } else {
                    System.out.print(game.getBoard().getFigure(row, i).toString());
                }
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }

    private int getCoordinate() {
        while (true) {
            System.out.print("Input the coordinate ");
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
