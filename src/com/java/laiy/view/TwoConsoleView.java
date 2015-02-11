package com.java.laiy.view;

import com.java.laiy.controller.GameController;

public class TwoConsoleView extends ConsoleView {

    private static final char CHARACTER_HYPHEN = '-';

    private static final byte LINE_SIZE = 20;

    public TwoConsoleView(final GameController game) {
        super(game);
    }

    @Override
    public void showGameName() {
        printLine(CHARACTER_HYPHEN, LINE_SIZE);
        System.out.println("\n" + game.getGameName());
    }

    @Override
    public void showPlayersName() {
        printLine(CHARACTER_HYPHEN, LINE_SIZE);
        System.out.println("\n" + game.getPlayersName());
    }

    public static void printLine(final Character lineCharacter, final int lineSize) {
        for (int i = 0; i < lineSize; i++) {
            System.out.print(lineCharacter);

        }
    }

}
