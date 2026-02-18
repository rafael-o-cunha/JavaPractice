package com.rafaelocunha.sudoku.domain.service;

import com.rafaelocunha.sudoku.app.FixedCellInput;
import com.rafaelocunha.sudoku.domain.model.Game;
import com.rafaelocunha.sudoku.domain.model.NumberValue;
import com.rafaelocunha.sudoku.domain.model.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InitialBoardValidator {
    public static void validate(List<FixedCellInput> inputs, Game game) {
        Set<Position> usedPositions = new HashSet<>();

        for (FixedCellInput input : inputs) {
            Position position = new Position(input.row(), input.column());

            if (!usedPositions.add(position)) {
                throw new IllegalArgumentException("Duplicate position: " + input.row() + "," + input.column());
            }

            NumberValue value = new NumberValue(input.value());

            game.getBoard().setFixedCell(position, value);
        }

        if (!game.getBoard().isValid()) {
            throw new IllegalArgumentException("Initial map violates Sudoku rules.");
        }
    }
}
