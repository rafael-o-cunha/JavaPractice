package com.rafaelocunha.sudoku.ui.terminal;

import com.rafaelocunha.sudoku.app.ApplicationFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CommandFactory {

    public static List<MenuOption> create(
            ApplicationFactory app,
            Scanner scanner,
            BoardPrinter printer,
            String map) {

        List<MenuOption> options = new ArrayList<>();

        options.add(new MenuOption(
                1,
                "Start Game",
                () -> app.start().execute(map)
        ));

        options.add(new MenuOption(
                2,
                "Place Number",
                () -> {

                    System.out.print("Row (1-9): ");
                    int rowInput = scanner.nextInt();

                    System.out.print("Column (1-9): ");
                    int colInput = scanner.nextInt();

                    System.out.print("Value (1-9): ");
                    int value = scanner.nextInt();

                    if (rowInput < 1 || rowInput > 9 ||
                            colInput < 1 || colInput > 9) {

                        System.out.println("Invalid position. Use 1-9.");
                        return;
                    }

                    int row = rowInput - 1;
                    int col = colInput - 1;

                    app.place().execute(row, col, value);
                }
        ));

        options.add(new MenuOption(
                3,
                "Remove Number",
                () -> {
                    System.out.print("Row: ");
                    int row = scanner.nextInt();
                    System.out.print("Column: ");
                    int col = scanner.nextInt();
                    app.remove().execute(row, col);
                }
        ));

        options.add(new MenuOption(
                4,
                "Show Board",
                () -> printer.print(app.board().execute())
        ));

        options.add(new MenuOption(
                5,
                "Show Status",
                () -> System.out.println("Status: " + app.status().execute())
        ));

        options.add(new MenuOption(
                6,
                "Clear Moves",
                app.clear()::execute
        ));

        options.add(new MenuOption(
                7,
                "Finish Game",
                app.finish()::execute
        ));

        options.add(new MenuOption(
                0,
                "Exit",
                () -> {}
        ));

        return options;
    }
}
