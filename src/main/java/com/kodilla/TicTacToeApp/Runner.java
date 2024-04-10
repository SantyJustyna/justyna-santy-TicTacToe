package com.kodilla.TicTacToeApp;

import java.sql.SQLOutput;

public class Runner {

    private Figure whoseMove = Figure.X;
    public void run(){

        int totalMoves = 0;
        int size = UserDialogs.boardSize();
        GameBoard board = new GameBoard(size);
        System.out.println(board);


            while (true) {
                Move move = UserDialogs.getMove(whoseMove, size);
                if (board.makeMove(move, whoseMove)) {
                    whoseMove = opposite(whoseMove);
                }
                totalMoves++;
                System.out.println(board);
                Winner gameOver = board.getWinner();
                if (gameOver == Winner.O || gameOver == Winner.X) {
                    System.out.println("Game over! Winner " + gameOver);
                    break;
                }
                if (totalMoves == size * size && gameOver == Winner.NONE) {
                    System.out.println(board.showDraw());
                    break;
                }
            }

    }
    private Figure opposite(Figure whoseMove){
       return (whoseMove == Figure.X) ? Figure.O : Figure.X;
    }
}
