package com.rafaelocunha.sudoku.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    void shouldCreateValidPosition() {
        Position position = new Position(3, 4);

        assertEquals(3, position.row());
        assertEquals(4, position.column());
    }

    @Test
    void shouldThrowExceptionForInvalidRowNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Position(-1, 5);
        });
    }

    @Test
    void shouldThrowExceptionForInvalidRowMaxValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Position(9, 5);
        });
    }

    @Test
    void shouldThrowExceptionForInvalidColumnNegative() {
        assertThrows(IllegalArgumentException.class, () ->{
            new Position(5, -1);
        });
    }

    @Test
    void shouldThrowExceptionForInvalidColumnMaxValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Position(5, 9);
        });
    }

    @Test
    void shouldBeEqualsPosition() {
        Position p1 = new Position(5, 1);
        Position p2 = new Position(5, 1);

        assertEquals(p1, p2);
    }

    @Test
    void shouldbeNotEquals() {
        Position p1 = new Position(5, 1);
        Position p2 = new Position(4, 1);

        assertNotEquals(p1, p2);
    }
}
