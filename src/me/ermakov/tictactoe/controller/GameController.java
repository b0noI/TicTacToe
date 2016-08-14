package me.ermakov.tictactoe.controller;

import me.ermakov.tictactoe.model.Player;
import me.ermakov.tictactoe.model.Board;

/**
 * Created by user on 06.02.2015.
 */
public class GameController {

    private Player[] players;
    private final String gameName;
    private Board board;

    public GameController(final String gameName, final Board board) {
        this.gameName = gameName;
        this.board = board;
    }

    public String getGameName() {
        return gameName;
    }

    public boolean move(int x, int y) {
        return false;
    }

    public Player currentPlayer() {
        return null;
    }

}