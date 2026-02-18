package com.rafaelocunha.sudoku.app;

public record FixedCellInput(
        int row,
        int column,
        int value
) {}