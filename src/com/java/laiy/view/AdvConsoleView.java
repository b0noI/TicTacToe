package com.java.laiy.view;

import com.java.laiy.controller.GameController;

/**
 * Created by Алексей on 11.02.2015.
 */
public class AdvConsoleView extends  ConsoleView {

    public AdvConsoleView(GameController game) {
        super(game);
    }

    @Override
    public void showGameName() {
        System.out.println("******");
        game.getGameName();
    }
}
