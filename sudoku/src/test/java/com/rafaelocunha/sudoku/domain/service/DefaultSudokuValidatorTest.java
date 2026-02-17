package com.rafaelocunha.sudoku.domain.service;

import com.rafaelocunha.sudoku.domain.model.Board;
import com.rafaelocunha.sudoku.domain.model.NumberValue;
import com.rafaelocunha.sudoku.domain.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultSudokuValidatorTest {

    private final DefaultSudokuValidator validator = new DefaultSudokuValidator();

    @Test
    void emptyBoardShouldBeValid() {
        Board board = new Board(validator);

        assertTrue(validator.isBoardValid(board));
    }

    @Test
    void shouldAllowValidMove() {
        Board board = new Board(validator);

        board.placeNumber(new Position(0, 0), new NumberValue(5));

        boolean validMove = validator.isMoveValid(board, new Position(0, 1));

        assertTrue(validMove);
    }

    @Test
    void shouldDetectDuplicateInRow() {
        Board board = new Board(validator);

        board.placeNumber(new Position(0, 0), new NumberValue(5));

        board.getCell(new Position(0, 1)).setValue(new NumberValue(5));

        assertFalse(validator.isBoardValid(board));
    }

    @Test
    void shouldDetectDuplicateInColumn() {
        Board board = new Board(validator);

        board.placeNumber(new Position(0, 0), new NumberValue(7));

        board.getCell(new Position(1, 0)).setValue(new NumberValue(7));

        assertFalse(validator.isBoardValid(board));
    }

    @Test
    void shouldDetectDuplicateInBlock() {
        Board board = new Board(validator);

        board.placeNumber(new Position(0, 0), new NumberValue(9));

        board.getCell(new Position(1, 1)).setValue(new NumberValue(9));

        assertFalse(validator.isBoardValid(board));
    }

    @Test
    void shouldInvalidateMoveWhenRowHasDuplicate() {
        Board board = new Board(validator);

        board.placeNumber(new Position(0, 0), new NumberValue(4));

        board.getCell(new Position(0, 1)).setValue(new NumberValue(4));

        assertFalse(validator.isMoveValid(board, new Position(0, 1)));
    }

    @Test
    void shouldInvalidateMoveWhenColumnHasDuplicate() {
        Board board = new Board(validator);

        board.placeNumber(new Position(0, 0), new NumberValue(3));
        board.getCell(new Position(1, 0)).setValue(new NumberValue(3));

        assertFalse(validator.isMoveValid(board, new Position(1, 0)));
    }

    @Test
    void shouldInvalidateMoveWhenBlockHasDuplicate() {
        Board board = new Board(validator);

        board.placeNumber(new Position(0, 0), new NumberValue(6));
        board.getCell(new Position(1, 1)).setValue(new NumberValue(6));

        assertFalse(validator.isMoveValid(board, new Position(1, 1)));
    }
}
