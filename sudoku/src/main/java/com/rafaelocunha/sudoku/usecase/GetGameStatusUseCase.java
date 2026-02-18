package com.rafaelocunha.sudoku.usecase;

import com.rafaelocunha.sudoku.domain.model.GameStatus;

public class GetGameStatusUseCase {
    private final GameSession session;

    public GetGameStatusUseCase(GameSession session) {
        this.session = session;
    }

    public GameStatus execute() {
        return session.getCurrentGame().getGameStatus();
    }
}
