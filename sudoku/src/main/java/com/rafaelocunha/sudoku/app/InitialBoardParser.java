package com.rafaelocunha.sudoku.app;

import com.rafaelocunha.sudoku.domain.model.Game;
import com.rafaelocunha.sudoku.domain.model.NumberValue;
import com.rafaelocunha.sudoku.domain.model.Position;

import java.util.ArrayList;
import java.util.List;

public class InitialBoardParser {
    public static List<FixedCellInput> parse(String map) {
        if (map == null || map.isBlank()) return List.of();

        String[] entries = map.split(";");
        List<FixedCellInput> inputs = new ArrayList<>();

        for (String entry : entries) {

            String[] parts = entry.split(",");

            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid map format: " + entry);
            }

            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);
            int value = Integer.parseInt(parts[2]);

            inputs.add(new FixedCellInput(row, col, value));
        }

        return inputs;
    }
}
