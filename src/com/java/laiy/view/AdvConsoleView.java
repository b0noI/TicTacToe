package com.java.laiy.view;

import com.java.laiy.controller.GameController;

public class AdvConsoleView extends  ConsoleView {

    private static final char CHARACTER_HYPHEN = '*';

    private static final byte LINE_SIZE = 5;

    public AdvConsoleView(final GameController game) {
        super(game);
    }

    @Override
    public void showGameName() {
        printLine(CHARACTER_HYPHEN, LINE_SIZE);
        System.out.println("\n" + game.getGameName());
    }
}
