package com.shu.commands;

import com.shu.Position;

import java.util.Collections;

public class InvalidCommand implements Command {
    private final Position position;

    public InvalidCommand(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "invalid command";
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(this.position, Collections.emptyList(), CommandState.INVALID_COMMAND);
    }
}
