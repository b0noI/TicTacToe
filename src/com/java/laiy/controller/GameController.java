package com.java.laiy.controller;

import com.java.laiy.model.Board;
import com.java.laiy.model.Player;
import com.java.laiy.helpers.CoordinateHelper;
import com.java.laiy.model.exceptions.InvalidPointException;

public class GameController {

    private static final String GAME_NAME = "XO";

    private static final int FIRST_PLAYER = 0;

    private static final int SECOND_PLAYER = 1;

    private static final int DIAG_UP = 1;

    private static final int DIAG_DOWN = 0;

    private static final int DIAGS_FOR_CHECK = 2;

    private final String gameName;

    private final Player[] players;

    private final Board board;

    public GameController(final String gameName, final Player[] players, final Board board) {
        if (gameName == null || gameName.isEmpty()) {
            this.gameName = GAME_NAME;
        } else {
            this.gameName = gameName;
        }
        this.board = board;
        this.players = players;
    }

    public Player getWinner() throws InvalidPointException {
        for ( Player playerForCheck : players) {
            if (checkRowsForWin(playerForCheck.getFigure().toString())) {
                return playerForCheck;
            } else {
                if (checkLinesForWin(playerForCheck.getFigure().toString()) || checkDiagsForWin(playerForCheck.getFigure().toString())) {
                    return playerForCheck;
                }
            }
        }
        return null;
    }

    public  String getGameName() {
        return gameName;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public boolean move(final int x, final int y) {

        assert x >= 0;
        assert y >= 0;

        if (!CoordinateHelper.checkCoordinate(x) || !CoordinateHelper.checkCoordinate(y)) {
            return false;
        }

        return true;
    }

    public Player getCurrentPlayer(final Player firstPlayer) throws InvalidPointException {
        int firstPlayerNum = getFirstPlayerNum(firstPlayer);
        int[] playersTurns = getPlayersTurns();

        if (playersTurns[FIRST_PLAYER] == playersTurns[SECOND_PLAYER]) {
            return players[firstPlayerNum];
        }
        else {
            if ( firstPlayerNum  == FIRST_PLAYER ) {
                return players[SECOND_PLAYER];
            }
            else {
                return players[FIRST_PLAYER];
            }
        }
    }

    private boolean checkLinesForWin(final String playerFigure) throws InvalidPointException {
        for (int row = 0 ; row < board.getFiguresArray().length ; row++) {
            if ( getPlayerForLine(row, playerFigure) == board.getFiguresArray().length) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRowsForWin(final String playerFigure) throws InvalidPointException {
        for (int column = 0 ; column < board.getFiguresArray().length ; column++) {
            if ( getPlayerForColumn(column, playerFigure) == board.getFiguresArray().length) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagsForWin(final String playerFigure) throws InvalidPointException {
        for (int diag_direction = 0 ; diag_direction < DIAGS_FOR_CHECK ; diag_direction++) {
            if ( getPlayerForDiag(diag_direction, playerFigure) == board.getFiguresArray().length) {
                return true;
            }
        }
        return false;
    }

    private int getPlayerForDiag(final int direction, final String playerFigure) throws InvalidPointException {
        int playerDiagCount = 0;
        if ( direction == DIAG_UP ) {
            for (int i = 0; i < board.getFiguresArray().length ; i++) {
                if ((board.getFigure(i, i) != null) && (board.getFigure(i, i).toString().equals(playerFigure) )) {
                        playerDiagCount++;
                    }
            }
        }
        if ( direction == DIAG_DOWN ) {
            for (int i = 0; i < board.getFiguresArray().length ; i++) {
                    if ((board.getFigure((board.getFiguresArray().length - 1) - i, i) != null) && (board.getFigure((board.getFiguresArray().length - 1) - i, i).toString().equals(playerFigure))) {
                        playerDiagCount++;
                    }
            }
        }
        return playerDiagCount;
    }

    private int getPlayerForColumn(final int column, final String playerFigure) throws InvalidPointException {
        int playerColumnCount = 0;
        for (int i = 0; i < board.getFiguresArray().length ; i++) {
                if ((board.getFigure(i, column) != null) && (board.getFigure(i, column).toString().equals(playerFigure))) {
                    playerColumnCount++;
                }
        }
        return playerColumnCount;
    }

    private int[] getPlayersTurns() throws InvalidPointException {
        int[] playersTurns = new int[players.length];
        for ( int playerNum = 0 ; playerNum < players.length ; playerNum++) {
            playersTurns[playerNum] = getPlayerForBoard(players[playerNum].getFigure().toString());
        }
        return playersTurns;
    }

    private int getPlayerForBoard(final String playerFigure) throws InvalidPointException {
        int playerBoardCount = 0;
        for (int i = 0 ; i < board.getFiguresArray().length ; i++) {
            playerBoardCount += getPlayerForLine(i, playerFigure);
        }
        return playerBoardCount;
    }

    private int getPlayerForLine(final int row, final String playerFigure) throws InvalidPointException {
        int playerRowCount = 0;
        for (int i = 0; i < board.getRowLength(row) ; i++) {
                if ((board.getFigure(row, i) != null) && (board.getFigure(row, i).toString().equals(playerFigure))) {
                    playerRowCount++;
                }
        }
        return playerRowCount;
    }

    private int getFirstPlayerNum(final Player firstPlayer) {
        int firstPlayerPositionNum  = 0;
        for ( int num = 0 ; num < players.length ; num++) {
            if (players[num] == firstPlayer) {
                firstPlayerPositionNum = num;
            }
        }
        return firstPlayerPositionNum;
    }

}
