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
    public void testShowMenuWithResult() throws Exception {
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
}