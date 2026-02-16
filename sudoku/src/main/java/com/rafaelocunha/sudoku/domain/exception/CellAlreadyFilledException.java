package com.rafaelocunha.sudoku.domain.exception;

public class CellAlreadyFilledException extends SudokuException {

    public CellAlreadyFilledException() {
        super("Cell is already filled.");
    }

}
