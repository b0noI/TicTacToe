package com.java.laiy.controller;

import com.java.laiy.model.Board;
import com.java.laiy.model.Figure;
import com.java.laiy.model.Player;
import com.java.laiy.model.exceptions.PointOccupiedException;
import org.ietf.jgss.GSSManager;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameControllerTest {

    @Test
    public void testGetWinnerForDiags() throws Exception {
        final String gameName = "XO";
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);

        final Board boardLeft = new Board();
        final GameController gameControllerLeft = new GameController(gameName, players, boardLeft);
        final Figure testValueLeft = Figure.O;
        boardLeft.setFigure(0,0,testValueLeft );
        boardLeft.setFigure(1,1,testValueLeft );
        boardLeft.setFigure(2,2,testValueLeft );
        assertEquals(players[1],gameControllerLeft.getWinner());

        final Board boardRight = new Board();
        final GameController gameControllerRight = new GameController(gameName, players, boardRight);
        final Figure testValueRight = Figure.X;
        boardRight.setFigure(2,0,testValueRight);
        boardRight.setFigure(1,1,testValueRight);
        boardRight.setFigure(0,2,testValueRight);
        assertEquals(players[0],gameControllerRight.getWinner());
    }

    @Test
    public void testGetWinnerNull() throws Exception {
        final String gameName = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final Figure testValueO = Figure.O;
        final Figure testValueX = Figure.X;
        final GameController gameControllerNull = new GameController(gameName, players, board);
        board.setFigure(0,0,testValueO);
        board.setFigure(0,1,testValueX);
        board.setFigure(1,2,testValueO);
        board.setFigure(0,2,testValueX);
        board.setFigure(2,0,testValueO);
        board.setFigure(1,0,testValueX);
        board.setFigure(1,1,testValueX);
        assertNull(gameControllerNull.getWinner());

    }

    @Test
    public void testGetWinnerForLines() throws Exception {
        final String gameName = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final GameController gameController = new GameController(gameName, players, board);
        final Figure testValue = Figure.O;
        board.setFigure(0,0,testValue);
        board.setFigure(0,1,testValue);
        board.setFigure(0,2,testValue);
        assertEquals(players[1],gameController.getWinner());
    }

    @Test
    public void testGetWinnerForRows() throws Exception {
        final String gameName = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final GameController gameController = new GameController(gameName, players, board);
        final Figure testValue = Figure.O;
        board.setFigure(0,0,testValue);
        board.setFigure(1,0,testValue);
        board.setFigure(2,0,testValue);
        assertEquals(players[1],gameController.getWinner());
    }

    @Test
    public void testGetGameName() throws Exception {
        final String gameName = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final GameController gameController = new GameController(gameName, players, board);
        assertEquals(gameName,gameController.getGameName());

    }

    @Test
    public void testGetPlayers() throws Exception {
        final String gameName = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final GameController gameController = new GameController(gameName, players, board);
        assertEquals(players, gameController.getPlayers());
    }

    @Test
    public void testGetBoard() throws Exception {
        final String gameName = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final GameController gameController = new GameController(gameName, players, board);
        assertEquals(board,gameController.getBoard());

    }

    @Test
    public void testMove() throws Exception {
        final String gameName = "XO";
        final Figure testValue = Figure.O;
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final GameController gameController = new GameController(gameName, players, board);
        gameController.move(1,1,testValue);
        assertEquals(testValue,gameController.getBoard().getFigure(1,1));
    }

    @Test
    public void testIncorrectMove() throws Exception {
        final String gameName = "XO";
        final Figure testValue = Figure.O;
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final GameController gameController = new GameController(gameName, players, board);
        gameController.move(1,1,testValue);
        try {
            gameController.move(1,1,testValue);
            fail();
        } catch (PointOccupiedException e) {}
    }

    @Test
    public void testGetCurrentPlayer() throws Exception {
        final String gameName = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final GameController gameController = new GameController(gameName, players, board);
        final Figure testValueO = Figure.O;
        final Figure testValueX = Figure.X;
        board.setFigure(0,0,testValueO);
        board.setFigure(0,1,testValueX);
        board.setFigure(1,2,testValueO);
        board.setFigure(0,2,testValueX);
        board.setFigure(2,0,testValueO);
        board.setFigure(1,0,testValueX);
        assertEquals(players[1],gameController.getCurrentPlayer(players[1]));
        assertEquals(players[0],gameController.getCurrentPlayer(players[0]));
    }
}