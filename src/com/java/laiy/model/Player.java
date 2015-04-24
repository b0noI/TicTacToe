package com.java.laiy.model;


import com.java.laiy.model.Player;
import com.java.laiy.model.Figure;

public class Player {

    private final String name;

    private final Figure figure;

    public Player(final String name, final Figure figure) {
        assert name != null;
        assert figure != null;

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
