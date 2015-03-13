package com.java.laiy.view;

import com.java.laiy.controller.GameController;

public class AdvConsoleView extends  ConsoleView {

    private static final String CHARACTER_HYPHEN = "__";

    private static final byte LINE_SIZE = 3;

    public AdvConsoleView(final GameController game) {
        super(game);
    }

    @Override
    public void showGameName() {
        printLine(CHARACTER_HYPHEN, LINE_SIZE);
        System.out.println("\n" + game.getGameName());
    }
}
