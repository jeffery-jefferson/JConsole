package com.greg.console.Utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.greg.console.Interfaces.ICommandStringMap;
import com.greg.console.Interfaces.IJCommand;

public class CommandStringMap implements ICommandStringMap {
    private Map<String, IJCommand> _commands;

    public CommandStringMap() {
        this._commands = new HashMap<String, IJCommand>();
    }

    public Collection<IJCommand> GetCommands() throws Exception {
        return this._commands.values();
    }

    public void TryAddCommand(IJCommand command) throws Exception {
        if (this._commands.containsKey(command.GetCommandName())) {
            throw new Exception(String.format("A command with the name '%s' already exists. Please use a different name.", command.GetCommandName()));
        }
        this._commands.put(command.GetCommandName(), command);
    }

    public void TryRemoveCommand(IJCommand command) throws Exception {
        if (!this._commands.containsKey(command.GetCommandName())) {
            throw new Exception(String.format("A command with the name '%s' cannot be found.", command.GetCommandName()));
        }
        this._commands.remove(command.GetCommandName());
    }

    public IJCommand TryGetCommandByName(String commandName) throws Exception {
        if (!this._commands.containsKey(commandName)) {
            throw new Exception(String.format("A command with the name '%s' cannot be found.", commandName));
        }
        return this._commands.get(commandName);
    }
}
