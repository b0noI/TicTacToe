package com.java.laiy.controller;

import com.java.laiy.model.Board;
import com.java.laiy.model.Figure;
import com.java.laiy.model.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class RulesControllerTest {

    @Test
    public void testGetNextTurnWhenWin() throws Exception {
        final String gameName = "XO";
        final Figure testValueO = Figure.O;
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final GameController gameController = new GameController(gameName, players, board);
        final RulesController rulesController =new RulesController(gameController);
        gameController.move(1,1,players[1]);
        assertEquals(true,rulesController.getNextTurn());
        gameController.move(2,2,players[0]);
        assertEquals(true,rulesController.getNextTurn());
        gameController.move(0,2,players[1]);
        assertEquals(true,rulesController.getNextTurn());
        gameController.move(2,1,players[0]);
        assertEquals(true,rulesController.getNextTurn());
        gameController.move(2,0,players[1]);
        assertEquals(false,rulesController.getNextTurn());
    }

    @Test
    public void testGetNextTurnWhenFull() throws Exception {
        final String gameName = "XO";
        final Figure testValueO = Figure.O;
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final GameController gameController = new GameController(gameName, players, board);
        final RulesController rulesController =new RulesController(gameController);
        gameController.move(1,1,players[1]);
        assertEquals(true,rulesController.getNextTurn());
        gameController.move(2,2,players[0]);
        assertEquals(true,rulesController.getNextTurn());
        gameController.move(0,0,players[1]);
        assertEquals(true,rulesController.getNextTurn());
        gameController.move(0,1,players[0]);
        assertEquals(true,rulesController.getNextTurn());
        gameController.move(0,2,players[1]);
        assertEquals(true,rulesController.getNextTurn());
        gameController.move(1,0,players[0]);
        assertEquals(true,rulesController.getNextTurn());
        gameController.move(1,2,players[1]);
        assertEquals(true,rulesController.getNextTurn());
        gameController.move(2,0,players[0]);
        assertEquals(true,rulesController.getNextTurn());
        gameController.move(2,1,players[1]);
        assertEquals(false,rulesController.getNextTurn());
    }
}