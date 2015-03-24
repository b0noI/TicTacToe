package com.java.laiy;

import com.java.laiy.controller.GameController;
import com.java.laiy.model.Board;
import com.java.laiy.view.ConsoleView;
import com.java.laiy.view.TwoConsoleView;

public class Main {

    public static void main(final String[] args) {

        final Board board = new Board();
        final GameController game = new GameController("string for the name of the game", board);
        final TwoConsoleView twoConsoleView = new TwoConsoleView(game);
        final ConsoleView consoleView = new ConsoleView(game);
        startGame(twoConsoleView);
    }

    private static void startGame(final ConsoleView twoConsoleView) {
        twoConsoleView.showGameName();
        twoConsoleView.showPlayersName();
    }

}
