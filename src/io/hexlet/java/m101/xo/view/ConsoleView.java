package io.hexlet.java.m101.xo.view;


import io.hexlet.java.m101.xo.controller.GameController;
import io.hexlet.java.m101.xo.helpers.CoordinateHelper;
import io.hexlet.java.m101.xo.model.Board;
import io.hexlet.java.m101.xo.model.Figure;
import io.hexlet.java.m101.xo.model.Player;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ConsoleView {

    protected final GameController gameController;

    private static final String LINE_CHARACTER = "~";

    private static final int LINE_SIZE = 12;

    private static final int NUMBER_ATTEMPTS_UNPUT = 3;

    private static final Scanner scanner = new Scanner(System.in);

    public ConsoleView(final GameController gameController) {

        assert gameController != null;

        this.gameController = gameController;

    }

    public void start(final Player[] players, final Board board) {

        showGameName();

        inputPlayersNames(players);

         do {
            showCurrentPlayer();
            board.setFigure(getCoordinate("x"),getCoordinate("y"), gameController.currentFigure());
            showBoard();

         } while (gameController.winner(board)==null);

         System.out.println("WINNER "+gameController.winnerPlayer().getFigure()+" - Player - "+gameController.winnerPlayer()+"!!!");

    }


    public void showGameName() {
        System.out.println(gameController.getGameName());
    }

    public Player createPlayer (final String name, final Figure figure){

        return new Player(name,figure);
    }

    public void showPlayersName() {
        for (Player player : gameController.getPlayers())
            System.out.println(player);
    } //not used

    public void inputPlayersNames(Player[] players){
        for (int i=0; i<GameController.COUNT_OF_PLAYERS; i++) {
            System.out.print("Please input name of " + Figure.values()[i] + " - Player : ");
            players[i] = createPlayer(scanner.nextLine(), Figure.values()[i]);
            System.out.println();
        }
    }

    public void showBoard() {
        for (int i = 0; i < Board.SIZE_FIELD; i++) {
            showBoardLine(i);
            showLine(LINE_SIZE);
        }
    }

    public void showCurrentPlayer() {

        System.out.println("Now setting figure: "+gameController.currentPlayer().getFigure()+" PLayer "+gameController.currentPlayer());

    }

    protected void showBoardLine(final int row) {
        for (int i = 0; i < Board.SIZE_FIELD; i++) {

            System.out.print((gameController.getBoard().getFigure(row, i)));
        }
        System.out.println();
    }

    private void showLine(final int size) {
        for (int i = 0; i < size; i = i + 1) {
            System.out.print(LINE_CHARACTER);
        }
        System.out.println();

    }

    private int getCoordinate(final String coordinateName) {

        int counter = 0;

        do {

            System.out.print("Input coordinate " + coordinateName+" > ");

            try {

                final Scanner in = new Scanner(System.in);

                final int input;

                if (CoordinateHelper.checkCoordinate(input=in.nextInt())){

                return input;

                } else {
                    System.out.println("Coordinate is incorrect, please input number from "+CoordinateHelper.MIN_COORDINATE+" to "+ (CoordinateHelper.MAX_COORDINATE));
                    counter += 1;
                }

            } catch (final InputMismatchException e) {

                System.out.println("Coordinate is incorrect");
                counter += 1;
            }
        } while (counter < NUMBER_ATTEMPTS_UNPUT);

        return -1;
    }





    @Override
    public String toString() {
        return super.toString();
    }
}







