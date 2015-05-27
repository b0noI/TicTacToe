package io.hexlet.java.m101.xo.tests;

import io.hexlet.java.m101.xo.controller.GameController;
import io.hexlet.java.m101.xo.model.Board;
import io.hexlet.java.m101.xo.model.Figure;
import io.hexlet.java.m101.xo.view.ConsoleView;

public class TestWinner {

    //NEED MORE AUTOMATICS

    private Board board;
    private GameController gameController;
    private ConsoleView consoleView;

    public TestWinner(final Board board,final GameController gameController, final ConsoleView consoleView) {
        this.board = board;
        this.gameController = gameController;
        this.consoleView = consoleView;
    }

    public void testCheckMainDiagonalX() {

        System.out.println(gameController.winner(board));
        board.setFigure(0, 0, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 2, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 1, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(0, 2, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(2, 2, Figure.X);


        System.out.println(gameController.winner(board));
        consoleView.showBoard();
        System.out.println("Correct output - 1st player");
    } // ok

    public void testCheckMainDiagonalO() {

        System.out.println(gameController.winner(board));
        board.setFigure(1, 2, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 1, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(0, 1, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(0, 0, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(0, 2, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(2, 2, Figure.O);


        System.out.println(gameController.winner(board));
        consoleView.showBoard();
        System.out.println("Correct output - 2nd player");
    } // ok

    public void testCheckSecondaryDiagonalX() {

        System.out.println(gameController.winner(board));
        board.setFigure(0, 2, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 2, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 1, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(0, 1, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(2, 0, Figure.X);


        System.out.println(gameController.winner(board));
        consoleView.showBoard();
        System.out.println("Correct output - 1st player");

    } // ok

    public void testCheckSecondaryDiagonalO() {

        System.out.println(gameController.winner(board));
        board.setFigure(0, 0, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 1, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(2, 1, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(0, 2, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(2, 2, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(2, 0, Figure.O);

        System.out.println(gameController.winner(board));
        consoleView.showBoard();
        System.out.println("Correct output - 2nd player");

    } //ok

    public void testCheckHorizontalX_1 () {

        System.out.println(gameController.winner(board));
        board.setFigure(0, 0, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 1, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(0, 1, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 2, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(0, 2, Figure.X);


        System.out.println(gameController.winner(board));
        consoleView.showBoard();
        System.out.println("Correct output - 1st player");

    } // ok
    public void testCheckHorizontalX_2 () {

        System.out.println(gameController.winner(board));
        board.setFigure(1, 0, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(0, 1, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 1, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(2, 2, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 2, Figure.X);


        System.out.println(gameController.winner(board));
        consoleView.showBoard();
        System.out.println("Correct output - 1st player");

    } // ok
    public void testCheckHorizontalX_3 () {

        System.out.println(gameController.winner(board));
        board.setFigure(2, 0, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 1, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(2, 1, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 2, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(2, 2, Figure.X);


        System.out.println(gameController.winner(board));
        consoleView.showBoard();
        System.out.println("Correct output - 1st player");

    } //ok

    public void testCheckHorizontalO_2 () {


        System.out.println(gameController.winner(board));
        board.setFigure(0, 2, Figure.X);


        System.out.println(gameController.winner(board));
        board.setFigure(1, 0, Figure.O);


        System.out.println(gameController.winner(board));
        board.setFigure(2, 2, Figure.X);


        System.out.println(gameController.winner(board));
        board.setFigure(1, 1, Figure.O);


        System.out.println(gameController.winner(board));
        board.setFigure(2, 0, Figure.X);


        System.out.println(gameController.winner(board));
        board.setFigure(1, 2, Figure.O);


        System.out.println(gameController.winner(board));
        consoleView.showBoard();
        System.out.println("Correct output - 2nd player");

    } // ok

    public void testCheckVerticalX_1() {

        System.out.println(gameController.winner(board));
        board.setFigure(2, 2, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 1, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(0, 2, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 0, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 2, Figure.X);


        System.out.println(gameController.winner(board));
        consoleView.showBoard();
        System.out.println("Correct output - 1st player");

    } // ok
    public void testCheckVerticalX_2() {

        System.out.println(gameController.winner(board));
        board.setFigure(1, 1, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(0, 0, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(0, 1, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(0, 2, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(2, 1, Figure.X);


        System.out.println(gameController.winner(board));
        consoleView.showBoard();
        System.out.println("Correct output - 1st player");

    } // ok
    public void testCheckVerticalX_3() {

        System.out.println(gameController.winner(board));
        board.setFigure(0, 0, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 1, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 0, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(2, 2, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(2, 0, Figure.X);


        System.out.println(gameController.winner(board));
        consoleView.showBoard();
        System.out.println("Correct output - 1st player");

    } // ok

    public void testCheckVerticalO_1() {

    System.out.println(gameController.winner(board));
    board.setFigure(2, 2, Figure.X);

    System.out.println(gameController.winner(board));
    board.setFigure(0, 0, Figure.O);

    System.out.println(gameController.winner(board));
    board.setFigure(2, 1, Figure.X);

    System.out.println(gameController.winner(board));
    board.setFigure(1, 0, Figure.O);

    System.out.println(gameController.winner(board));
    board.setFigure(0, 2, Figure.X);

    System.out.println(gameController.winner(board));
    board.setFigure(2, 0, Figure.O);

    System.out.println(gameController.winner(board));
    consoleView.showBoard();
    System.out.println("Correct output - 2nd player");

} // ok
    public void testCheckVerticalO_2() {

        System.out.println(gameController.winner(board));
        board.setFigure(2, 2, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(0, 1, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(0, 0, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 1, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(0, 2, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(2, 1, Figure.O);

        System.out.println(gameController.winner(board));
        consoleView.showBoard();
        System.out.println("Correct output - 2nd player");

    } // ok
    public void testCheckVerticalO_3() {

        System.out.println(gameController.winner(board));

        board.setFigure(1, 0, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(0, 2, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(2, 1, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 2, Figure.O);

        System.out.println(gameController.winner(board));
        board.setFigure(1, 1, Figure.X);

        System.out.println(gameController.winner(board));
        board.setFigure(2, 2, Figure.O);

        System.out.println(gameController.winner(board));
        consoleView.showBoard();
        System.out.println("Correct output - 2nd player");

    } // ok



}
