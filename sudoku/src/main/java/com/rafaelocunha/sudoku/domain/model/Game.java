package com.rafaelocunha.sudoku.domain.model;

import com.rafaelocunha.sudoku.domain.exception.GameAlreadyStartedException;
import com.rafaelocunha.sudoku.domain.service.SudokuValidator;

import java.util.Objects;

public class Game {

    private final Board board;
    private GameStatus status;

    public Game(SudokuValidator validator) {
        this.board = new Board(validator);
        this.status = GameStatus.NOT_STARTED;
    }

    public Board getBoard() {
        return this.board;
    }

    public GameStatus getGameStatus() {
        return this.status;
    }

    public void start() {
        if(status != GameStatus.NOT_STARTED) throw new GameAlreadyStartedException();
        status = GameStatus.INCOMPLETE;
    }

    public void updateStatus() {

        if (board.isComplete() && board.isValid()) {
            status = GameStatus.COMPLETE;
            return;
        }
        status = GameStatus.INCOMPLETE;
    }

    public void reset() {
        status = GameStatus.NOT_STARTED;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(board, game.board) && status == game.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(board, status);
    }
}
