package com.shu.commands;

import com.shu.Facing;
import com.shu.Position;

import java.util.ArrayList;
import java.util.Collections;

public class LeftCommand extends Command {

    private final Position position;

    public LeftCommand(Position position) {
        this.position = position;
    }

    @Override
    protected CommandResult executeCommand() {
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
        return new CommandResult(position, Collections.emptyList(), CommandState.SUCCESS);
    }
}
