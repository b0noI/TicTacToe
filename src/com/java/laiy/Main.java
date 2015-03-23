package io.hexlet.java.m101.xo;


import io.hexlet.java.m101.xo.controller.GameController;
import io.hexlet.java.m101.xo.model.Board;
import io.hexlet.java.m101.xo.model.Figure;
import io.hexlet.java.m101.xo.model.Player;
import io.hexlet.java.m101.xo.view.ConsoleView;

public class Main {

    private static final String GAME_NAME="XO";

    public static void main(String[] args) {

        Player[] players = {new Player("MAX",new Figure("X")),new Player("Oleg",new Figure("O"))};
        Board board = new Board();

        GameController gameController = new GameController(GAME_NAME,players,board);

        ConsoleView consoleView = new ConsoleView(gameController);

        Figure figureX = new Figure("X");
        Figure figureO = new Figure("O");

        consoleView.showBoard();
        board.setFigure(1,2,figureX);
        board.setFigure(1,0,figureO);
        board.setFigure(0,2,figureX);
        board.setFigure(1,1,figureO);
        board.setFigure(2,2,figureX);

        consoleView.showBoard();

        consoleView.showCurrentPlayer();

        gameController.winner(board);

    }
}




