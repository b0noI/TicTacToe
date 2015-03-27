package io.hexlet.java.m101.xo.model;


public class Figure {

    private final String figure;

    public Figure(final String figure) {

        assert figure != null;

        this.figure = figure;
    }


    @Override

    public String toString (){

        return this.figure;
    }



}
