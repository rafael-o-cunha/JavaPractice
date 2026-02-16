package com.rafaelocunha.sudoku.domain;

import com.rafaelocunha.sudoku.domain.exception.SudokuException;

public class InvalidMoveException extends SudokuException {

    public InvalidMoveException() {
        super("Invalid move: Violates Sudoku rules.");
    }
}
