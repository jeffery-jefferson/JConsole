package com.greg.console;

import java.util.Scanner;

import com.greg.console.Interfaces.IJConsole;
import com.greg.console.Interfaces.IJCommand;
import com.greg.console.Utils.CommandStringMap;
import com.greg.console.Utils.CommandStringParser;

public class JConsole implements IJConsole {

    private CommandStringMap _commands;
    private Character _consoleInputSymbol = '@';

    public JConsole() {
        this._commands = new CommandStringMap();
        TryAddCommand(new HelpCommand());
    }

    public int Run() {
        while (true) {
            Prompt();
            break;
        }
        return 0;
    }

    public Object Prompt() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(String.format("%c ", this._consoleInputSymbol));
        var userInput = keyboard.nextLine();
        keyboard.close();

        return Prompt(userInput);
    }

    public Object Prompt(String userInput) {
        try {
            var stringArgsPair = CommandStringParser.GetCommandNameArgsPair(userInput);

            var userCommand = this._commands.TryGetCommandByName(stringArgsPair.Item1);
            
            return userCommand.Invoke(stringArgsPair.Item2);

        } catch (Exception ex) {
            System.out.println(String.format("Error: %s", ex.getMessage()));
            return null;
        }
    }

    public boolean TryAddCommand(IJCommand command) {
        try {
            this._commands.TryAddCommand(command);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void SetConsoleSymbol(Character symbol) {
        this._consoleInputSymbol = symbol;
    }

    // region Pre-defined Commands
    private class HelpCommand extends JCommand<Boolean> {
        public HelpCommand() {
            super("help");
        }

        @Override
        public Boolean Invoke(String[] args) {
            System.out.println("JConsole v1.0 2025 @Jeffery-Jefferson");
            return true;
        }
    }

    private class ListCommands extends JCommand<Boolean> {
        public ListCommands() {
            super("commands");
        }

        @Override
        public Boolean Invoke(String[] args) {
            // loop through kvps
        }
    }
    // endregion
}
