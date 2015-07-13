package com.java.laiy.view;

import com.java.laiy.model.exceptions.InvalidPointException;

public interface IView {

    public void startTurn();

    public  void showGameName();

    public void showPlayers();

    public void showBoard() throws InvalidPointException;

}
