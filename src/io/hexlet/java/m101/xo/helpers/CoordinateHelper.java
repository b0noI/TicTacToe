package io.hexlet.java.m101.xo.helpers;

import io.hexlet.java.m101.xo.model.Board;

public class CoordinateHelper {

    public static final int MIN_COORDINATE = 0;
    public static final int MAX_COORDINATE = Board.SIZE_FIELD-1;


    public static boolean coordinateHelper(int x, int y) {

        if (!checkCoordinate(x) || !checkCoordinate(y)) {
            return false;
        }
        return true;
    }

    public static Boolean checkCoordinate (int Coordinate){
        if (Coordinate < MIN_COORDINATE || Coordinate > MAX_COORDINATE){
            return false;
        }
        return true;
    }

}
