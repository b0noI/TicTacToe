package com.java.laiy.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ConsoleMenuViewTest {

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
    public void testShowMenuWithResultIncorrectInput() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("String for incorrect input\n".getBytes());
        System.setIn(in);
        try {
            ConsoleMenuView.showMenuWithResult();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("++++  XO Magic  ++++\n" +
                    "1 - Play\n" +
                    "2 - Load\n" +
                    "3 - Set up and play\n" +
                    "4 - Exit\n" +
                    "> Please enter correct choice\n" +
                    "++++  XO Magic  ++++\n" +
                    "1 - Play\n" +
                    "2 - Load\n" +
                    "3 - Set up and play\n" +
                    "4 - Exit\n" +
                    "> ", outContent.toString());
        outContent.reset();
    }

    @Test
    public void testShowMenuWithResultDefaultStart() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);
        try {
            ConsoleMenuView.showMenuWithResult();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("++++  XO Magic  ++++\n" +
                "1 - Play\n" +
                "2 - Load\n" +
                "3 - Set up and play\n" +
                "4 - Exit\n" +
                "> A new game started\n" +
                "PLAYER X: X\n" +
                "PLAYER O: O\n" +
                "Next turn!\n" +
                "Input the coordinate ", outContent.toString());
        outContent.reset();
    }

    @Test
    public void testShowMenuWithResultCustomStart() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("3\n".getBytes());
        System.setIn(in);
        try {
            ConsoleMenuView.showMenuWithResult();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("++++  XO Magic  ++++\n" +
                "1 - Play\n" +
                "2 - Load\n" +
                "3 - Set up and play\n" +
                "4 - Exit\n" +
                "> Enter player one name:\n", outContent.toString());
        outContent.reset();
    }

    @Test
    public void testShowMenuWithResultLoad() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("2\n3\n".getBytes());
        System.setIn(in);
        try {
            ConsoleMenuView.showMenuWithResult();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("++++  XO Magic  ++++\n" +
                "1 - Play\n" +
                "2 - Load\n" +
                "3 - Set up and play\n" +
                "4 - Exit\n" +
                "> Loading...\n", outContent.toString());
        outContent.reset();
    }

    @Test
    public void testShowMenuWithResultExit() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("4\n".getBytes());
        System.setIn(in);
        try {
            ConsoleMenuView.showMenuWithResult();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("++++  XO Magic  ++++\n" +
                "1 - Play\n" +
                "2 - Load\n" +
                "3 - Set up and play\n" +
                "4 - Exit\n" +
                "> Exit\n", outContent.toString());
        outContent.reset();
    }

    @Test
    public void testCustomInputForIn() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("S0me pl4y3r n4m3 1\n S0me pl4y3r n4m3 2\n".getBytes());
        System.setIn(in);
        try {
            ConsoleMenuView.customInput();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("Enter player one name:\n" +
                "Enter player two name:\n" +
                "Enter board size:\n", outContent.toString());
        outContent.reset();
    }

    @Test
    public void testEnterSizeIncorrectInputString() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("Xonstantin\n Oleg\n".getBytes());
        System.setIn(in);
        try {
            ConsoleMenuView.enterSize();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("Enter board size:\n" +
                "Input is wrong, please enter correct integer greater than 3\n" +
                "Enter board size:\n", outContent.toString());
        outContent.reset();
    }

    @Test
    public void testEnterSizeIncorrectInputInt() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("0\n".getBytes());
        System.setIn(in);
        try {
            ConsoleMenuView.enterSize();
        }
        catch (final NoSuchElementException e){
            e.printStackTrace();
        }
        assertEquals("Enter board size:\n" +
                "Input is wrong, please enter correct integer greater than 3\n" +
                "Enter board size:\n", outContent.toString());
        outContent.reset();
    }

    @Test
    public void testEnterSizeInputInt() throws Exception {
        final int expectedValue = 4;
        ByteArrayInputStream in = new ByteArrayInputStream("4\n".getBytes());
        System.setIn(in);
        assertEquals(expectedValue,ConsoleMenuView.enterSize());
    }

}