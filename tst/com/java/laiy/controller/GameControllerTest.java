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
    public void testGetNoWinner() throws Exception {
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
    public void testGetWinnerNulls() throws Exception {
        final String gameName = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final Figure testValueO = Figure.O;
        final Figure testValueX = Figure.X;
        final GameController gameControllerNulls = new GameController(gameName, players, board);
        assertNull(gameControllerNulls.getWinner());

    }

    @Test
    public void testGetWinnerForCustomBoard() throws Exception {
        final String gameName = "XO";
        final Board board = new Board(7);
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final Figure testValueO = Figure.O;
        final Figure testValueX = Figure.X;
        final GameController gameController = new GameController(gameName, players, board);
        board.setFigure(0,0,testValueO);
        board.setFigure(1,1,testValueX);
        board.setFigure(2,2,testValueO);
        board.setFigure(3,3,testValueX);
        board.setFigure(4,4,testValueO);
        board.setFigure(5,5,testValueX);
        board.setFigure(6,6,testValueX);
        assertNull(gameController.getWinner());

        final Board boardWin = new Board(7);
        final GameController gameControllerWin = new GameController(gameName, players, boardWin);
        boardWin.setFigure(0,0,testValueO);
        boardWin.setFigure(1,1,testValueO);
        boardWin.setFigure(2,2,testValueO);
        boardWin.setFigure(3,3,testValueO);
        boardWin.setFigure(4,4,testValueO);
        boardWin.setFigure(5,5,testValueO);
        boardWin.setFigure(6,6,testValueO);
        assertEquals(players[1],gameControllerWin.getWinner());

    }

    @Test
    public void testGetWinnerForLines() throws Exception {
        final String gameName = "XO";
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final Figure testValue = Figure.O;
        for (int i=0;i<3;i++) {
            final Board board = new Board();
            final GameController gameController = new GameController(gameName, players, board);
            board.setFigure(i, 0, testValue);
            board.setFigure(i, 1, testValue);
            board.setFigure(i, 2, testValue);
            assertEquals(players[1], gameController.getWinner());
        }
    }

    @Test
    public void testGetWinnerForColumns() throws Exception {
        final String gameName = "XO";
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final Figure testValue = Figure.O;
        for (int i=0;i<3;i++) {
            final Board board = new Board();
            final GameController gameController = new GameController(gameName, players, board);
            board.setFigure(0, i, testValue);
            board.setFigure(1, i, testValue);
            board.setFigure(2, i, testValue);
            assertEquals(players[1], gameController.getWinner());
        }
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
        assertArrayEquals(players, gameController.getPlayers());
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
        final Figure expectedValue = Figure.O;
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final GameController gameController = new GameController(gameName, players, board);
        gameController.move(1,1,players[1]);
        assertEquals(expectedValue,gameController.getBoard().getFigure(1,1));
    }

    @Test
    public void testIncorrectMove() throws Exception {
        final String gameName = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final GameController gameController = new GameController(gameName, players, board);
        gameController.move(1,1,players[1]);
        try {
            gameController.move(1,1,players[1]);
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

    @Test
    public void testGetNextTurnWhenWin() throws Exception {
        final String gameName = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final GameController gameController = new GameController(gameName, players, board);
        gameController.move(1,1,players[1]);
        assertEquals(true,gameController.getNextTurn());
        gameController.move(2,2,players[0]);
        assertEquals(true,gameController.getNextTurn());
        gameController.move(0,2,players[1]);
        assertEquals(true,gameController.getNextTurn());
        gameController.move(2,1,players[0]);
        assertEquals(true,gameController.getNextTurn());
        gameController.move(2,0,players[1]);
        assertEquals(false,gameController.getNextTurn());
    }

    @Test
    public void testGetNextTurnWhenFull() throws Exception {
        final String gameName = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Ox", Figure.X);
        players[1] = new Player("Xo", Figure.O);
        final GameController gameController = new GameController(gameName, players, board);
        gameController.move(1,1,players[1]);
        assertEquals(true,gameController.getNextTurn());
        gameController.move(2,2,players[0]);
        assertEquals(true,gameController.getNextTurn());
        gameController.move(0,0,players[1]);
        assertEquals(true,gameController.getNextTurn());
        gameController.move(0,1,players[0]);
        assertEquals(true,gameController.getNextTurn());
        gameController.move(0,2,players[1]);
        assertEquals(true,gameController.getNextTurn());
        gameController.move(1,0,players[0]);
        assertEquals(true,gameController.getNextTurn());
        gameController.move(1,2,players[1]);
        assertEquals(true,gameController.getNextTurn());
        gameController.move(2,0,players[0]);
        assertEquals(true,gameController.getNextTurn());
        gameController.move(2,1,players[1]);
        assertEquals(false,gameController.getNextTurn());
    }
}