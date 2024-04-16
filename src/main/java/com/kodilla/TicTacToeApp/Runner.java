package com.kodilla.TicTacToeApp;

import java.sql.SQLOutput;

public class Runner {

    private Figure whoseMove = Figure.X;
    boolean withComputer = false;

    public void run() {

        int size = UserDialogs.boardSize();
        GameBoard board = new GameBoard(size);
        if (UserDialogs.playWithAI().equals("C")) {
            withComputer = true;
        }
        System.out.println(board);
        int totalMoves = 0;

        if (withComputer) {
            while (totalMoves < Math.pow(size, 2)) {

                Move move = UserDialogs.getMove(whoseMove, size);
                while (!board.checkMove(move) && totalMoves < Math.pow(size, 2)) {
                    System.out.println("Move not allowed. Try again.");
                    move = UserDialogs.getMove(whoseMove, size);
                }
                board.makeMove(move, whoseMove);
                totalMoves++;
                System.out.println(board);
                board.getWinner();

                Move AIMove = ComputerMove.getAIMove(Figure.O, size);
                while (!board.checkMove(AIMove) && totalMoves < Math.pow(size, 2)) {
                    AIMove = ComputerMove.getAIMove(Figure.O, size);
                }
                board.makeMove(AIMove, Figure.O);
                totalMoves++;
                System.out.println(board);
                board.getWinner();

                if (board.getWinner() == Winner.O || board.getWinner() == Winner.X) {
                    System.out.println("Game over! Winner " + board.getWinner());
                    break;
                }
            }
        } else {
            while (totalMoves < Math.pow(size, 2)) {

                Move move = UserDialogs.getMove(whoseMove, size);
                while (!board.checkMove(move) && totalMoves < Math.pow(size, 2)) {
                    System.out.println("Move not allowed. Try again.");
                    move = UserDialogs.getMove(whoseMove, size);
                }
                if (board.makeMove(move, whoseMove)) {
                    whoseMove = opposite(whoseMove);
                }
                totalMoves++;
                System.out.println(board);
                board.getWinner();
                if (board.getWinner() == Winner.O || board.getWinner() == Winner.X) {
                    System.out.println("Game over! Winner " + board.getWinner());
                    break;
                }
            }
        }

        if (board.getWinner() == Winner.NONE) {
            System.out.println(board.showDraw());
        }
    }

    private Figure opposite(Figure whoseMove) {
        return (whoseMove == Figure.X) ? Figure.O : Figure.X;
    }
}
