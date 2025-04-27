# Java Console v1.0
This is a generic Java Console Interface.

It provides a basic architecture that allows you to execute custom commands in a Custom Console Interface.

## Architecture
 - The Console object manages I/O
 - The ConsoleCommand object is an abstract class that should be extended to create custom functionality for the command
    - IE: each command should be a class that inherits ConsoleCommand and implements its abstract Invoke function.