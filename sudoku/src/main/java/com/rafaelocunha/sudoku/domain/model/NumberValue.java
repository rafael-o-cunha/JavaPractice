package com.rafaelocunha.sudoku.domain.model;

import java.util.Objects;

public class NumberValue {

    private final int value;

    public NumberValue(int value) {
        if(value < 1 || value > 9) throw new IllegalArgumentException("Invalid number, must be between 1 and 9");
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NumberValue that = (NumberValue) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
