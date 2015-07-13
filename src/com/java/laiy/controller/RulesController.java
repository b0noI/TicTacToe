package com.java.laiy.controller;

import com.java.laiy.model.Figure;

public class RulesController {

    private final GameController gameController;

    public RulesController(final GameController gameController) {
        this.gameController = gameController;
    }

    public boolean setNextTurn(){
        final Figure[][] figures =  gameController.getBoard().getFiguresArray();
        if (gameController.getWinner() != null){
            return false;
        }
        for (Figure[] figureArray : figures) {
            for (Figure figureValue : figureArray) {
                if (figureValue == null) {
                    return true;
                }
            }
        }
        return false;
    }

}
