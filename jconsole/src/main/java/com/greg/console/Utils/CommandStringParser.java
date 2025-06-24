package com.greg.console.Utils;

import java.util.Arrays;

public final class CommandStringParser 
{
    public static Pair<String, String[]> GetCommandNameArgsPair(String input) 
    {
        var strings = input.split(" ");
        return new Pair<String, String[]>(strings[0], Arrays.copyOfRange(strings, 1, strings.length));
    }
}
