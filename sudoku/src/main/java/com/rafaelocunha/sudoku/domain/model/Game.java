package com.rafaelocunha.sudoku.domain.model;

import com.rafaelocunha.sudoku.domain.exception.GameAlreadyStartedException;
import com.rafaelocunha.sudoku.domain.service.SudokuValidator;

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
        if(board.isComplete() && !board.hasErrors()) {
            status = GameStatus.COMPLETE;
        }
        else if(!board.isComplete()) {
            status = GameStatus.INCOMPLETE;
        }
    }

    public void reset() {
        status = GameStatus.NOT_STARTED;
    }

}
