package com.kodilla.TicTacToeApp;

import java.util.Random;
import java.util.Scanner;

public class ComputerMove {

    public static Move getAIMove(Figure figure, int size) {
        Random generator = new Random();
        figure = Figure.O;
        int col = generator.nextInt(size);
        int row = generator.nextInt(size);

        return new Move(col, row);
    }
}
