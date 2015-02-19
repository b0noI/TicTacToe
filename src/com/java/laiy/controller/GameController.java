package com.java.laiy.controller;


import com.java.laiy.model.Board;
import com.java.laiy.model.Figure;
import com.java.laiy.model.Player;

import java.util.Scanner;

public class GameController {

    private static final int MIN_COORDINATE = 0;

    private static final int MAX_COORDINATE = 3;

    private String gameName = "XO";


    final Figure figureX = new Figure("X");
    final Figure figure0 = new Figure("0");

    final Player player1 = new Player("Vasa", figureX);
    final Player player2 = new Player("John", figure0);

    private Player[] players = new Player[]{player1, player2};

    private Board board;
    private int playerNumber = 0;


    public GameController(String gameName, Board board) {

        this.gameName = gameName;
        this.board = board;
    }

    public String getGameName() {
        return gameName;
    }

    public int getCurrentPlayer() {
        return playerNumber;
    }

    public String getPlayersName() {
        return players[getCurrentPlayer()].getName();
    }

    public boolean move(final int x, final int y) {
        Player current = players[getCurrentPlayer()];
        if (!checkCoordinate(x) || !checkCoordinate(y)) {
            return false;
        }

        if (x == 0 && y == 0) {
            board.figure11 = current.getFigure();
            changePlayer();
        }


        return true;
    }

    private static boolean checkCoordinate(final int coordinate) {
        if (coordinate < MIN_COORDINATE || coordinate > MAX_COORDINATE) {
            return false;
        }
        return true;
    }
    public int changePlayer() {
        if (playerNumber == 0) playerNumber = 1;
        else playerNumber = 0;
        return playerNumber;
    }
}
