package com.greg.console;

import com.greg.console.Interfaces.IJCommand;

public abstract class JCommand<TReturnType> implements IJCommand 
{
    private String _commandName;
    private String _commandDescription;

    public JCommand(String commandName) 
    {
        this._commandName = commandName;
        this._commandDescription = "N/A";
    }

    public JCommand(String commandName, String commandDescription) 
    {
        this._commandName = commandName;
        this._commandDescription = commandDescription;
    }

    public String GetCommandName() 
    {
        return this._commandName;
    }

    public String GetCommandDescription() 
    {
        return this._commandDescription;
    }

    public abstract TReturnType Invoke(String[] params);
}
