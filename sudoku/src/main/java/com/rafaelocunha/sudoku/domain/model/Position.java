package com.rafaelocunha.sudoku.domain.model;

import java.util.Objects;

public class Position {

    private final int row;
    private final int column;

    public Position(int row, int column) {
        if(row < 0 || row > 8) throw new IllegalArgumentException("Invalid row number, must be between 0 and 8");
        if(column < 0 || column > 8) throw new IllegalArgumentException("Invalid column number, must be between 0 and 8");
        this.row = row;
        this.column = column;
    }

    public int row() {
        return this.row;
    }

    public int column() {
        return this.column;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && column == position.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
