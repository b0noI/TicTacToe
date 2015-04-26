package com.java.laiy.model;

import com.java.laiy.helpers.CoordinateHelper;

public class Board {

    private static final int BOARD_SIZE = 3;

    private Figure[][] figures = new Figure[BOARD_SIZE][BOARD_SIZE];

    public Board(Figure[][] figures) {
        assert figures != null;
        this.figures = figures;
    }

    public boolean setFigure(final int x, final int y, final Figure figure) {
        if (!CoordinateHelper.checkCoordinate(x) || !CoordinateHelper.checkCoordinate(y) || figures[x][y] != null)  {
            return false;
        }
        else {
            figures[x][y] = figure;
            return true;
        }
    }

    public Figure getFigure(final int x, final int y) {
        if (!CoordinateHelper.checkCoordinate(x) || !CoordinateHelper.checkCoordinate(y)) {
            return null;
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
