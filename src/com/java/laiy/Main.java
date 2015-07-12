package com.java.laiy;

import com.java.laiy.controller.GameController;
import com.java.laiy.model.Board;
import com.java.laiy.model.Figure;
import com.java.laiy.model.Player;
import com.java.laiy.view.ConsoleView;

public class Main {

    public static void main(final String[] args) {

        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final GameController game = new GameController("string for the name of the game", players, board);
        final ConsoleView twoConsoleView = new ConsoleView(game);
        final ConsoleView consoleView = new ConsoleView(game);
        startGame(twoConsoleView);
    }

    private static void startGame(final ConsoleView consoleView) {
        consoleView.showGameName();
        consoleView.showPlayers();
    }

}
