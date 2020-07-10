package com.shu.commands;

import com.shu.Facing;
import com.shu.Position;

public class LeftCommand implements Command {

    private final Position position;

    public LeftCommand(Position position) {
        this.position = position;
    }

    @Override
    public CommandResult execute() {
        switch (position.getFacing()) {
            case EAST: {
                position.setFacing(Facing.NORTH);
                break;
            }
            case NORTH: {
                position.setFacing(Facing.WEST);
                break;
            }
            case WEST: {
                position.setFacing(Facing.SOUTH);
                break;
            }
            case SOUTH: {
                position.setFacing(Facing.EAST);
                break;
            }
        }
        return new CommandResult(position, 0, CommandState.SUCCESS);
    }
}
