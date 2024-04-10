package com.kodilla.TicTacToeApp;

import java.util.Random;

public class ComputerMove {

    public static Move compMove(Figure whoseMove, int size){
        Random generator = new Random();
        int col = generator.nextInt(size);
        int row = generator.nextInt(size);
        return new Move(col, row);
    }
}
