package com.rafaelocunha.sudoku.usecase;

import com.rafaelocunha.sudoku.domain.model.Cell;
import com.rafaelocunha.sudoku.domain.model.Game;
import com.rafaelocunha.sudoku.domain.model.Position;

public class ClearUserMovesUseCase {
    private final GameSession session;

    public ClearUserMovesUseCase(GameSession session) {
        this.session = session;
    }

    public void execute() {

        Game game = session.getCurrentGame();

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {

                Position position = new Position(row, column);
                Cell cell = game.getBoard().getCell(position);

                if (!cell.isFixed() && !cell.isEmpty()) {
                    cell.clear();
                }
            }
        }

        game.updateStatus();
    }
}
