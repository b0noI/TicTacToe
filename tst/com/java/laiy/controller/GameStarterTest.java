package com.java.laiy.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class GameStarterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testDefaultStartOutput() throws Exception {
        GameStarter.defaultStart();
        assertEquals("PLAYER X: X\n" +
                     "PLAYER O: O\n",outContent.toString());

    }
    @Test
    public void testDefaultStart() throws Exception {
        final String gameName = "XO";
        final String playerOneName = "PLAYER X";
        final String playerTwoName = "PLAYER O";
        final int boardSize = 3;
        assertEquals(boardSize,GameStarter.defaultStart().getGameController().getBoard().getFiguresArray().length);
        assertEquals(gameName,GameStarter.defaultStart().getGameController().getGameName());
        assertEquals(playerOneName,GameStarter.defaultStart().getGameController().getPlayers()[0].getName());
        assertEquals(playerTwoName,GameStarter.defaultStart().getGameController().getPlayers()[1].getName());
    }

    @Test
    public void testCustomStart() throws Exception {
        final int boardSize = 4;
        final String gameName = "XOxo";
        final String playerOneName = "PLAYER XxXx";
        final String playerTwoName = "PLAYER OoOo";
        final Game newGame = GameStarter.customStart(boardSize,playerOneName,playerTwoName,gameName);
        assertEquals(boardSize,newGame.getGameController().getBoard().getFiguresArray().length);
        assertEquals(gameName, newGame.getGameController().getGameName());
        assertEquals(playerOneName, newGame.getGameController().getPlayers()[0].getName());
        assertEquals(playerTwoName, newGame.getGameController().getPlayers()[1].getName());
    }

    @Test
    public void testCustomStartIncorrectInput() throws Exception {
        final int boardSize = -4;
        final String gameName = "XOxo";
        final String playerOneName = "PLAYER XxXx";
        final String playerTwoName = "PLAYER OoOo";
        final Game newGame = GameStarter.customStart(boardSize,playerOneName,playerTwoName,gameName);
        assertNull(newGame.getGameController().getBoard());
    }
}