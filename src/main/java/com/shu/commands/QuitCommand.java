package com.shu.commands;

import com.shu.Position;

public class QuitCommand implements Command {

    private final Position position;

    public QuitCommand(Position position) {
        this.position = position;
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(this.position, 0, CommandState.QUIT);
    }
}
