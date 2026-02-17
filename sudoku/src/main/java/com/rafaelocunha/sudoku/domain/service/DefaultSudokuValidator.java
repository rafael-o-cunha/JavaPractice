package com.rafaelocunha.sudoku.domain.service;

import com.rafaelocunha.sudoku.domain.model.Board;
import com.rafaelocunha.sudoku.domain.model.Cell;
import com.rafaelocunha.sudoku.domain.model.Position;

import java.util.HashSet;
import java.util.Set;

public class DefaultSudokuValidator implements SudokuValidator {

    private static final int SIZE = 9;

    @Override
    public boolean isMoveValid(Board board, Position position) {
        return rowValid(board, position)
                && columnValid(board, position)
                && blockValid(board, position);
    }

    @Override
    public boolean isBoardValid(Board board) {
        return rowsAreValid(board)
                && columnsAreValid(board)
                && blocksAreValid(board);
    }

    private boolean rowValid(Board board, Position position) {
        Set<Integer> seen = new HashSet<>();
        int row = position.row();

        for (int col = 0; col < SIZE; col++) {
            Cell cell = board.getCell(new Position(row, col));

            if (!cell.isEmpty()) {
                int value = cell.getValue().value();
                if (!seen.add(value)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean columnValid(Board board, Position position) {
        Set<Integer> seen = new HashSet<>();
        int column = position.column();

        for (int row = 0; row < SIZE; row++) {
            Cell cell = board.getCell(new Position(row, column));

            if (!cell.isEmpty()) {
                int value = cell.getValue().value();
                if (!seen.add(value)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean blockValid(Board board, Position position) {
        Set<Integer> seen = new HashSet<>();

        int startRow = (position.row() / 3) * 3;
        int startCol = (position.column() / 3) * 3;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                Cell cell = board.getCell(
                        new Position(startRow + row, startCol + col)
                );

                if (!cell.isEmpty()) {
                    int value = cell.getValue().value();
                    if (!seen.add(value)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean rowsAreValid(Board board) {
        for (int row = 0; row < SIZE; row++) {
            Set<Integer> seen = new HashSet<>();

            for (int col = 0; col < SIZE; col++) {
                Cell cell = board.getCell(new Position(row, col));

                if (!cell.isEmpty()) {
                    int value = cell.getValue().value();
                    if (!seen.add(value)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean columnsAreValid(Board board) {
        for (int col = 0; col < SIZE; col++) {
            Set<Integer> seen = new HashSet<>();

            for (int row = 0; row < SIZE; row++) {
                Cell cell = board.getCell(new Position(row, col));

                if (!cell.isEmpty()) {
                    int value = cell.getValue().value();
                    if (!seen.add(value)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean blocksAreValid(Board board) {
        for (int blockRow = 0; blockRow < SIZE; blockRow += 3) {
            for (int blockCol = 0; blockCol < SIZE; blockCol += 3) {

                Set<Integer> seen = new HashSet<>();

                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {

                        Cell cell = board.getCell(
                                new Position(blockRow + row, blockCol + col)
                        );

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
}
