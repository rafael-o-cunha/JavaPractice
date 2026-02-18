package com.rafaelocunha.sudoku.domain.service;

import com.rafaelocunha.sudoku.domain.model.Board;
import com.rafaelocunha.sudoku.domain.model.Cell;
import com.rafaelocunha.sudoku.domain.model.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class DefaultSudokuValidator implements SudokuValidator {

    private static final int SIZE = 9;

    @Override
    public boolean isMoveValid(Board board, Position position) {
        return rowValid(board, position)
                && columnValid(board, position)
                && blockValid(board, position);
    }

    @Override
    public boolean isBoardValid(Board board) {
        return rowsAreValid(board)
                && columnsAreValid(board)
                && blocksAreValid(board);
    }

    private boolean rowValid(Board board, Position position) {
        Set<Integer> seen = new HashSet<>();
        int row = position.row();

        for (int col = 0; col < SIZE; col++) {
            Cell cell = board.getCell(new Position(row, col));

            if (!cell.isEmpty()) {
                int value = cell.getValue().value();
                if (!seen.add(value)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean columnValid(Board board, Position position) {
        Set<Integer> seen = new HashSet<>();
        int column = position.column();

        for (int row = 0; row < SIZE; row++) {
            Cell cell = board.getCell(new Position(row, column));

            if (!cell.isEmpty()) {
                int value = cell.getValue().value();
                if (!seen.add(value)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Exemplo de varredura com complexidade o de n¹
     *
     * @param board
     * @param position
     * @return boolean
     */
    private boolean blockValid(Board board, Position position) {
        Set<Integer> seen = new HashSet<>();

        int startRow = (position.row() / 3) * 3;
        int startCol = (position.column() / 3) * 3;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                Cell cell = board.getCell(
                        new Position(startRow + row, startCol + col)
                );

                if (!cell.isEmpty()) {
                    int value = cell.getValue().value();
                    if (!seen.add(value)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * Exemplo de implementação com streams e lambda
     *
     * @param board
     * @return boolean
     */
    private boolean rowsAreValid(Board board) {
        return IntStream.range(0, SIZE)
                .allMatch(row -> {
                    Set<Integer> seen = new HashSet<>();
                    return IntStream.range(0, SIZE)
                            .mapToObj(col ->
                                    board.getCell(new Position(row, col)))
                            .filter(cell -> !cell.isEmpty())
                            .map(cell -> cell.getValue().value())
                            .allMatch(seen::add);
                });
    }

    /**
     * Usando parallel stream para validar colunas ao mesmo tempo, ou seja,
     * 9 colunas sendo verificadas ao mesmo tempo e sendo thread safe.
     *
     * @param board
     * @return boolean
     */
    private boolean columnsAreValid(Board board) {
        return IntStream.range(0, SIZE)
                .parallel()
                .allMatch(col -> {

                    Set<Integer> seen = new HashSet<>();

                    for (int row = 0; row < SIZE; row++) {

                        Cell cell = board.getCell(new Position(row, col));

                        if (!cell.isEmpty()) {
                            int value = cell.getValue().value();
                            if (!seen.add(value)) {
                                return false;
                            }
                        }
                    }

                    return true;
                });
    }

    /**
     * Validando 9 blocos em paralelo usando ExecutorService onde cada bloco
     * será validado em uma thread sendo thread safe.
     *
     * @param board
     * @return boolean
     */
    private boolean blocksAreValid(Board board) {
        ExecutorService executor = Executors.newFixedThreadPool(9);
        try {
            List<Future<Boolean>> futures = new ArrayList<>();

            for (int blockRow = 0; blockRow < SIZE; blockRow += 3) {
                for (int blockCol = 0; blockCol < SIZE; blockCol += 3) {
                    final int startRow = blockRow;
                    final int startCol = blockCol;

                    futures.add(executor.submit(() -> {
                        Set<Integer> seen = new HashSet<>();
                        for (int row = 0; row < 3; row++) {
                            for (int col = 0; col < 3; col++) {
                                Cell cell = board.getCell(new Position(startRow + row, startCol + col));
                                if (!cell.isEmpty()) {
                                    int value = cell.getValue().value();
                                    if (!seen.add(value)) {
                                        return false;
                                    }
                                }
                            }
                        }
                        return true;
                    }));
                }
            }

            for (Future<Boolean> future : futures) {
                if (!future.get()) {
                    return false;
                }
            }

            return true;
        }
        catch (Exception e) {
            throw new RuntimeException(e);

        }
        finally {
            executor.shutdown();
        }
    }
}
