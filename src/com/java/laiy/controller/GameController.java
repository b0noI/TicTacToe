package com.java.laiy.controller;

import com.java.laiy.model.Board;
import com.java.laiy.model.Figure;
import com.java.laiy.model.Player;
import com.java.laiy.model.exceptions.InvalidPointException;
import com.java.laiy.model.exceptions.PointOccupiedException;

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

    private final int boardLength;

    public GameController(final String gameName, final Player[] players, final Board board) {
        if (gameName == null || gameName.isEmpty()) {
            this.gameName = GAME_NAME;
        } else {
            this.gameName = gameName;
        }
        this.board = board;
        this.players = players;
        this.boardLength = board.getFiguresArray().length;
    }

    public Player getWinner() {
        for (Player playerForCheck : players) {
            String figureToCheck = playerForCheck.getFigure().toString();
            if (checkRowsForWin(figureToCheck) || checkLinesForWin(figureToCheck) || checkDiagsForWin(figureToCheck)) {
                return playerForCheck;
            }
        }
        return null;
    }

    public String getGameName() {
        return gameName;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public void move(final int x, final int y, final Player player) throws PointOccupiedException {
        try {
            if (board.getFigure(x, y) != null) {
                throw new PointOccupiedException();
            } else {
                try {
                    board.setFigure(x, y, player.getFigure());
                } catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    public boolean getNextTurn() {
        final Figure[][] figures = getBoard().getFiguresArray();
        if (getWinner() != null) {
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

    public Player getCurrentPlayer(final Player firstPlayer) {
        int firstPlayerNum = getFirstPlayerNum(firstPlayer);
        int[] playersTurns = getPlayersTurns();

        if (playersTurns[FIRST_PLAYER] == playersTurns[SECOND_PLAYER]) {
            return players[firstPlayerNum];
        } else if (firstPlayerNum == FIRST_PLAYER) {
            return players[SECOND_PLAYER];
        } else {
            return players[FIRST_PLAYER];
        }
    }

    private boolean checkLinesForWin(final String playerFigure) {
        for (int row = 0; row < boardLength; row++) {
            if (getPlayerForLine(row, playerFigure) == boardLength) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRowsForWin(final String playerFigure) {
        for (int column = 0; column < boardLength; column++) {
            if (getPlayerForColumn(column, playerFigure) == boardLength) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagsForWin(final String playerFigure) {
        for (int diag_direction = 0; diag_direction < DIAGS_FOR_CHECK; diag_direction++) {
            if (getPlayerForDiag(diag_direction, playerFigure) == boardLength) {
                return true;
            }
        }
        return false;
    }

    private int getPlayerForDiag(final int direction, final String playerFigure) {
        int playerDiagCount = 0;
        try {
            if (direction == DIAG_UP) {
                for (int i = 0; i < boardLength; i++) {
                    if ((board.getFigure(i, i) != null) && equalsFigures(i, i, playerFigure)) {
                        playerDiagCount++;
                    }
                }
            }
            if (direction == DIAG_DOWN) {
                for (int i = 0; i < boardLength; i++) {
                    int row = (boardLength - 1) - i;
                    if ((board.getFigure(row, i) != null) && equalsFigures(row, i, playerFigure)) {
                        playerDiagCount++;
                    }
                }
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return playerDiagCount;
    }

    private int getPlayerForColumn(final int column, final String playerFigure) {
        int playerColumnCount = 0;
        for (int i = 0; i < boardLength; i++) {
            try {
                if ((board.getFigure(i, column) != null) && equalsFigures(i, column, playerFigure)) {
                    playerColumnCount++;
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return playerColumnCount;
    }

    private int[] getPlayersTurns() {
        int[] playersTurns = new int[players.length];
        for (int playerNum = 0; playerNum < players.length; playerNum++) {
            playersTurns[playerNum] = getPlayerForBoard(players[playerNum].getFigure().toString());
        }
        return playersTurns;
    }

    private int getPlayerForBoard(final String playerFigure) {
        int playerBoardCount = 0;
        for (int i = 0; i < boardLength; i++) {
            playerBoardCount += getPlayerForLine(i, playerFigure);
        }
        return playerBoardCount;
    }

    private int getPlayerForLine(final int row, final String playerFigure) {
        int playerRowCount = 0;
        for (int i = 0; i < board.getRowLength(row); i++) {
            try {
                if ((board.getFigure(row, i) != null) && equalsFigures(row, i, playerFigure)) {
                    playerRowCount++;
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return playerRowCount;
    }

    private int getFirstPlayerNum(final Player firstPlayer) {
        int firstPlayerPositionNum = 0;
        for (int num = 0; num < players.length; num++) {
            if (players[num] == firstPlayer) {
                firstPlayerPositionNum = num;
            }
        }
        return firstPlayerPositionNum;
    }

    private boolean equalsFigures(final int x, final int y, final String playerFigure) throws InvalidPointException {
        return board.getFigure(x, y).toString().equals(playerFigure);
    }
}
