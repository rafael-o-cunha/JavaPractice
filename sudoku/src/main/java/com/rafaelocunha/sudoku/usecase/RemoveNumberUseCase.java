package com.rafaelocunha.sudoku.usecase;

import com.rafaelocunha.sudoku.domain.exception.GameNotStartedException;
import com.rafaelocunha.sudoku.domain.model.Game;
import com.rafaelocunha.sudoku.domain.model.GameStatus;
import com.rafaelocunha.sudoku.domain.model.Position;

public class RemoveNumberUseCase {

    private GameSession session;

    public RemoveNumberUseCase(GameSession session) {
        this.session = session;
    }

    public void execute(int row, int column) {
        if(!session.hasActiveGame()) {
            throw new GameNotStartedException();
        }

        Game game = session.getCurrentGame();

        if(game.getGameStatus() == GameStatus.NOT_STARTED) {
            throw new GameNotStartedException();
        }

        Position position = new Position(row, column);
        game.getBoard().getCell(position).clear();
        game.updateStatus();
    }

}
