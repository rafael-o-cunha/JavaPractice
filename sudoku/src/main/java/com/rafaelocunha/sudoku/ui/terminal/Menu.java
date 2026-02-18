package com.rafaelocunha.sudoku.ui.terminal;

import java.util.List;
import java.util.Map;

public class Menu {

    private final List<MenuOption> options;

    public Menu(List<MenuOption> options) {
        this.options = options;
    }

    public void show() {
        System.out.println("\n=== Sudoku Menu ===");

        for (MenuOption option : options) {
            System.out.println(option.code() + " - " + option.description());
        }

        System.out.print("Choose an option: ");
    }
}
