package com.java.laiy.controller;


import com.java.laiy.model.Player;

public class Game {

    private  final String gameName;

    public Game(final String gameName) {
        this.gameName = gameName;
    }

    private Player[] players;

    public  String getGameName() {
        return gameName;
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
