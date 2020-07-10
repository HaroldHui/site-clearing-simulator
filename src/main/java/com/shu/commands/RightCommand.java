package com.shu.commands;

import com.shu.Facing;
import com.shu.Position;

public class RightCommand implements Command {
    private final Position position;

    public RightCommand(Position position) {
        this.position = position;
    }

    @Override
    public CommandResult execute() {
        switch (position.getFacing()) {
            case EAST: {
                position.setFacing(Facing.SOUTH);
                break;
            }
            case SOUTH: {
                position.setFacing(Facing.WEST);
                break;
            }
            case WEST: {
                position.setFacing(Facing.NORTH);
                break;
            }
            case NORTH: {
                position.setFacing(Facing.EAST);
                break;
            }
        }
        return new CommandResult(position, 0, CommandState.SUCCESS);
    }
}
