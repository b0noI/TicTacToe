package io.hexlet.java.m101.xo;

import io.hexlet.java.m101.xo.controller.GameController;
import io.hexlet.java.m101.xo.model.Board;
import io.hexlet.java.m101.xo.model.Figure;
import io.hexlet.java.m101.xo.model.Player;
import io.hexlet.java.m101.xo.tests.TestWinner;
import io.hexlet.java.m101.xo.view.ConsoleView;



public class Main {

    public static void main(String[] args) {

        Player[]players = new Player[GameController.COUNT_OF_PLAYERS];
        Board board = new Board();
        GameController gameController = new GameController(GameController.GAME_NAME,players,board);
        ConsoleView consoleView = new ConsoleView(gameController);

        consoleView.start(players,board);

    }
}




