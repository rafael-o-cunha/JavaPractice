package com.rafaelocunha.sudoku.domain.exception;

public class FixedCellModificationException extends SudokuException {
    public FixedCellModificationException() {
        super("Cannot modify a fixed Cell.");
    }
}
