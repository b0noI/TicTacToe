package com.java.laiy.helpers;

public class CoordinateHelper {

    private static final int MIN_COORDINATE = 0;

    private static final int MAX_COORDINATE = 3;

    private static boolean checkCoordinate(final int coordinate) {
        if (coordinate < MIN_COORDINATE || coordinate > MAX_COORDINATE) {
            return false;
        }
        return true;
    }

}
