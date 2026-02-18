package com.rafaelocunha.sudoku.domain.model;

import com.rafaelocunha.sudoku.domain.InvalidMoveException;
import com.rafaelocunha.sudoku.domain.exception.CellAlreadyFilledException;
import com.rafaelocunha.sudoku.domain.service.SudokuValidator;

import java.util.Arrays;
import java.util.Objects;

public class Board {

    private static final int SIZE = 9;

    private final Cell[][] grid;
    private final SudokuValidator validator;

    public Board(SudokuValidator validator) {
        this.validator = validator;
        this.grid = new Cell[SIZE][SIZE];
        initializeEmptyBoard();
    }

    private void initializeEmptyBoard() {
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                grid[row][col] = Cell.empty();
            }
        }
    }

    public void placeNumber(Position position, NumberValue value) {

        Cell cell = getCell(position);

        if (!cell.isEmpty()) {
            throw new CellAlreadyFilledException();
        }

        cell.setValue(value);

        if (!validator.isMoveValid(this, position)) {
            cell.clear();
            throw new InvalidMoveException();
        }
    }

    public boolean isComplete() {
        for(int row = 0; row < SIZE; row++) {
            for(int column = 0; column < SIZE; column++) {
                if(grid[row][column].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasErrors() {
        return !validator.isBoardValid(this);
    }

    public GameStatus getStatus() {
        if(isComplete() && !hasErrors()) {
            return GameStatus.COMPLETE;
        }
        return GameStatus.INCOMPLETE;
    }

    public Cell getCell(Position position) {
        return grid[position.row()][position.column()];
    }

    public boolean isValid() {
        return validator.isBoardValid(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.deepEquals(grid, board.grid) && Objects.equals(validator, board.validator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.deepHashCode(grid), validator);
    }

    public void setFixedCell(Position position, NumberValue value) {
        grid[position.row()][position.column()] = Cell.fixed(value);
    }
}
