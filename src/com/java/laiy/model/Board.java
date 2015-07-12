package com.java.laiy.model;

import com.java.laiy.helpers.CoordinateHelper;
import com.java.laiy.model.exceptions.EmptyFigureException;
import com.java.laiy.model.exceptions.InvalidPointException;
import com.java.laiy.model.exceptions.PointOccupiedException;

public class Board {

    private static final int DEFAULT_BOARD_SIZE = 3;

    private final Figure[][] figures;

    public Board() {
        this(DEFAULT_BOARD_SIZE);
    }

    public Board(final int customBoardSize) {
        if (customBoardSize < DEFAULT_BOARD_SIZE) {
            this.figures = new Figure[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
        }
         else {
            this.figures = new Figure[customBoardSize][customBoardSize];
        }
    }

    public void setFigure(final int x, final int y, final Figure figure) throws InvalidPointException,
                                                                                PointOccupiedException,
                                                                                EmptyFigureException {
        if (!CoordinateHelper.checkCoordinates(x, y)) {
            throw new InvalidPointException();
        }
        else if (figures[x][y] != null) {
            throw new PointOccupiedException();
        }
        else if (figure == null){
            throw new EmptyFigureException();
        }
        else {
            figures[x][y] = figure;
        }
    }

    public Figure getFigure(final int x, final int y) throws InvalidPointException{
        if (!CoordinateHelper.checkCoordinates(x,y)) {
            throw new InvalidPointException();
        }
        else {
            return figures[x][y];
        }
    }

    public Figure[][] getFiguresArray() {
            return figures;
    }

    public int getRowLength(final int row) {
        return figures[row].length;
    }

}