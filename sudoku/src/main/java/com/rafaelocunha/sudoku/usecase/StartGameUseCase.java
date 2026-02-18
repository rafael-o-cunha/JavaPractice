package com.rafaelocunha.sudoku.usecase;

import com.rafaelocunha.sudoku.domain.model.Game;
import com.rafaelocunha.sudoku.domain.service.SudokuValidator;

public class StartGameUseCase {

    private final GameSession session;
    private final SudokuValidator validator;

    public StartGameUseCase(GameSession session, SudokuValidator validator) {
        this.session = session;
        this.validator = validator;
    }

    public void execute() {
        Game game = new Game(validator);
        game.start();
        session.startNewGame(game);
    }
}
