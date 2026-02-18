package com.rafaelocunha.sudoku.usecase;

import com.rafaelocunha.sudoku.domain.model.Game;
import com.rafaelocunha.sudoku.domain.model.NumberValue;
import com.rafaelocunha.sudoku.domain.model.Position;

public class PlaceNumberUseCase {

    private final GameSession session;

    public PlaceNumberUseCase(GameSession session) {
        this.session = session;
    }

    public void execute(int row, int column, int value) {
        Game game = session.getCurrentGame();

        game.getBoard().placeNumber(
                new Position(row, column),
                new NumberValue(value)
        );

        game.updateStatus();
    }

}
