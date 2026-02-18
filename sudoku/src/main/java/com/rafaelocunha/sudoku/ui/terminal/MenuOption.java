package com.rafaelocunha.sudoku.ui.terminal;

public record MenuOption(
        int code,
        String description,
        Command command
) {}
