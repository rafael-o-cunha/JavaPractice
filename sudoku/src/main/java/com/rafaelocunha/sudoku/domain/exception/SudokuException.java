package com.rafaelocunha.sudoku.domain.exception;

/**
 *  RuntimeException, pois tratarei violações de regra de negócio,
 * não erro recuperável técnico.
 */
public abstract class SudokuException extends RuntimeException {

    public SudokuException(String message) {
        super(message);
    }

}
