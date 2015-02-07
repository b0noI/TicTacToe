package com.java.laiy.model;


import com.java.laiy.model.Player;

public class Player {

    private final String name;

    private final String figure;

    public Player(final String name, final String figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public String getFigure() {
        return figure;
    }

}
