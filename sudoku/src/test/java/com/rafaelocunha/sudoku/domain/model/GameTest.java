package com.rafaelocunha.sudoku.domain.model;

import com.rafaelocunha.sudoku.domain.exception.GameAlreadyStartedException;
import com.rafaelocunha.sudoku.domain.service.SudokuValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private final SudokuValidator alwaysValid = new SudokuValidator() {
        @Override
        public boolean isMoveValid(Board board, Position position) {
            return true;
        }

        @Override
        public boolean isBoardValid(Board board) {
            return true;
        }
    };

    private final SudokuValidator alwaysInvalid = new SudokuValidator() {
        @Override
        public boolean isMoveValid(Board board, Position position) {
            return false;
        }

        @Override
        public boolean isBoardValid(Board board) {
            return false;
        }
    };

    @Test
    void newGameShouldStartWithNotStartedStatus() {
        Game game = new Game(alwaysValid);

        assertEquals(GameStatus.NOT_STARTED, game.getGameStatus());
    }

    @Test
    void shouldStartGameSuccessfully() {
        Game game = new Game(alwaysValid);

        game.start();

        assertEquals(GameStatus.INCOMPLETE, game.getGameStatus());
    }

    @Test
    void shouldThrowExceptionWhenStartingGameTwice() {
        Game game = new Game(alwaysValid);

        game.start();

        assertThrows(GameAlreadyStartedException.class, game::start);
    }

    @Test
    void resetShouldReturnStatusToNotStarted() {
        Game game = new Game(alwaysValid);

        game.start();
        game.reset();

        assertEquals(GameStatus.NOT_STARTED, game.getGameStatus());
    }

    @Test
    void shouldUpdateStatusToCompleteWhenBoardIsFullAndValid() {
        Game game = new Game(alwaysValid);

        game.start();

        Board board = game.getBoard();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board.placeNumber(new Position(row, col), new NumberValue(1));
            }
        }

        game.updateStatus();

        assertEquals(GameStatus.COMPLETE, game.getGameStatus());
    }

    @Test
    void shouldRemainIncompleteWhenBoardIsNotFull() {
        Game game = new Game(alwaysValid);

        game.start();

        game.getBoard().placeNumber(new Position(0, 0), new NumberValue(5));

        game.updateStatus();

        assertEquals(GameStatus.INCOMPLETE, game.getGameStatus());
    }

    @Test
    void shouldNotSetCompleteIfBoardHasErrors() {
        SudokuValidator fakeValidator = new SudokuValidator() {

            @Override
            public boolean isMoveValid(Board board, Position position) {
                return true;
            }

            @Override
            public boolean isBoardValid(Board board) {
                return false;
            }
        };

        Game game = new Game(fakeValidator);

        game.start();

        Board board = game.getBoard();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board.placeNumber(new Position(row, col), new NumberValue(1));
            }
        }

        game.updateStatus();

        assertNotEquals(GameStatus.COMPLETE, game.getGameStatus());
    }
}
