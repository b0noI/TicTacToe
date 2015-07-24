package com.java.laiy.model;

import com.java.laiy.model.exceptions.InvalidPointException;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testSetIncorrectCoordinates() throws Exception {
        final Figure testValue = Figure.O;
        final Board board = new Board();

        try {
            board.setFigure(-1,-1,testValue);
            fail();
        } catch (final InvalidPointException e) {}

        try {
            board.setFigure(3,3,testValue);
            fail();
        } catch (final InvalidPointException e) {}

    }

    @Test
    public void testSetIncorrectX() throws Exception {
        final Figure testValue = Figure.O;
        final Board board = new Board();
        try {
            board.setFigure(-1, 0, testValue);
            fail();
        } catch (final InvalidPointException e) {}

        try {
            board.setFigure(3,0,testValue);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testSetIncorrectY() throws Exception {
        final Figure testValue = Figure.O;
        final Board board = new Board();
        try {
            board.setFigure(0, -2, testValue);
            fail();
        } catch (final InvalidPointException e) {}

        try {
            board.setFigure(0,3,testValue);
            fail();
        } catch (final InvalidPointException e) {}
    }


    @Test
    public void testSetFigure() throws Exception {
        final Figure testValue = Figure.O;
        final Figure expectedValue = Figure.O;
        final Board board = new Board();
        board.setFigure(0,0,testValue);
        assertEquals(expectedValue,board.getFigure(0,0));
    }

    @Test
    public void testGetFigure() throws Exception {
        final Board board = new Board();
        try {
            board.getFigure(0, -2);
            fail();
        } catch (final InvalidPointException e) {}

    }

    @Test
    public void testGetEmptyFigure() throws Exception {
        final Board board = new Board();
        assertNull(board.getFigure(1,1));
    }

    @Test
    public void testGetFiguresArray() throws Exception {
        final Figure testValue = Figure.O;
        final Board board = new Board();
        board.setFigure(0,0,testValue);
        board.setFigure(1,1,testValue);
        board.setFigure(2,2,testValue);
        final Figure[][] actualFigures = board.getFiguresArray();
        final Figure[][] expectedFigures = new Figure[][]{{testValue,null,null},{null,testValue,null},{null,null,testValue}};
        assertArrayEquals(expectedFigures,actualFigures);

    }

    @Test
    public void testGetRowLength() throws Exception {
        final int testSize = 11;
        final int defSize = 3;
        final Board customBoard = new Board(testSize);
        assertEquals(testSize,customBoard.getRowLength(0));

        final Board defBoard = new Board();
        assertEquals(defSize,defBoard.getRowLength(0));

    }
}