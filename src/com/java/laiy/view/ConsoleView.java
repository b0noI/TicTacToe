package com.java.laiy.view;


import com.java.laiy.controller.GameController;
import com.java.laiy.model.Player;

public class ConsoleView {

    private static final int BOARD_SIZE = 3;
    private static final int LINE_SIZE = 3;
    private static final String CHARACTER_HYPHEN = "__";

    public final GameController game;

    public ConsoleView(final GameController game) {
        this.game = game;
    }

    public  void showGameName() {
        System.out.println(game.getGameName());
    }

    public void showPlayers() {
         for (Player player : game.getPlayers()) {
             System.out.println(player.getName() + ": " + player.getFigure().getFigureContent() );
         }
    }

    public void showBoard() {
        for (int i = 0 ; i < BOARD_SIZE ; i++) {
            showBoardLine(i);
            printLine(CHARACTER_HYPHEN, LINE_SIZE);
        }
    }

    public void showBoardLine(final int row) {
        for (int i = 0 ; i < BOARD_SIZE ; i++) {
            System.out.print(game.getBoard().getFigure(row, i).getFigureContent());
        }
        System.out.println();
    }

    public static void printLine(final String lineCharacter, final int lineSize) {
        for (int i = 0; i < lineSize; i++) {
            System.out.print(lineCharacter);
        }
        System.out.println();
    }

}
