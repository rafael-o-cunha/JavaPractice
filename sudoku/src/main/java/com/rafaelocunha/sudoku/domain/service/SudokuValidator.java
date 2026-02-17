package com.rafaelocunha.sudoku.domain.service;

import com.rafaelocunha.sudoku.domain.model.Board;
import com.rafaelocunha.sudoku.domain.model.Position;

public interface SudokuValidator {
    boolean isMoveValid(Board board, Position position);
    boolean isBoardValid(Board board);
}
