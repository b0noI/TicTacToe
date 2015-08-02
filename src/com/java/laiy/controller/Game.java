package com.java.laiy.controller;

import com.java.laiy.model.Point;
import com.java.laiy.model.exceptions.PointOccupiedException;
import com.java.laiy.view.IView;

public class Game {

    final private IView iview;
    final private GameController gameController;

    public Game(IView iview) {
        this.iview = iview;
        this.gameController = iview.getGameController();
    }

    public void theGame(){
        while (gameController.getNextTurn()) {
            Point point = iview.startTurn();
            try {
                gameController.move(point.getX(), point.getY(), gameController.getCurrentPlayer(gameController.getPlayers()[0]));
            } catch (PointOccupiedException e) {
                iview.showPointOccupied();
            }
            iview.showBoard();
        }
        if (gameController.getWinner() != null){
            iview.showWinner();
            iview.anotherGame();
        }
        else {
            iview.showDraw();
            iview.anotherGame();
        }
    }

    protected GameController getGameController(){
        return gameController;
    }
}
