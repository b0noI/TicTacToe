package me.ermakov.tictactoe.model;

/**
 * Created by user on 06.02.2015.
 */
public class Figure {

    private final String figure;

    public Figure(String figureName) {
        this.figure = figureName;
    }

    public String getFigure() {
        return figure;
    }

}
