package io.hexlet.java.m101.xo.view;

import io.hexlet.java.m101.xo.controller.GameController;


public class AdvConsoleView extends ConsoleView {

    private static final String SYMBOL = "***";

    public AdvConsoleView(final GameController gameController) {
       super(gameController);
    }

    @Override
    public void showGameName() {
        System.out.println(SYMBOL);
        System.out.println(gameController.getGameName());
    }

}
