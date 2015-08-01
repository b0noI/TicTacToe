package com.java.laiy.view;

import com.java.laiy.controller.GameController;
import com.java.laiy.model.Board;
import com.java.laiy.model.Figure;
import com.java.laiy.model.Player;
import org.junit.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class ConsoleViewTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

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
    public void testStartTurn() throws Exception{
        final String GAME_NAME = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Xonstantin", Figure.X);
        players[1] = new Player("Oleg", Figure.O);
        final GameController game = new GameController(GAME_NAME, players, board);
        final ConsoleView consoleView = new ConsoleView(game);
        ByteArrayInputStream in = new ByteArrayInputStream("String for incorrect input\n".getBytes());
        System.setIn(in);
        try {
            consoleView.startTurn();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("Next turn!\n" +
                "Input the coordinate Incorrect input, please try again\n" +
                "Input the coordinate ", outContent.toString());
        outContent.reset();

        ByteArrayInputStream in1 = new ByteArrayInputStream("2\n3\n".getBytes());
        System.setIn(in1);
        try {
            consoleView.startTurn();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("Next turn!\n" +
                "Input the coordinate Input the coordinate ", outContent.toString());
        outContent.reset();

        ByteArrayInputStream in2 = new ByteArrayInputStream("-77\n".getBytes());
        System.setIn(in2);
        try {
            consoleView.startTurn();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("Next turn!\n" +
                "Input the coordinate Incorrect input, please try again\n" +
                "Input the coordinate ", outContent.toString());
        outContent.reset();
    }

    @Test
    public void testSetCoordinates() throws Exception {
        final String GAME_NAME = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Xonstantin", Figure.X);
        players[1] = new Player("Oleg", Figure.O);
        final GameController game = new GameController(GAME_NAME, players, board);
        final ConsoleView consoleView = new ConsoleView(game);

        ByteArrayInputStream in = new ByteArrayInputStream("String for incorrect input\n".getBytes());
        System.setIn(in);
        try {
            consoleView.getCoordinate();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("Input the coordinate Incorrect input, please try again\n" +
                "Input the coordinate ", outContent.toString());

        outContent.reset();

        ByteArrayInputStream in1 = new ByteArrayInputStream("-77".getBytes());
        System.setIn(in1);
        try {
            consoleView.getCoordinate();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("Input the coordinate Incorrect input, please try again\n" +
                "Input the coordinate ", outContent.toString());

        outContent.reset();

        ByteArrayInputStream in2 = new ByteArrayInputStream("2".getBytes());
        System.setIn(in2);
        try {
            consoleView.getCoordinate();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("Input the coordinate ", outContent.toString());

        ByteArrayInputStream in3 = new ByteArrayInputStream("3\n".getBytes());
        System.setIn(in3);
        assertEquals(2, consoleView.getCoordinate());

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
                                        "---\n" +
                                        " O \n" +
                                        "---\n" +
                                        "  O\n" +
                                        "---\n";

        assertEquals(expectedValue, outContent.toString());
    }

    @Test
    public void testShowWinner() throws Exception {
        final String GAME_NAME = "XO";
        final String expectedValueO = "Oleg";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Xonstantin", Figure.X);
        players[1] = new Player("Oleg", Figure.O);
        final GameController game = new GameController(GAME_NAME, players, board);
        final ConsoleView consoleView = new ConsoleView(game);
        Figure testValue = Figure.O;
        board.setFigure(0,0,testValue);
        board.setFigure(1,1,testValue);
        board.setFigure(2,2,testValue);
        consoleView.showWinner();
        assertEquals("The winner is " + expectedValueO + "\n", outContent.toString());
    }

    @Test
    public void testShowDraw() throws Exception {
        final String GAME_NAME = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Xonstantin", Figure.X);
        players[1] = new Player("Oleg", Figure.O);
        final GameController game = new GameController(GAME_NAME, players, board);
        final ConsoleView consoleView = new ConsoleView(game);
        consoleView.showDraw();
        assertEquals("Draw!" + "\n", outContent.toString());
    }

    @Test
    public void testShowPointOccupied() throws Exception {
        final String GAME_NAME = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Xonstantin", Figure.X);
        players[1] = new Player("Oleg", Figure.O);
        final GameController game = new GameController(GAME_NAME, players, board);
        final ConsoleView consoleView = new ConsoleView(game);
        consoleView.showPointOccupied();
        assertEquals("Point already occupied!" + "\n", outContent.toString());
    }

    @Test
    public void testAnotherGameIncorrectInput() throws Exception {
        final String GAME_NAME = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Xonstantin", Figure.X);
        players[1] = new Player("Oleg", Figure.O);
        final GameController game = new GameController(GAME_NAME, players, board);
        final ConsoleView consoleView = new ConsoleView(game);
        ByteArrayInputStream in = new ByteArrayInputStream("String for incorrect input\n".getBytes());
        System.setIn(in);
        consoleView.anotherGame();
        assertEquals("Want another game? Press y/n\n" +
                "Please enter \"y\" or \"n\"\n", outContent.toString());
    }

    @Test
    public void testAnotherGameExit() throws Exception {
        final String GAME_NAME = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Xonstantin", Figure.X);
        players[1] = new Player("Oleg", Figure.O);
        final GameController game = new GameController(GAME_NAME, players, board);
        final ConsoleView consoleView = new ConsoleView(game);
        ByteArrayInputStream in = new ByteArrayInputStream("n\n".getBytes());
        System.setIn(in);
        exit.expectSystemExitWithStatus(0);
        consoleView.anotherGame();
    }

    @Test
    public void testAnotherGameStart() throws Exception {
        final String GAME_NAME = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Xonstantin", Figure.X);
        players[1] = new Player("Oleg", Figure.O);
        final GameController game = new GameController(GAME_NAME, players, board);
        final ConsoleView consoleView = new ConsoleView(game);
        ByteArrayInputStream in = new ByteArrayInputStream("y\n".getBytes());
        System.setIn(in);
        try {
            consoleView.anotherGame();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("Want another game? Press y/n\n" +
                "++++  XO Magic  ++++\n" +
                "1 - Play\n" +
                "2 - Load\n" +
                "3 - Set up and play\n" +
                "4 - Exit\n" +
                "> ", outContent.toString());
    }

    @Test
    public void testGetGameController() throws Exception{
        final String GAME_NAME = "XO";
        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Xonstantin", Figure.X);
        players[1] = new Player("Oleg", Figure.O);
        final GameController game = new GameController(GAME_NAME, players, board);
        final ConsoleView consoleView = new ConsoleView(game);
        assertEquals(game,consoleView.getGameController());
    }
}