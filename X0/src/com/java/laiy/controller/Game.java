package com.java.laiy.controller;


import com.java.laiy.model.Player;

public class Game {

    private  static final String GAME_NAME = "X0";

    private Player[] players;

    public  String getGameName() {
        return GAME_NAME;
    }

    public Player currentPlayer() {
        return null;
    }

    public boolean move(final int x, final int y) {
        return false;
    }

    public Player[] getPlayersName() {
        return players;
    }
}
