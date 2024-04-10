package com.kodilla.TicTacToeApp;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Figure> cols = new ArrayList<>();

    public Row(int size) {
        for(int i = 0; i < size; i++){
            cols.add(Figure.EMPTY);
        }
    }

    public List<Figure> getCols() {
        return cols;
    }
    public String toString(){
        String s = "|";
        for(int n = 0; n < cols.size(); n++){
            s += symbol(cols.get(n)) + "|";
        }
        return s;
    }
    private String symbol(Figure figure){
        if(figure == Figure.X)
            return "X";
        else if (figure == Figure.O)
            return "O";
        else
            return " ";
    }
}
