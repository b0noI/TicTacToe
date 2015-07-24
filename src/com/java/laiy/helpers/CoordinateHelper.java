package com.java.laiy.helpers;

import com.java.laiy.view.ConsoleMenuView;

public class CoordinateHelper {

    private static final int MIN_COORDINATE = 0;

    public static boolean checkCoordinates(final int x, final int y){
        return (checkCoordinate(x) && checkCoordinate(y));
    }

    public static boolean checkCoordinate(final int coordinate) {
        return (coordinate >= MIN_COORDINATE && coordinate < ConsoleMenuView.getSize());
    }

}