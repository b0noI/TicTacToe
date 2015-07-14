package com.java.laiy.view;

import com.java.laiy.controller.GameController;
import com.java.laiy.model.Board;
import com.java.laiy.model.Figure;
import com.java.laiy.model.Player;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ConsoleViewTest {

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
    public void testStartTurn() throws Exception {
        final String GAME_NAME = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Xonstantin", Figure.X);
        players[1] = new Player("Oleg", Figure.O);
        final GameController game = new GameController(GAME_NAME, players, board);
        final ConsoleView consoleView = new ConsoleView(game);
        // TODO

    }

    @Test
    public void testShowGameName() throws Exception {
        final String GAME_NAME = "XO";
        final String expectedGameName = GAME_NAME + "\n";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Xonstantin", Figure.X);
        players[1] = new Player("Oleg", Figure.O);
        final GameController game = new GameController(GAME_NAME, players, board);
        final ConsoleView consoleView = new ConsoleView(game);
        consoleView.showGameName();
        assertEquals(expectedGameName, outContent.toString());
    }

    @Test
    public void testShowPlayers() throws Exception {
        final String GAME_NAME = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Xonstantin", Figure.X);
        players[1] = new Player("Oleg", Figure.O);
        final GameController game = new GameController(GAME_NAME, players, board);
        final ConsoleView consoleView = new ConsoleView(game);
        final String expectedValue = "Xonstantin" + ": " + Figure.X.toString() + "\n" + "Oleg" + ": " + Figure.O.toString() + "\n";
        consoleView.showPlayers();
        assertEquals(expectedValue, outContent.toString());
    }

    @Test
    public void testShowBoard() throws Exception {
        final String GAME_NAME = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Xonstantin", Figure.X);
        players[1] = new Player("Oleg", Figure.O);
        final GameController game = new GameController(GAME_NAME, players, board);
        final ConsoleView consoleView = new ConsoleView(game);
        final Figure testValue = Figure.O;
        board.setFigure(0,0,testValue);
        board.setFigure(1,1,testValue);
        board.setFigure(2,2,testValue);
        consoleView.showBoard();
        final String expectedValue =    "O  \n" +
                                        "___\n" +
                                        " O \n" +
                                        "___\n" +
                                        "  O\n" +
                                        "___\n";

        assertEquals(expectedValue, outContent.toString());
    }

    @Test
    public void testShowWinner() throws Exception {
        //TODO
    }

    @Test
    public void testShowDraw() throws Exception {
        //TODO
    }

    @Test
    public void testShowPointOccupied() throws Exception {
        //TODO
    }
}