package com.java.laiy.controller;


import com.java.laiy.model.Board;
import com.java.laiy.model.Player;

public class GameController {

    private static final int MIN_COORDINATE = 0;

    private static final int MAX_COORDINATE = 3;

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

    public Player[] getPlayersName() {
        return players;
    }

    public boolean move(final int x, final int y) {
        if (!checkCoordinate(x) || !checkCoordinate(y)) {
            return false;
        }
        return true;
    }

    private static boolean checkCoordinate(final  int coordinate) {
        if (coordinate < MIN_COORDINATE || coordinate > MAX_COORDINATE) {
            return false;
        }
        return true;
    }

}
