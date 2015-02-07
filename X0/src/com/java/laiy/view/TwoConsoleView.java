package com.java.laiy.view;

import com.java.laiy.controller.Game;

public class TwoConsoleView extends ConsoleView {

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
    private static void filtrValue (int a) {

        switch (a) {
            case 0:
                System.out.println("***");
                break;
            case 1:
                System.out.println("$$$");
                break;
            default:
                System.out.println("incorrect value");
        }
    }

}
