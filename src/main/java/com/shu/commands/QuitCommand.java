package com.shu.commands;

import com.shu.Position;

import java.util.Collections;

public class QuitCommand extends Command {

    private final Position position;

    public QuitCommand(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "quit";
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(this.position, Collections.emptyList(), CommandState.QUIT);
    }
}
