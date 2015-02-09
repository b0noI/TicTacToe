package me.ermakov.tictactoe.model;

/**
 * Created by user on 06.02.2015.
 */
public class Player {

    private final Figure figure;
    private final String name;

    public Player(final String name, final Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public Figure getFigure() {
        return figure;
    }

}
