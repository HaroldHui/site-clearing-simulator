package com.shu.commands;

import com.shu.Position;

public class CommandResult {
    private final Position position;
    private final Integer cost;
    private final CommandState commandState;

    public CommandResult(Position position, Integer cost, CommandState commandState) {
        this.position = position;
        this.cost = cost == null ? 0 : cost;
        this.commandState = commandState;
    }

    public Position getPosition() {
        return position;
    }

    public Integer getCost() {
        return cost;
    }

    public CommandState getCommandState() {
        return commandState;
    }
}
