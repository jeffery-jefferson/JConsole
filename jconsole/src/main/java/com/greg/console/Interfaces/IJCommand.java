package com.greg.console.Interfaces;

public interface IJCommand<TReturnType> {
    public String GetCommandName();
    public String GetCommandDescription();
    public TReturnType Invoke(String[] params);
}
