package com.java.laiy.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testGetName() throws Exception {
        final String testValue = "The One";
        final String expectedValue = "The One";
        final Player player = new Player(testValue, Figure.O);
        assertEquals(expectedValue, player.getName());
    }

    @Test
    public void testGetFigure() throws Exception {
        final String playerName = "The One";
        final Figure testValue = Figure.O;
        final Figure expectedValue = Figure.O;
        final Player player = new Player(playerName, testValue);
        assertEquals(expectedValue, player.getFigure());

    }
}