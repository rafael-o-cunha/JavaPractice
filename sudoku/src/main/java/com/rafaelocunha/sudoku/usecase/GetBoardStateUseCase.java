package com.rafaelocunha.sudoku.usecase;

import com.rafaelocunha.sudoku.domain.model.Cell;
import com.rafaelocunha.sudoku.domain.model.Game;
import com.rafaelocunha.sudoku.domain.model.Position;
import com.rafaelocunha.sudoku.usecase.dto.BoardState;
import com.rafaelocunha.sudoku.usecase.dto.CellState;

public class GetBoardStateUseCase {
    private final GameSession session;

    public GetBoardStateUseCase(GameSession session) {
        this.session = session;
    }

    public BoardState execute() {

        Game game = session.getCurrentGame();
        CellState[][] grid = new CellState[9][9];

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {

                Cell cell = game.getBoard().getCell(new Position(row, column));

                Integer value = cell.isEmpty() ? null : cell.getValue().value();

                grid[row][column] = new CellState(value, cell.isFixed());
            }
        }

        return new BoardState(grid);
    }
}
