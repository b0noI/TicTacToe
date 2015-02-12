package com.java.laiy.controller;


import com.java.laiy.model.Board;
import com.java.laiy.model.Player;

public class GameController {

    private  final String gameName;

    private Player[] players;

    private final Board board;

    public GameController(final String gameName, final Board board) {
        this.gameName = gameName;
        this.board = board;
    }

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
