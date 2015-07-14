package com.java.laiy;

import com.java.laiy.controller.GameController;
import com.java.laiy.model.Point;
import com.java.laiy.model.exceptions.PointOccupiedException;
import com.java.laiy.view.ConsoleView;

public class Game {

    final private ConsoleView consoleView;
    final private GameController gameController;

    public Game(ConsoleView consoleView, GameController gameController) {
        this.consoleView = consoleView;
        this.gameController = gameController;
    }

    public void theGame(){
        while (gameController.getNextTurn()) {
            Point point = consoleView.startTurn();
            try {
                gameController.move(point.getX(), point.getY(), gameController.getCurrentPlayer(gameController.getPlayers()[0]));
            } catch (PointOccupiedException e) {
                consoleView.showPointOccupied();
            }
            consoleView.showBoard();
        }
        if (gameController.getWinner() != null){
            consoleView.showWinner();
        }
        else {
            consoleView.showDraw();
        }
    }
}
