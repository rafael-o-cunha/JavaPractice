package com.rafaelocunha.sudoku.ui.terminal;

import com.rafaelocunha.sudoku.usecase.dto.BoardState;
import com.rafaelocunha.sudoku.usecase.dto.CellState;

public class BoardPrinter {
    public void print(BoardState boardState) {

        for (int row = 0; row < boardState.grid().length; row++) {

            if (row % 3 == 0 && row != 0) {
                System.out.println("------+-------+------");
            }

            for (int col = 0; col < boardState.grid()[row].length; col++) {

                if (col % 3 == 0 && col != 0) {
                    System.out.print("| ");
                }

                CellState cell = boardState.grid()[row][col];

                if (cell.isEmpty()) {
                    System.out.print(". ");
                }
                else {
                    System.out.print(cell.value() + " ");
                }
            }

            System.out.println();
        }
    }
}
