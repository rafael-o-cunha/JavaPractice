package com.rafaelocunha.sudoku.domain.exception;

public class GameAlreadyStartedException extends SudokuException {

    public GameAlreadyStartedException() {
        super("Game has already started.");
    }

}
