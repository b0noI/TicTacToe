package com.java.laiy;

import com.java.laiy.controller.GameController;
import com.java.laiy.model.Board;
import com.java.laiy.model.Figure;
import com.java.laiy.model.Player;
import com.java.laiy.view.ConsoleView;

public class Main {

    public static void main(final String[] args) {
        final String GAME_NAME = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Xonstantin", Figure.X);
        players[1] = new Player("Oleg", Figure.O);
        final GameController gameController = new GameController(GAME_NAME, players, board);
        final ConsoleView consoleView = new ConsoleView(gameController);
        final Game game = new Game(consoleView,gameController);

        game.theGame();
    }


}
