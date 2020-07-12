package com.shu.commands;

import com.shu.Position;

import java.util.ArrayList;
import java.util.Collections;

public class InvalidCommand extends Command {
    private final Position position;

    public InvalidCommand(Position position) {
        this.position = position;
    }

    @Override
    protected CommandResult executeCommand() {
        return new CommandResult(this.position, Collections.emptyList(), CommandState.INVALID_COMMAND);
    }
}
