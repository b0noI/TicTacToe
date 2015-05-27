package io.hexlet.java.m101.xo.model;


public enum  Figure {

    X("X"),O("O");

    private final String figure;

    Figure(final String figure) {

        assert figure != null;

        this.figure = figure;
    }


    @Override

    public String toString (){

        return this.figure;
    }



}
