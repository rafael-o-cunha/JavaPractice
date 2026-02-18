package com.rafaelocunha.sudoku.usecase;

import com.rafaelocunha.sudoku.domain.model.Cell;
import com.rafaelocunha.sudoku.domain.model.Game;
import com.rafaelocunha.sudoku.domain.model.Position;

public class GetBoardStateUseCase {
    private final GameSession session;

    public GetBoardStateUseCase(GameSession session) {
        this.session = session;
    }

    public int[][] execute() {

        Game game = session.getCurrentGame();
        int[][] state = new int[9][9];

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {

                Cell cell = game.getBoard().getCell(new Position(row, column));

                if (!cell.isEmpty()) {
                    state[row][column] = cell.getValue().value();
                }
                else {
                    state[row][column] = 0;
                }
            }
        }

        return state;
    }
}
