package com.java.laiy.view;

import com.java.laiy.controller.Game;

public class TwoConsoleView extends ConsoleView {

    private static final int ZERO_VALUE_FILTR_SWITCH = 0;

    private static final int ONE_VALUE_FILTR_SWITCH = 1;

    public TwoConsoleView(final Game game) {
        super(game);
    }

    @Override
    public void  showGameName() {
        filtrValue(0);
        System.out.println(game.getGameName());
    }

    @Override
    public void showPlayersName() {
        filtrValue(1);
        System.out.println(game.getPlayersName());
    }

     //depending on the value displays characters before showPlayersName and after the showGamesName
    private static void filtrValue (final int a) {

        switch (a) {
            case ZERO_VALUE_FILTR_SWITCH:
                System.out.println("***");
                break;
            case ONE_VALUE_FILTR_SWITCH:
                System.out.println("$$$");
                break;
            default:
                System.out.println("incorrect value");
        }
    }


}
