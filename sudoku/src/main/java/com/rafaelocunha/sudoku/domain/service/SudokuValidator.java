package com.rafaelocunha.sudoku.domain.service;

import com.rafaelocunha.sudoku.domain.model.Board;

public interface SudokuValidator {
    boolean isValid(Board board);
}
