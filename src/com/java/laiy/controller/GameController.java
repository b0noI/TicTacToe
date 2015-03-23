package io.hexlet.java.m101.xo.controller;

import io.hexlet.java.m101.xo.helpers.CoordinateHelper;
import io.hexlet.java.m101.xo.model.Board;
import io.hexlet.java.m101.xo.model.Player;

public class GameController {

    private String gameName;
    private Player[] players;
    private Board board;

    public GameController(final String gameName, final Player[] players, final Board board) {
        this.players = players;
        this.board = board;

        if (gameName == null || gameName == "") {
            this.gameName = "XO";
        } else {
            this.gameName = gameName;
        }
    }

    public boolean move(final int x, final int y) {

        assert x >= 0;
        assert y >= 0;

        return CoordinateHelper.coordinateHelper(x, y);
    }

    public Board getBoard() {
        return board;
    }

    public String getGameName() {
        return gameName;
    }

    public Player[] getPlayers() {
        return players;
    }


    public Player winner(Board board) {

       if (checkMainDiagonal(board) || checkSecondaryDiagonal(board) || checkHorizontal(board) || checkVertical(board)){
        return currentPlayer();
       }
       return null;
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


    private boolean checkMainDiagonal (Board board){

        int counter = 0;

        for (int i = 0; i < Board.SIZE_FIELD-1; i++) {

            if ( board.getFigure(i,i) != null && board.getFigure(i,i).equals(board.getFigure(i + 1,i + 1))) {

                counter += 1;
            }

            if (counter == board.SIZE_FIELD-1) {

                return true;
            }
        }
        return false;
    }

    private boolean checkSecondaryDiagonal(Board board) {
        int counter = 0;

        for (int i = Board.SIZE_FIELD-1; i >0; i--) {

            if (board.getFigure(i,Board.SIZE_FIELD-1-i) != null && board.getFigure(i,Board.SIZE_FIELD-1-i).equals(board.getFigure((i - 1), (Board.SIZE_FIELD - i)))) {
                counter += 1;
            }
        }

        if (counter == Board.SIZE_FIELD-1) {

            return true;
        }

        return false;
    }

    private boolean checkHorizontal (Board board){

        int counter = 0;

        for (int i = 0; i<Board.SIZE_FIELD;i++){

            for (int j = 0; j<Board.SIZE_FIELD-1;j++){


            if (board.getFigure(i,j) != null && board.getFigure(i,j).equals(board.getFigure(i,j+1))){

                    counter+=1;

                } else {

                    counter=0;
                }

            }
        }
        if (counter == Board.SIZE_FIELD-1){

           return true;
        }
        return false;
    }

    private boolean checkVertical (Board board){

        int counter = 0;

        for (int j = 0; j<Board.SIZE_FIELD;j++){

            for (int i = 0; i<Board.SIZE_FIELD-1;i++){


                if (board.getFigure(i,j) != null && board.getFigure(i,j).equals(board.getFigure(i+1,j))){

                    counter+=1;

                } else {

                    counter=0;
                }

            }
        }
        if (counter == Board.SIZE_FIELD-1){

            return true;
        }
        return false;
    }


}



