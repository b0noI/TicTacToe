package com.java.laiy.model;


public class Figure {

    private final String figure;

    public Figure(final String figureName){
        assert figureName != null;
        figure = figureName;
    }

    public String getFigure(){
        return figure;
    }
}
