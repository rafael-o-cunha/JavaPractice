package com.rafaelocunha.sudoku.ui.terminal;

import java.util.Scanner;

public class TerminalController {

    private final Menu menu;
    private final CommandRegistry registry;
    private final Scanner scanner = new Scanner(System.in);

    private boolean running = true;

    public TerminalController(Menu menu, CommandRegistry registry) {
        this.menu = menu;
        this.registry = registry;
    }

    public void start() {
        while (running) {
            try {
                menu.show();
                int option = scanner.nextInt();
                if (option == 0) {
                    running = false;
                    System.out.println("Exiting...");
                    continue;
                }

                registry.execute(option);
                clearScreen();
                registry.execute(4);
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
