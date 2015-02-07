package com.java.laiy;

import com.java.laiy.controller.Game;
import com.java.laiy.view.ConsoleView;
import com.java.laiy.view.TwoConsoleView;

public class Main {

    public static void main(String[] args) {

        final Game game = new Game();
        final TwoConsoleView twoConsoleView = new TwoConsoleView(game);
        final ConsoleView consoleView = new ConsoleView(game);
        startGame(twoConsoleView);
    }

    private static void startGame(final ConsoleView twoConsoleView) {
        twoConsoleView.showPlayersName();
        twoConsoleView.showGameName();
    }
}
