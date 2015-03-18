package com.java.laiy.controller;

import com.java.laiy.model.Board;
import com.java.laiy.model.Player;
import com.java.laiy.helpers.CoordinateHelper;

public class GameController {

    private static final String GAME_NAME = "XO";

    private  final String gameName;

    private final Player[] players;

    private final Board board;

    public GameController(final String gameName, final Player[] players, final Board board) {
        if (gameName == null || gameName.isEmpty()) {
            this.gameName = GAME_NAME;
        } else {
            this.gameName = gameName;
        }
        this.board = board;
        this.players = players;
    }

    public  String getGameName() {
        return gameName;
    }

    public Player currentPlayer() {
        return null;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public boolean move(final int x, final int y) {

        assert x >= 0;
        assert y >= 0;

        if (!CoordinateHelper.checkCoordinate(x) || !CoordinateHelper.checkCoordinate(y)) {
            return false;
        }

        return true;
    }

}
