package com.rafaelocunha.sudoku.usecase;

import com.rafaelocunha.sudoku.app.FixedCellInput;
import com.rafaelocunha.sudoku.app.InitialBoardParser;
import com.rafaelocunha.sudoku.domain.model.Game;
import com.rafaelocunha.sudoku.domain.service.InitialBoardValidator;
import com.rafaelocunha.sudoku.domain.service.SudokuValidator;

import java.util.List;

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

    public void execute(String map) {

        Game game = new Game(validator);

        List<FixedCellInput> inputs = InitialBoardParser.parse(map);

        InitialBoardValidator.validate(inputs, game);

        game.start();
        session.startNewGame(game);
    }
}
