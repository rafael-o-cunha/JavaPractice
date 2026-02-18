package com.rafaelocunha.sudoku.usecase;

import com.rafaelocunha.sudoku.domain.exception.GameNotCompleteException;
import com.rafaelocunha.sudoku.domain.exception.SudokuException;
import com.rafaelocunha.sudoku.domain.model.Game;

public class FinishGameUseCase {
    private final GameSession session;

    public FinishGameUseCase(GameSession session) {
        this.session = session;
    }

    public void execute() {

        Game game = session.getCurrentGame();

        if (!game.getBoard().isComplete() || !game.getBoard().isValid()) {
            throw new GameNotCompleteException();
        }

        session.clearSession();
    }
}
