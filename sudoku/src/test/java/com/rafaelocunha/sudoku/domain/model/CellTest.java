package com.rafaelocunha.sudoku.domain.model;

import com.rafaelocunha.sudoku.domain.exception.FixedCellModificationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    void emptyCellShouldStartEmpty() {
        Cell cell = Cell.empty();

        assertTrue(cell.isEmpty());
        assertFalse(cell.isFixed());
        assertNull(cell.getValue());
    }

    @Test
    void fixedCellShouldStartWithValue() {
        NumberValue value = new NumberValue(5);
        Cell cell = Cell.fixed(value);

        assertFalse(cell.isEmpty());
        assertTrue(cell.isFixed());
        assertEquals(value, cell.getValue());
    }

    @Test
    void shouldSetValueWhenCellIsNotFixed() {
        Cell cell = Cell.empty();
        NumberValue nv = new NumberValue(7);

        cell.setValue(nv);

        assertFalse(cell.isEmpty());
        assertEquals(nv, cell.getValue());
    }

    @Test
    void shouldThrowExceptionWhenSettingValueOnFixedCell() {
        Cell cell = Cell.fixed(new NumberValue(3));

        assertThrows(FixedCellModificationException.class, () -> {
            cell.setValue(new NumberValue(8));
        });
    }

    @Test
    void shouldClearValueWhenCellIsNotFixed() {
        Cell cell = Cell.empty();
        cell.setValue(new NumberValue(9));

        cell.clear();

        assertTrue(cell.isEmpty());
        assertNull(cell.getValue());
    }

    @Test
    void shouldThrowExceptionWhenClearingFixedCell() {
        Cell cell  = Cell.fixed(new NumberValue(4));

        assertThrows(FixedCellModificationException.class, cell::clear);
    }

    @Test
    void equalsShouldWorkForSameValueAndFixedState() {
        Cell c1 = new Cell(new NumberValue(2), false);
        Cell c2 = new Cell(new NumberValue(2), false);

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void equalsShouldDetectDifferentFixedState() {
        Cell c1 = new Cell(new NumberValue(2), true);
        Cell c2 = new Cell(new NumberValue(2), false);

        assertNotEquals(c1, c2);
    }

    @Test
    void equalsShouldDetectDifferentValues() {
        Cell c1 = new Cell(new NumberValue(2), true);
        Cell c2 = new Cell(new NumberValue(2), false);

        assertNotEquals(c1, c2);
    }
}
