package com.greg.console.Interfaces;

public interface IJConsole {
    public Object Prompt();
    public Object Prompt(String userInput);
    public boolean TryAddCommand(IJCommand command);
}
