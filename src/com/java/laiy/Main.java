package com.java.laiy;

import com.java.laiy.controller.GameController;
import com.java.laiy.model.Board;
import com.java.laiy.model.Figure;
import com.java.laiy.model.Player;
import com.java.laiy.view.ConsoleView;
import com.java.laiy.view.TwoConsoleView;

public class Main {

    public static void main(final String[] args) {

        final Figure figureX = new Figure("X");
        final Figure figure0 = new Figure("0");

        final Player player1 = new Player("Vasa", figureX);
        final Player player2 = new Player("John", figure0);

        final Board board = new Board();
        final GameController game = new GameController("XO", board);
        final TwoConsoleView twoConsoleView = new TwoConsoleView(game);
        final ConsoleView consoleView = new ConsoleView(game);
        startGame(twoConsoleView, board);
    }

    private static void startGame(final ConsoleView twoConsoleView, Board board) {
        twoConsoleView.showGameName();
        twoConsoleView.showPlayersName();
        twoConsoleView.drawBoard(board);

        boolean winner = false;

        while (!winner) {
            twoConsoleView.makeMove();
            twoConsoleView.drawBoard(board);

        }

    }

}
