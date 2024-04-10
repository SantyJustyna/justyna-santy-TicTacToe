package com.kodilla.TicTacToeApp;

import java.util.Random;
import java.util.Scanner;

public class UserDialogs {
    public static Move getMove(Figure whoseMove, int size) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Make a move for " + whoseMove + "( (e.g. 2,2):");
            String s = scanner.nextLine();
            try{
                String[] coords = s.split(",");
                int col = Integer.parseInt(coords[0]);
                int row = Integer.parseInt(coords[1]);
                if(col >= 0 && col < size && row >= 0 && row < size){
                    return new Move(col, row);
                }
                System.out.println("Col and row values must be between 0 and " + (size - 1));
            }catch(Exception e){
                System.out.println("Wrong move. Try again.");
            }

        }
    }
    public static String playWithAI(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To play with computer hit (C), to play with another player hit (P)");
        String choice = scanner.nextLine();
            if(choice == "C" || choice == "c") {
                return "C";
            }else if(choice == "P" || choice == "p"){
                return "P";
            }else
                return "Wrong choice. Try again please";


    }
    public static int boardSize(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Chose the size of board please (3-10)");
            int size = scanner.nextInt();
            try{
                if(size >= 3 && size <= 10){
                    return size;
                }
                System.out.println("Wrong choice. Size must be between 3 and 10. Try again please.");
            }catch (Exception e){
                System.out.println("Wrong choice. Size must be between 3 and 10. Try again please.");
            }
        }
    }
}