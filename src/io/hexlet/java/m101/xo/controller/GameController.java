package io.hexlet.java.m101.xo.controller;

import io.hexlet.java.m101.xo.helpers.CoordinateHelper;
import io.hexlet.java.m101.xo.model.Board;
import io.hexlet.java.m101.xo.model.Figure;
import io.hexlet.java.m101.xo.model.Player;

public class GameController {

    public static final int COUNT_OF_PLAYERS=2;
    public static  String GAME_NAME="XO";


    private Player[] players;
    private Board board;

    public GameController(final String gameName, final Player[] players, final Board board) {
        this.players = players;
        this.board = board;

        if (gameName == null || gameName.isEmpty()) {
            GAME_NAME = "XO";
        } else {
            GAME_NAME = gameName;
        }
    }

    public boolean move(final int x, final int y) {

        assert x >= 0;
        assert y >= 0;

        return CoordinateHelper.coordinateHelper(x, y);
    } //not used

    public Board getBoard() {
        return board;
    }

    public String getGameName() {
        return GAME_NAME;
    }

    public Player[] getPlayers() {
        return players;
    }


    public Player winner(final Board board) {

        if (checkMainDiagonal(board) || checkSecondaryDiagonal(board) || checkHorizontal(board) || checkVertical(board)) {
            return winnerPlayer();
        } else {
            return null;
        }
    }

    public Player currentPlayer() {

        int counter = 0;

        for (int i = 0; i < Board.SIZE_FIELD; i += 1) {
            for (int j = 0; j < Board.SIZE_FIELD; j += 1) {

                if (board.getFigure(i, j) != null) {
                    counter += 1;
                }
            }
        }

        if (counter % 2 == 0) {

            return players[0];

        } else {

            return players[1];
        }
    }

    public Figure currentFigure(){
        return currentPlayer().getFigure();
    }

    public Player winnerPlayer() {

       if (currentPlayer().equals(players[0])){
            return players[1];
       }else{
           return players[0];
       }
    }


    private boolean checkMainDiagonal(final Board board) {

        int counter = 0;

        for (int i = 0; i < Board.SIZE_FIELD - 1; i++) {

            if (board.getFigure(i, i) != null && board.getFigure(i, i).equals(board.getFigure(i + 1, i + 1))) {

                counter += 1;
            }

            if (counter == Board.SIZE_FIELD - 1) {

                return true;
            }
        }
        return false;
    }

    private boolean checkSecondaryDiagonal(final Board board) {
        int counter = 0;

        for (int i = Board.SIZE_FIELD - 1; i > 0; i--) {

            if (board.getFigure(i, Board.SIZE_FIELD - 1 - i) != null && board.getFigure(i, Board.SIZE_FIELD - 1 - i).equals(board.getFigure((i - 1), (Board.SIZE_FIELD - i)))) {
                counter += 1;
            }
        }

        return counter == Board.SIZE_FIELD - 1;

    }

    private boolean checkHorizontal(final Board board) {

        int counter = 0;

        for (int i = 0; i < Board.SIZE_FIELD; i++) {

            for (int j = 0; j < Board.SIZE_FIELD - 1; j++) {
//
//                System.out.println("counter : "+counter);
//                System.out.println("Comprising element "+board.getFigure(i,j)+" i:"+i+" j:"+j+"    with "+board.getFigure(i,j+1)+" i:"+i+" j:"+(j+1));

                if (board.getFigure(i, j) != null && board.getFigure(i, j).equals(board.getFigure(i, j + 1))) {

                    counter += 1;

                    if (counter==2)
                        return true;

                } else {

                    counter = 0;
                }

            }
            counter = 0;
        }
        if (counter == Board.SIZE_FIELD - 1) return true;
        else return false;
    }

    private boolean checkVertical(final Board board) {

        int counter = 0;

        for (int i = 0; i < Board.SIZE_FIELD; i++) {

            for (int j = 0; j < Board.SIZE_FIELD - 1; j++) {


                if ((board.getFigure(j, i) != null) && (board.getFigure(j, i).equals(board.getFigure(j + 1, i)))) {

                    counter += 1;

                    if (counter==Board.SIZE_FIELD - 1){
                        return true;
                    }

                } else {

                    counter = 0;
                }

            }
            counter=0;
        }
        return counter == Board.SIZE_FIELD - 1; //always false
    }


}



