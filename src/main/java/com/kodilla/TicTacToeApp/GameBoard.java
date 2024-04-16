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

    public boolean checkMove(Move move) {
        if (getFigure(move.getCol(), move.getRow()) != Figure.EMPTY) {
            return false;
        } else {
            return true;
        }
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

        int x = col;
        int y = row;
        int length = (rows.size() <= 5) ? rows.size() : 5;
        List<Figure> diagX = new ArrayList<>();
        List<Figure> diagO = new ArrayList<>();

        while ((isLeft && (x >= col - length) || (!isLeft && (x <= col + length))) && y <= row + length) {

            if (x < 0 || y > rows.size() - 1 || x > rows.size() - 1) {
            } else if (getFigure(x, y) == Figure.X) {
                diagX.add(Figure.X);
            } else if (getFigure(x, y) == Figure.O) {
                diagO.add(Figure.O);
            }
            if (isLeft) {
                x--;
            } else {
                x++;
            }
            y++;
        }
        if (diagX.size() == length)
            return Winner.X;
        else if (diagO.size() == length)
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
        int length = (rows.size() <= 5) ? rows.size() : 5;
        List<Figure> rowX = new ArrayList<>();
        List<Figure> rowO = new ArrayList<>();

        for (int col = 0; col < rows.size(); col++) {
            Figure figure = getFigure(col, row);

            if (figure == Figure.X)
                rowX.add(Figure.X);
            if (figure == Figure.O)
                rowO.add(Figure.O);

            if (rowX.size() == length || rowO.size() == length) {
                break;
            }
        }

        if (rowX.size() == length) {
            return Winner.X;
        }
        if (rowO.size() == length) {
            return Winner.O;
        }
        return Winner.NONE;
    }

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
        int length = (rows.size() <= 5) ? rows.size() : 5;
        List<Figure> columnX = new ArrayList<>();
        List<Figure> columnO = new ArrayList<>();

        for (int row = 0; row < rows.size(); row++) {
            Figure figure = getFigure(col, row);

            if (figure == Figure.X)
                columnX.add(Figure.X);
            if (figure == Figure.O)
                columnO.add(Figure.O);

            if (columnX.size() == length || columnO.size() == length) {
                break;
            }

        }

        if (columnX.size() == length) {
            return Winner.X;
        }
        if (columnO.size() == length) {
            return Winner.O;
        }
        return Winner.NONE;
    }

    public String showDraw() {
        return "Game over! It's a draw!!";
    }
}


