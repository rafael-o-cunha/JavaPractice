package com.rafaelocunha.sudoku.domain.exception;

public class GameNotStartedException extends SudokuException {

    public GameNotStartedException(String message) {
        super("Game has not started yet.");
    }

}
