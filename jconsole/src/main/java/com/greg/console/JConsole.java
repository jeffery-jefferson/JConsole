package com.greg.console;

import java.util.Collection;
import java.util.Scanner;

import com.greg.console.Interfaces.IJConsole;
import com.greg.console.Interfaces.IJCommand;
import com.greg.console.Utils.CommandStringMap;
import com.greg.console.Utils.CommandStringParser;

public class JConsole implements IJConsole {

    private CommandStringMap _commands;
    private Character _consoleInputSymbol = '@';
    private Scanner _keyboard;

    public JConsole() {
        this._keyboard = new Scanner(System.in);
        this._commands = new CommandStringMap();
        TryRegisterCommand(new HelpCommand());
        TryRegisterCommand(new ListCommand());
        TryRegisterCommand(new ExitCommand());
    }

    public int Run() {
        while (true) {
            if (Prompt() == null) {
                break;
            }
        }
        return 0;
    }

    public Object Prompt() {
        System.out.print(String.format("%c ", this._consoleInputSymbol));
        var userInput = this._keyboard.nextLine();

        return RunCommand(userInput);
    }

    public Object RunCommand(String input) {
        try {
            var stringArgsPair = CommandStringParser.GetCommandNameArgsPair(input);

            var userCommand = this._commands.TryGetCommandByName(stringArgsPair.Item1);
            
            return userCommand.Invoke(stringArgsPair.Item2);

        } catch (Exception ex) {
            System.out.println(String.format("Error: %s", ex.getMessage()));
            return false;
        }
    }

    public boolean TryRegisterCommand(IJCommand command) {
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

    private class ListCommand extends JCommand<Boolean> {
        public ListCommand() {
            super("commands");
        }

        @Override
        public Boolean Invoke(String[] args) {
            try {
                Collection<IJCommand> commands = _commands.GetCommands();
                for (IJCommand command : commands) {
                    System.out.println(String.format(" - %s\nDescription: %s", command.GetCommandName(), command.GetCommandDescription()));
                }
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
    }

    private class ExitCommand extends JCommand<Void> {
        public ExitCommand() {
            super("exit");
        }

        @Override
        public Void Invoke(String[] args) {
            return null;
        }
    }
    // endregion
}
