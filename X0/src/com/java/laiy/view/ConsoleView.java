package com.java.laiy.view;


import com.java.laiy.controller.Game;

public class ConsoleView {

    public final Game game;


    public ConsoleView(final Game game) {
        this.game = game;
    }

    public  void showGameName() {
        System.out.println(game.getGameName());
    }

    public void showPlayersName() {
        System.out.println(game.getPlayersName());
    }
}
