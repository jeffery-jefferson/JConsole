package com.greg.console.Interfaces;

public interface ICommandStringMap {
    public void TryAddCommand(IJCommand command) throws Exception;
    public void TryRemoveCommand(IJCommand command) throws Exception;
    public IJCommand TryGetCommandByName(String commandName) throws Exception;
}
