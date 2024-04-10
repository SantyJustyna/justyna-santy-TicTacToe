package com.kodilla.TicTacToeApp;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private List<Row> rows = new ArrayList<>();

    public GameBoard(int size) {
        for (int n = 0; n < size; n++) {
            rows.add(new Row(size));
        }
    }

    public Figure getFigure(int col, int row) {
        return rows.get(row).getCols().get(col);
    }

    public void setFigure(int col, int row, Figure figure) {
        rows.get(row).getCols().set(col, figure);
    }

    public String toString() {
        String s = "";
        for (int n = 0; n < rows.size(); n++) {
            s += rows.get(n) + "\n";
        }
        return s;
    }

    public boolean makeMove(Move move, Figure figure) {
        if (getFigure(move.getCol(), move.getRow()) != Figure.EMPTY) {
            return false;
        }
        setFigure(move.getCol(), move.getRow(), figure);
        return true;
    }

    public Winner getWinner() {
        Winner winner = Winner.NONE;
        winner = (winner != Winner.NONE) ? winner : getColumnWinner();
        winner = (winner != Winner.NONE) ? winner : getRowWinner();
        winner = (winner != Winner.NONE) ? winner : getDiagonalWinner();

        return winner;
    }
    private Winner getDiagonalWinner() {
        Winner winner = Winner.NONE;
        for (int row = 0; row < rows.size(); row++) {
            for (int col = 0; col < rows.size(); col++) {
                if (winner == Winner.NONE) {
                    winner = getDiagonalWinnerFrom(col, row);
                }
            }
        }
        return winner;
    }

    private Winner getDiagonalWinnerFrom(int col, int row) {
        Winner winner = leftOrRightDownDiagonalWinner(col, row, true);
        if (winner == Winner.NONE)
            winner = leftOrRightDownDiagonalWinner(col, row, false);
        return winner;
    }

    private Winner leftOrRightDownDiagonalWinner(int col, int row, boolean isLeft) {
        boolean isXWinner = true;
        boolean isOWinner = true;
        int x = col;
        int y = row;
        int length = (rows.size() <= 5) ? rows.size() : 5;
        while ((isLeft && (x >= col - length) || (!isLeft && (x <= col + length))) && y <= row + length) {
            if (x < 0 || y > rows.size() - 1 || x > rows.size() - 1) {
                isOWinner = false;
                isXWinner = false;
            } else if (getFigure(x, y) != Figure.X) {
                isXWinner = false;
            } else if (getFigure(x, y) != Figure.O) {
                isOWinner = false;
            }
            if (isLeft) {
                x--;
            } else {
                x++;
            }
            y++;
        }
        if (isXWinner)
            return Winner.X;
        else if (isOWinner)
            return Winner.O;
        else
            return Winner.NONE;
    }


    private Winner getRowWinner() {
        Winner winner = Winner.NONE;
        for (int row = 0; row < rows.size(); row++) {
            if (winner == Winner.NONE) {
                winner = getOneRowWinner(row);
            }
        }
        return winner;
    }

    private Winner getOneRowWinner(int row) {
        boolean isXWinner = true;
        boolean isOWinner = true;
        for (int col = 0; col < rows.size(); col++) {
            Figure figure = getFigure(col, row);
            if (figure != Figure.X)
                isXWinner = false;
            if (figure != Figure.O)
                isOWinner = false;
        }
        if (isXWinner)
            return Winner.X;
        if (isOWinner)
            return Winner.O;
        return Winner.NONE;    }

    private Winner getColumnWinner() {
        Winner winner = Winner.NONE;
        for (int col = 0; col < rows.size(); col++) {
            if (winner == Winner.NONE) {
                winner = getOneColumnWinner(col);
            }
        }
        return winner;
    }

    private Winner getOneColumnWinner(int col) {
        boolean isXWinner = true;
        boolean isOWinner = true;
        for (int row = 0; row < rows.size(); row++) {
            Figure figure = getFigure(col, row);
            if (figure != Figure.X)
                isXWinner = false;
            if (figure != Figure.O)
                isOWinner = false;
        }
        if (isXWinner)
            return Winner.X;
        if (isOWinner)
            return Winner.O;
        return Winner.NONE;
    }
    public String showDraw(){

        return "Game over! It's a draw!!";
    }
}


