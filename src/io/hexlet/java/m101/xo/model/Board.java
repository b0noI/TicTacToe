package io.hexlet.java.m101.xo.model;

import io.hexlet.java.m101.xo.helpers.CoordinateHelper;

public class Board {


    public static final int SIZE_FIELD = 3;

    Figure[][] board = new Figure[SIZE_FIELD][SIZE_FIELD];



    public Figure getFigure(final int x, final int y) {

        if (CoordinateHelper.coordinateHelper(x, y)) {
            return board [x][y];
        }
            return null;
    }

    public boolean setFigure(final int x, final int y, final Figure figure){


        if ((CoordinateHelper.coordinateHelper(x, y)) && (figure != null) &&(getFigure(x,y)==null) ){

            board [x] [y] = figure;
    }
            return false;

    }


}
