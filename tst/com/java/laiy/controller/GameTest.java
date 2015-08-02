package com.java.laiy.controller;

import com.java.laiy.model.Board;
import com.java.laiy.model.Figure;
import com.java.laiy.model.Player;
import com.java.laiy.view.ConsoleView;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

public class GameTest {

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
    public void testTheGameStartTurn() throws Exception {
        final String GAME_NAME = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Xonstantin", Figure.X);
        players[1] = new Player("Oleg", Figure.O);
        final GameController game = new GameController(GAME_NAME, players, board);
        final ConsoleView consoleView = new ConsoleView(game);
        final Game gameGo = new Game(consoleView);
        ByteArrayInputStream in = new ByteArrayInputStream("asd\n".getBytes());
        System.setIn(in);
        try {
            gameGo.theGame();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("Next turn!\n" +
                     "Input the coordinate Incorrect input, please try again\n" +
                     "Input the coordinate ", outContent.toString());
        outContent.reset();

        ByteArrayInputStream in1 = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(in1);
        try {
            gameGo.theGame();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("Next turn!\n" +
                "Input the coordinate Input the coordinate ", outContent.toString());
        outContent.reset();

    }

    @Test
    public void testTheGame() throws Exception {
        final String GAME_NAME = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Xonstantin", Figure.X);
        players[1] = new Player("Oleg", Figure.O);
        final GameController game = new GameController(GAME_NAME, players, board);
        final ConsoleView consoleView = new ConsoleView(game);
        final Game gameGo = new Game(consoleView);
        ByteArrayInputStream in = new ByteArrayInputStream("asd\n".getBytes());
        System.setIn(in);
        try {
            gameGo.theGame();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("Next turn!\n" +
                "Input the coordinate Incorrect input, please try again\n" +
                "Input the coordinate ", outContent.toString());
        outContent.reset();

        ByteArrayInputStream in1 = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(in1);
        try {
            gameGo.theGame();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("Next turn!\n" +
                "Input the coordinate Input the coordinate ", outContent.toString());
        outContent.reset();

    }
}