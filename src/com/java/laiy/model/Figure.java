package com.java.laiy.model;


public class Figure {

    private final String figure;

    public Figure(final String figureName){
        figure = figureName;
    }

    public String getFigureContent(){
        return figure;
    }
}
