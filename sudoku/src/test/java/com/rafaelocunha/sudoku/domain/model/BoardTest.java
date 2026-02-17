package com.rafaelocunha.sudoku.domain.model;

import com.rafaelocunha.sudoku.domain.InvalidMoveException;
import com.rafaelocunha.sudoku.domain.exception.CellAlreadyFilledException;
import com.rafaelocunha.sudoku.domain.service.SudokuValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

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
    void boardShouldStartEmpty() {
        Board board = new Board(alwaysValid);
        Position position = new Position(0, 0);

        assertTrue(board.getCell(position).isEmpty());
        assertFalse(board.isComplete());
    }

    @Test
    void shouldPlaceNumberSuccessfullyWhenValid() {
        Board board = new Board(alwaysValid);
        Position position = new Position(1, 1);
        NumberValue value = new NumberValue(5);

        board.placeNumber(position, value);

        assertEquals(value, board.getCell(position).getValue());
    }

    @Test
    void shouldThrowExceptionWhenPlacingNumberInFilledCell() {
        Board board = new Board(alwaysValid);
        Position position = new Position(2, 2);

        board.placeNumber(position, new NumberValue(3));

        assertThrows(CellAlreadyFilledException.class, () ->
                board.placeNumber(position, new NumberValue(4))
        );
    }

    @Test
    void shouldRollbackWhenValidatorRejectsMove() {
        Board board = new Board(alwaysInvalid);
        Position position = new Position(3, 3);

        assertThrows(InvalidMoveException.class, () ->
                board.placeNumber(position, new NumberValue(7))
        );

        assertTrue(board.getCell(position).isEmpty());
    }

    @Test
    void shouldDetectCompleteBoard() {
        Board board = new Board(alwaysValid);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board.placeNumber(new Position(row, col), new NumberValue(1));
            }
        }

        assertTrue(board.isComplete());
    }

    @Test
    void shouldReturnIncompleteStatusWhenNotFull() {
        Board board = new Board(alwaysValid);

        board.placeNumber(new Position(0, 0), new NumberValue(1));

        assertEquals(GameStatus.INCOMPLETE, board.getStatus());
    }

    @Test
    void shouldReturnCompleteStatusWhenFullAndValid() {
        Board board = new Board(alwaysValid);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board.placeNumber(new Position(row, col), new NumberValue(1));
            }
        }

        assertEquals(GameStatus.COMPLETE, board.getStatus());
    }

    @Test
    void shouldReturnFalseWhenAnyCellIsEmpty() {
        Board board = new Board(alwaysValid);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board.placeNumber(new Position(row, col), new NumberValue(1));
            }
        }

        Position offDiagonal = new Position(0, 1);
        board.getCell(offDiagonal).clear();

        assertFalse(board.isComplete());
    }

}
