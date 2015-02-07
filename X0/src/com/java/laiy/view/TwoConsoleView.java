package com.java.laiy.view;

import com.java.laiy.controller.Game;

public class TwoConsoleView extends ConsoleView {

    public TwoConsoleView(final Game game) {
        super(game);
    }

    @Override
    public void  showGameName() {
        System.out.println("***");
        System.out.println(game.getGameName());
    }

    @Override
    public void showPlayersName() {
        System.out.println("$$$");
        System.out.println(game.getPlayersName());
    }


}
