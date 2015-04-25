package com.java.laiy.model;


public enum Figure {

    X("X"), O("O");

    private final String figure;

    Figure(final String figureName){
        figure = figureName;
    }

    public String getFigure() {
        return figure;
    }

}
