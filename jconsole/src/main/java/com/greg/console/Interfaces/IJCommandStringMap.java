package com.greg.console.Interfaces;

import java.util.Collection;

public interface IJCommandStringMap 
{
    public void TryAddCommand(IJCommand command) throws Exception;
    public void TryRemoveCommand(IJCommand command) throws Exception;
    public IJCommand TryGetCommandByName(String commandName) throws Exception;
    public Collection<IJCommand> GetCommands() throws Exception;
}
