package io.hexlet.java.m101.xo.view;

import io.hexlet.java.m101.xo.controller.GameController;


public class AdvConsoleView extends ConsoleView {

    public AdvConsoleView(final GameController gameController) {
       super(gameController);
    }

    @Override
    public void showGameName() {
        System.out.println("***");
        System.out.println(gameController.getGameName());
    }

}
