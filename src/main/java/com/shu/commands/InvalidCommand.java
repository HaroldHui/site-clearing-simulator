package com.shu.commands;

import com.shu.Position;

public class InvalidCommand implements Command {
    private final Position position;

    public InvalidCommand(Position position) {
        this.position = position;
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(this.position, 0, CommandState.INVALID_COMMAND);
    }
}
