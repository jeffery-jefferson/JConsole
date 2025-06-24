package com.greg.console.Interfaces;

public interface IJConsole 
{
    public Object Prompt();
    public Object RunCommand(String input);
    public boolean TryRegisterCommand(IJCommand command);
    public int Run();
}
