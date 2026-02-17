package com.rafaelocunha.sudoku.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberValueTest {


    @Test
    void shouldCreateValidNumberValue() {
        NumberValue nv = new NumberValue(4);

        assertEquals(4, nv.value());
    }

    @Test
    void shouldThrowExceptionForInvalidNumberValueMin() {
        assertThrows(IllegalArgumentException.class, () -> {
            new NumberValue(0);
        });
    }

    @Test
    void shouldThrowExceptionForInvalidNumberValueMax() {
        assertThrows(IllegalArgumentException.class, () -> {
            new NumberValue(10);
        });
    }

}
