package com.greg.console;

import java.util.Scanner;

import com.greg.console.Interfaces.IJConsole;
import com.greg.console.Interfaces.IJCommand;
import com.greg.console.Utils.CommandStringMap;
import com.greg.console.Utils.CommandStringParser;

public class JConsole implements IJConsole {

    private CommandStringMap _commands;
    private String _consoleInputSymbol = "@";

    public JConsole() {
        this._commands = new CommandStringMap();
    }

    public Object Prompt() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(String.format("%s ", this._consoleInputSymbol));
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
}
