package com.shu.commands;

import com.shu.Position;
import com.shu.costs.Cost;

import java.util.List;

public class CommandResult {
    private final Position position;
    private final CommandState commandState;
    private final List<Cost> costs;

    public CommandResult(Position position, List<Cost> costs, CommandState commandState) {
        this.position = position;
        this.costs = costs;
        this.commandState = commandState;
    }

    public Position getPosition() {
        return position;
    }

    public List<Cost> getCosts() {
        return costs;
    }

    public CommandState getCommandState() {
        return commandState;
    }
}
