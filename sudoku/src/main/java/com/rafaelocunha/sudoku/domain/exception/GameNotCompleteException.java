package com.rafaelocunha.sudoku.domain.exception;

public class GameNotCompleteException extends SudokuException {

    public GameNotCompleteException() {
        super("Game is not complete or contains errors.");
    }

}
