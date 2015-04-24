package com.java.laiy;

import com.java.laiy.controller.GameController;
import com.java.laiy.model.Board;
import com.java.laiy.model.Figure;
import com.java.laiy.model.Player;
import com.java.laiy.view.ConsoleView;
import com.java.laiy.view.MenuView;

public class Main {

    public static void main(final String[] args) {

        //final MenuView menu = new MenuView();
        //menu.showMenuWithResult();

        final Figure[][] figures = new Figure[3][3];

        Figure figureX = Figure.X;
        Figure figureO = Figure.O;

        final Board board = new Board(figures);

        final Player[] players = new Player[2];
        players[0] = new Player("Oleg", figureX);
        players[1] = new Player("Dima", figureO);

        final GameController game = new GameController("TicTacToe", players, board);
        final ConsoleView consoleView = new ConsoleView(game);

        startGame(consoleView);

        do {
            movePlayer(consoleView, players[0], board, game);
            printBoard(consoleView);
            checkWin(game);
        } while (game.getWinner() == null);
    }

    private static void startGame(final ConsoleView consoleView) {
        consoleView.showGameName();
        consoleView.showPlayers();
    }

    private static void movePlayer(final ConsoleView consoleView,
                                   final Player firstPlayer,
                                   final Board board,
                                   final GameController game) {
        boolean validInput = false;
        do {
            Player currentPlayer = game.getCurrentPlayer(firstPlayer);
            Figure currentFigure = currentPlayer.getFigure();

            int coordinateX = consoleView.start("X", currentPlayer);
            int coordinateY = consoleView.start("Y", currentPlayer);

            board.setFigure(coordinateX, coordinateY, currentFigure);

            if (game.check(coordinateX,coordinateY)) {
                validInput = true;
            }
        } while (!validInput);
    }

    private static void checkWin(GameController game) {
        if (game.getWinner() != null){
            System.out.println(game.getWinner().getName() + " won!");
        }
    }

    private static void printBoard(ConsoleView consoleView) {
        consoleView.showBoard();
    }

}
