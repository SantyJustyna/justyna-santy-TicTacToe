package com.kodilla.TicTacToeApp;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("TicTacToeApp Test Suite")
public class TicTacToeAppTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Siute: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Siute: end");
    }

    @DisplayName("Checking O winner in rows.")
    @Test
    void testGetRowWinner0Winner() {
        //Given
        GameBoard board = new GameBoard(3);
        board.setFigure(0, 0, Figure.O);
        board.setFigure(1, 0, Figure.O);
        board.setFigure(2, 0, Figure.O);

        //When
        Winner winner = board.getWinner();

        //Then
        Assertions.assertEquals(Winner.O, winner);
    }

    @DisplayName("Checking O winner in columns.")
    @Test
    void testGetColumnWinnerOWinner() {
        //Given
        GameBoard board = new GameBoard(3);
        board.setFigure(0, 0, Figure.O);
        board.setFigure(0, 1, Figure.O);
        board.setFigure(0, 2, Figure.O);

        //When
        Winner winner = board.getWinner();

        //Then
        Assertions.assertEquals(Winner.O, winner);
    }

    @DisplayName("Checking O winner diagonal left.")
    @Test
    void testLeftDownDiagonalWinnerO() {
        //Given
        GameBoard board = new GameBoard(3);
        board.setFigure(2, 0, Figure.O);
        board.setFigure(1, 1, Figure.O);
        board.setFigure(0, 2, Figure.O);

        //When
        Winner winner = board.getWinner();

        //Then
        Assertions.assertEquals(Winner.O, winner);
    }

    @DisplayName("Checking O winner diagonal right.")
    @Test
    void testRightDownDiagonalWinnerO() {
        //Given
        GameBoard board = new GameBoard(3);
        board.setFigure(0, 0, Figure.O);
        board.setFigure(1, 1, Figure.O);
        board.setFigure(2, 2, Figure.O);

        //When
        Winner winner = board.getWinner();

        //Then
        Assertions.assertEquals(Winner.O, winner);
    }

    @DisplayName("Checking X winner in rows.")
    @Test
    void testGetRowWinnerXWinner() {
        //Given
        GameBoard board = new GameBoard(3);
        board.setFigure(0, 0, Figure.X);
        board.setFigure(1, 0, Figure.X);
        board.setFigure(2, 0, Figure.X);

        //When
        Winner winner = board.getWinner();

        //Then
        Assertions.assertEquals(Winner.X, winner);
    }

    @DisplayName("Checking X winner in columns.")
    @Test
    void testGetColumnWinnerXWinner() {
        //Given
        GameBoard board = new GameBoard(3);
        board.setFigure(0, 0, Figure.X);
        board.setFigure(0, 1, Figure.X);
        board.setFigure(0, 2, Figure.X);

        //When
        Winner winner = board.getWinner();

        //Then
        Assertions.assertEquals(Winner.X, winner);
    }

    @DisplayName("Checking X winner diagonal left.")
    @Test
    void testLeftDownDiagonalWinnerX() {
        //Given
        GameBoard board = new GameBoard(3);
        board.setFigure(2, 0, Figure.X);
        board.setFigure(1, 1, Figure.X);
        board.setFigure(0, 2, Figure.X);

        //When
        Winner winner = board.getWinner();

        //Then
        Assertions.assertEquals(Winner.X, winner);
    }

    @DisplayName("Checking X winner diagonal right.")
    @Test
    void testRightDownDiagonalWinnerX() {
        //Given
        GameBoard board = new GameBoard(3);
        board.setFigure(0, 0, Figure.X);
        board.setFigure(1, 1, Figure.X);
        board.setFigure(2, 2, Figure.X);

        //When
        Winner winner = board.getWinner();

        //Then
        Assertions.assertEquals(Winner.X, winner);
    }

    @DisplayName("Checking draw.")
    @Test
    void testGetWinnerWinnerNone() {
        //Given
        GameBoard board = new GameBoard(3);
        board.setFigure(0, 0, Figure.X);
        board.setFigure(0, 1, Figure.O);
        board.setFigure(0, 2, Figure.O);
        board.setFigure(1, 0, Figure.O);
        board.setFigure(1, 1, Figure.X);
        board.setFigure(1, 2, Figure.X);
        board.setFigure(2, 0, Figure.O);
        board.setFigure(2, 1, Figure.X);
        board.setFigure(2, 2, Figure.O);

        //When
        Winner winner = board.getWinner();

        //Then
        Assertions.assertEquals(Winner.NONE, winner);
    }

    @DisplayName("Exception checking first case.")
    @Test
    void testGetMoveWithException() {
        //Given
        GameBoard board = new GameBoard(3);

        try {
            board.setFigure(1, 3, Figure.O);
        } catch (Exception e) {
            System.out.println("Wrong move. Try again.");
        }

        //When & Then
        assertThrows(Exception.class, () -> board.setFigure(1, 3, Figure.O));

    }

    @DisplayName("Exception checking second case.")
    @Test
    void testGetMoveWithoutException() {
        //Given
        GameBoard board = new GameBoard(3);

        try {
            board.setFigure(1, 1, Figure.O);
        } catch (Exception e) {
            System.out.println("Wrong move. Try again.");
        }

        //When & Then
        assertDoesNotThrow(() -> board.setFigure(1, 1, Figure.O));
    }

} // class end
