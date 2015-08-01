package com.java.laiy.controller;

import com.java.laiy.model.Board;
import com.java.laiy.model.Figure;
import com.java.laiy.model.Player;
import com.java.laiy.view.ConsoleView;

public class GameStarter {

    public static Game defaultStart(){
        final int boardSize = 3;
        final String gameName = "XO";
        final String playerOneName = "PLAYER X";
        final String playerTwoName = "PLAYER O";
        return customStart(boardSize,playerOneName,playerTwoName, gameName);
    }

    public static Game customStart(final int BOARD_SIZE, final String playerOneName, final String playerTwoName, final String gameName){
        final Board board = new Board(BOARD_SIZE);
        final Player[] players = new Player[2];
        players[0] = new Player(playerOneName, Figure.X);
        players[1] = new Player(playerTwoName, Figure.O);
        final GameController gameController = new GameController(gameName, players, board);
        final ConsoleView consoleView = new ConsoleView(gameController);
        final Game game = new Game(consoleView);
        consoleView.showPlayers();
        return game;
    }
}
