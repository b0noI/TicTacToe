package com.java.laiy.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void testGetX() throws Exception {
        final int expectedValue = 0;
        final int secondValue = 1;
        final Point point = new Point(expectedValue,secondValue);
        assertEquals(expectedValue,point.getX());
    }

    @Test
    public void testGetY() throws Exception {
        final int expectedValue = 0;
        final int secondValue = 1;
        final Point point = new Point(secondValue,expectedValue);
        assertEquals(expectedValue,point.getY());
    }
}