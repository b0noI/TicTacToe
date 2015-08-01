package com.java.laiy.view;


import com.java.laiy.controller.GameController;
import com.java.laiy.model.Player;
import com.java.laiy.model.Point;
import com.java.laiy.model.exceptions.InvalidPointException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView implements IView {

    private static final String CHARACTER_HYPHEN = "-";

    private static final String EMPTY_FIGURE = " ";

    private static final String INPUT_ERROR = "Incorrect input, please try again";

    protected final GameController game;

    public ConsoleView(final GameController game) {
        assert game != null;
        this.game = game;
    }

    public GameController getGameController(){
        return game;
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
        int lineSize = game.getBoard().getFiguresArray().length;
        for (int i = 0 ; i < lineSize; i++) {
            showBoardLine(i);
            printLine(CHARACTER_HYPHEN, lineSize);
        }
    }

    public void  showWinner(){
        System.out.println("The winner is " + game.getWinner().getName());
    }

    public void showDraw(){
        System.out.println("Draw!");
    }

    public void showPointOccupied(){
        System.out.println("Point already occupied!");
    }

    public void anotherGame() {
        System.out.println("Want another game? Press y/n");
        try {
            final Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            switch (choice) {
                case "y":
                    ConsoleMenuView.showMenuWithResult();
                    break;
                case "n":
                    System.out.println("Exit...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter \"y\" or \"n\"");
                    anotherGame();
                    break;
            }
        }
        catch (final InputMismatchException e)
        {
            System.out.println("Please enter \"y\" or \"n\"");
            anotherGame();
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

    protected int getCoordinate() {
        while (true) {
            System.out.print("Input the coordinate ");
            try {
                final Scanner in = new Scanner(System.in);
                    int coordinate = in.nextInt() - 1;
                    if (game.getBoard().checkCoordinate(coordinate)) {
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
