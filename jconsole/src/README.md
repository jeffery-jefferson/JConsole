# Java Console v1.0
This is a generic Java Console Interface.

It provides a basic architecture that allows you to execute custom commands in a Custom Console Interface.

## Architecture
 - The JConsole object manages I/O
 - The JCommand object is an abstract class that should be extended to create custom functionality for the command
    - IE: each command should be a class that inherits ConsoleCommand and implements its abstract Invoke function.
 - The JCommand should at least return a non-null value (otherwise if it does, it will exit the console)
 - The JConsole has:
    - `Run()` command that calls prompts `while (true)`,
    - or you can use the `Prompt()` command to prompt the user a single time.
