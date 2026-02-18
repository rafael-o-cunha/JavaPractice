package com.rafaelocunha.sudoku.usecase;

import com.rafaelocunha.sudoku.domain.model.Game;

public class GameSession {

    private Game currentGame;

    public void startNewGame(Game game) {
        this.currentGame = game;
    }

    public Game getCurrentGame() {
        if (currentGame == null) {
            throw new IllegalStateException("No game started");
        }

        return this.currentGame;
    }

    public boolean hasActiveGame() {
        return this.currentGame != null;
    }

    public void clearSession() {
        this.currentGame = null;
    }
}
