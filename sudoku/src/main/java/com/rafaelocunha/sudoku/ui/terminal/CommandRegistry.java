package com.rafaelocunha.sudoku.ui.terminal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandRegistry {

    private final Map<Integer, Command> commands = new HashMap<>();

    public CommandRegistry(List<MenuOption> options) {
        for (MenuOption option : options) {
            commands.put(option.code(), option.command());
        }
    }

    public void execute(int option) {
        Command command = commands.get(option);

        if (command == null) {
            System.out.println("Invalid option.");
            return;
        }

        command.execute();
    }
}
