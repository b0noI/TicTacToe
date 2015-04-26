package com.java.laiy.model;


public enum Figure {

    X("X"), O("O");

    private final String figure;

    private Figure(final String figure){
        assert figure != null;
        this.figure = figure;
    }
}
