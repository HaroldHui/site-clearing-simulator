package com.shu.commands;

import com.shu.Facing;
import com.shu.Position;

import java.util.Collections;

public class RightCommand extends Command {
    private final Position position;

    public RightCommand(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "right";
    }

    @Override
    protected CommandResult executeCommand() {
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
        return new CommandResult(position, Collections.emptyList(), CommandState.SUCCESS);
    }
}
