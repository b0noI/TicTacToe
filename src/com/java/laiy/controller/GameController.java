package com.java.laiy.controller;

import com.java.laiy.model.Board;
import com.java.laiy.model.Player;
import com.java.laiy.helpers.CoordinateHelper;

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

    public Player getWinner() {
        for ( Player playerForCheck : players) {
            if ( checkLinesForWin(playerForCheck.getFigure().toString()) ||
                 checkRowsForWin(playerForCheck.getFigure().toString()) ||
                 checkDiagsForWin(playerForCheck.getFigure().toString())) {
                return playerForCheck;
            }
        }
        return null;
    }

    public boolean checkLinesForWin(final String playerFigure) {
        for (int row = 0 ; row < board.getFiguresArray().length ; row++) {
            if ( getPlayerForLine(row, playerFigure) == board.getFiguresArray().length) {
                return true;
            }
        }
        return false;
    }

    public boolean checkRowsForWin(final String playerFigure) {
        for (int column = 0 ; column < board.getFiguresArray().length ; column++) {
            if ( getPlayerForColumn(column, playerFigure) == board.getFiguresArray().length) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagsForWin(final String playerFigure) {
        for (int diag_direction = 0 ; diag_direction < DIAGS_FOR_CHECK ; diag_direction++) {
            if ( getPlayerForDiag(diag_direction, playerFigure) == board.getFiguresArray().length) {
                return true;
            }
        }
        return false;
    }

    public int getPlayerForDiag(final int direction, final String playerFigure) {
        int playerDiagCount = 0;
        if ( direction == DIAG_UP ) {
            for (int i = 0; i < board.getFiguresArray().length ; i++) {
                if ((board.getFigure(i, i) != null) && (board.getFigure(i, i).toString() == playerFigure)) {
                        playerDiagCount++;
                    }
            }
        }
        if ( direction == DIAG_DOWN ) {
            for (int i = 0; i < board.getFiguresArray().length ; i++) {
                    if ((board.getFigure((board.getFiguresArray().length - 1) - i, i) != null) && (board.getFigure((board.getFiguresArray().length - 1) - i, i).toString() == playerFigure)) {
                        playerDiagCount++;
                    }
            }
        }
        return playerDiagCount;
    }

    public int getPlayerForColumn(final int column, final String playerFigure) {
        int playerColumnCount = 0;
        for (int i = 0; i < board.getFiguresArray().length ; i++) {
                if ((board.getFigure(i, column) != null) && (board.getFigure(i, column).toString() == playerFigure)) {
                    playerColumnCount++;
                }
        }
        return playerColumnCount;
    }

    public  String getGameName() {
        return gameName;
    }

    public Player getCurrentPlayer(final Player firstPlayer) {
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

    public int[] getPlayersTurns() {
        int[] playersTurns = new int[players.length];
        for ( int playerNum = 0 ; playerNum < players.length ; playerNum++) {
            playersTurns[playerNum] = getPlayerForBoard(players[playerNum].getFigure().toString());
        }
        return playersTurns;
    }

    public int getPlayerForBoard(final String playerFigure) {
        int playerBoardCount = 0;
        for (int i = 0 ; i < board.getFiguresArray().length ; i++) {
            playerBoardCount += getPlayerForLine(i, playerFigure);
        }
        return playerBoardCount;
    }

    public int getPlayerForLine(final int row, final String playerFigure) {
        int playerRowCount = 0;
        for (int i = 0; i < board.getRowLength(row) ; i++) {
                if ((board.getFigure(row, i) != null) && (board.getFigure(row, i).toString() == playerFigure)) {
                    playerRowCount++;
                }
        }
        return playerRowCount;
    }

    public int getFirstPlayerNum(final Player firstPlayer) {
        int firstPlayerPositionNum  = 0;
        for ( int num = 0 ; num < players.length ; num++) {
            if (players[num] == firstPlayer) {
                firstPlayerPositionNum = num;
            }
        }
        return firstPlayerPositionNum;
    }


    public Player[] getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public boolean check(final int x, final int y) {

        assert x >= 0;
        assert y >= 0;

        if (!CoordinateHelper.checkCoordinate(x) || !CoordinateHelper.checkCoordinate(y)) {
            return false;
        }

        return true;
    }

}
