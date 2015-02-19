package com.java.laiy.model;


public class Board {

    public Figure figure11 = new Figure("?");

    public Figure figure12 = new Figure("?");

    public Figure figure13 = new Figure("?");

    public Figure figure21 = new Figure("?");

    public Figure figure22 = new Figure("?");

    public Figure figure23 = new Figure("?");

    public Figure figure31 = new Figure("?");

    public Figure figure32 = new Figure("?");

    public Figure figure33 = new Figure("?");

    public String setBoard() {
        String line1 = figure11.getFigure() + " " + figure12.getFigure() + " " + figure13.getFigure();
        return line1;
    }

    /*letter*/

}
