package com.java.laiy.view;


import com.java.laiy.controller.GameController;

public class ConsoleView {

    public final GameController game;

    public ConsoleView(final GameController game) {
        this.game = game;
    }

    public  void showGameName() {
        System.out.println(game.getGameName());
    }

    public void showPlayersName() {
        System.out.println(game.getPlayersName());
    }

    public static void printLine(final Character lineCharacter, final int lineSize) {
        for (int i = 0; i < lineSize; i++) {
            System.out.print(lineCharacter);

        }
    }

}
