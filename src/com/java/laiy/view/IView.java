package com.java.laiy.view;

import com.java.laiy.controller.GameController;
import com.java.laiy.model.Point;
import com.java.laiy.model.exceptions.InvalidPointException;

public interface IView {

    public Point startTurn();

    public void showGameName();

    public void showPlayers();

    public void showBoard();

    public void showWinner();

    public void showDraw();

    public void anotherGame();

    public void showPointOccupied();

    public GameController getGameController();

}
