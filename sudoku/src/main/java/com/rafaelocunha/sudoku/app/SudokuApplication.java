package com.rafaelocunha.sudoku.app;

import com.rafaelocunha.sudoku.domain.service.DefaultSudokuValidator;
import com.rafaelocunha.sudoku.ui.terminal.*;
import com.rafaelocunha.sudoku.usecase.*;

import java.util.List;
import java.util.Scanner;

public class SudokuApplication {

    public static void main(String[] args) {

        String map = args.length > 0 ? args[0] : null;

        ApplicationFactory app = new ApplicationFactory();

        Scanner scanner = new Scanner(System.in);
        BoardPrinter printer = new BoardPrinter();

        List<MenuOption> options = CommandFactory.create(app, scanner, printer, map);

        Menu menu = new Menu(options);
        CommandRegistry registry = new CommandRegistry(options);

        TerminalController controller =
                new TerminalController(menu, registry);

        controller.start();
    }
}
