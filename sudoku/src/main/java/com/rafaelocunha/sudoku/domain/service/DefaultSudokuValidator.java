package com.rafaelocunha.sudoku.domain.service;

import com.rafaelocunha.sudoku.domain.model.Board;
import com.rafaelocunha.sudoku.domain.model.Cell;
import com.rafaelocunha.sudoku.domain.model.Position;

import java.util.HashSet;
import java.util.Set;

public class DefaultSudokuValidator implements SudokuValidator {

    private static final int SIZE = 9;

    public boolean isValid(Board board) {
        return rowsAreValid(board) && columnsAreValid(board) && blocksAreValid(board);
    }

    private boolean blocksAreValid(Board board) {
        for (int blockRow = 0; blockRow < SIZE; blockRow += 3) {
            for (int blockCol = 0; blockCol < SIZE; blockCol += 3) {
                Set<Integer> seen = new HashSet<>();

                for (int row = 0; row < 3; row++) {
                    for (int column = 0; column < 3; column++) {
                        Cell cell = board.getCell(new Position(blockRow + row, blockCol + column));

                        if (!cell.isEmpty()) {
                            int value = cell.getValue().value();

                            if (!seen.add(value)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean columnsAreValid(Board board) {
        for(int column = 0; column < SIZE; column++) {
            Set<Integer> seen = new HashSet<>();

            for(int row = 0; row < SIZE; row++) {
                Cell cell = board.getCell(new Position(row, column));

                if(!cell.isEmpty()) {
                    int value = cell.getValue().value();
                    if(!seen.add(value)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean rowsAreValid(Board board) {
        for(int row = 0; row < SIZE; row++) {
            Set<Integer> seen = new HashSet<>();

            for(int column = 0; column < SIZE; column++) {
                Cell cell = board.getCell(new Position(row, column));

                if(!cell.isEmpty()) {
                    int value = cell.getValue().value();
                    if(!seen.add(value)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
