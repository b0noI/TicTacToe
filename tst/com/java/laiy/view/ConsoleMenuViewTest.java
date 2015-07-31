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
    public void testShowMenuWithResultIncorrectInputForString() throws Exception {
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
    public void testShowMenuWithResultInputIncorrectForInt() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("0\n".getBytes());
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
                "> Choice is incorrect, please try again\n" +
                "++++  XO Magic  ++++\n" +
                "1 - Play\n" +
                "2 - Load\n" +
                "3 - Set up and play\n" +
                "4 - Exit\n" +
                "> ", outContent.toString());
        outContent.reset();

        ByteArrayInputStream in1 = new ByteArrayInputStream("-4\n".getBytes());
        System.setIn(in1);
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
                "> Choice is incorrect, please try again\n" +
                "++++  XO Magic  ++++\n" +
                "1 - Play\n" +
                "2 - Load\n" +
                "3 - Set up and play\n" +
                "4 - Exit\n" +
                "> ", outContent.toString());
        outContent.reset();

        ByteArrayInputStream in2 = new ByteArrayInputStream("5\n".getBytes());
        System.setIn(in2);
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
                "> Choice is incorrect, please try again\n" +
                "++++  XO Magic  ++++\n" +
                "1 - Play\n" +
                "2 - Load\n" +
                "3 - Set up and play\n" +
                "4 - Exit\n" +
                "> ", outContent.toString());
        outContent.reset();
    }

    @Test
    public void testShowMenuWithResultStart() throws Exception {
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

        ByteArrayInputStream in1 = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(in1);
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

        ByteArrayInputStream in2 = new ByteArrayInputStream("3\n".getBytes());
        System.setIn(in2);
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

        ByteArrayInputStream in3 = new ByteArrayInputStream("4\n".getBytes());
        System.setIn(in3);
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
}