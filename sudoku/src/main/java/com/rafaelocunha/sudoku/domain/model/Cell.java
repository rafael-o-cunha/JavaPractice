package com.rafaelocunha.sudoku.domain.model;

import com.rafaelocunha.sudoku.domain.exception.FixedCellModificationException;

import java.util.Objects;

public class Cell {

    private final boolean fixed;
    private NumberValue value;

    public Cell(NumberValue value, boolean fixed) {
        this.value = value;
        this.fixed = fixed;
    }

    public boolean isFixed() {
        return fixed;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public NumberValue getValue() {
        return this.value;
    }

    public void setValue(NumberValue value) {
        if(this.fixed) throw new FixedCellModificationException();
        this.value = value;
    }

    public void clear() {
        if(this.fixed) throw new FixedCellModificationException();
        this.value = null;
    }

    public static Cell empty() {
        return new Cell(null, false);
    }

    public static Cell fixed(NumberValue value) {
        return new Cell(value, true);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return fixed == cell.fixed && Objects.equals(value, cell.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fixed, value);
    }
}
