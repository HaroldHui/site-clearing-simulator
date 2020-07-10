package com.shu.commands;

import com.shu.Facing;
import com.shu.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InvalidCommandTest {

    @Test
    @DisplayName("When execute an Invalid command, it should return a Invalid state")
    void executeInvalidState() {
        Position originalPosition = new Position(0, 0, Facing.NORTH);
        InvalidCommand invalidCommand = new InvalidCommand(originalPosition);
        CommandResult result = invalidCommand.execute();

        CommandState actualState = result.getCommandState();
        CommandState expectedState = CommandState.INVALID_COMMAND;

        assertThat(actualState).isEqualTo(expectedState);
    }

    @Test
    @DisplayName("When execute an Invalid command, it should return same position as before")
    void executeSamePosition() {
        Position originalPosition = new Position(0, 0, Facing.NORTH);
        InvalidCommand invalidCommand = new InvalidCommand(originalPosition);
        CommandResult result = invalidCommand.execute();

        Position actualPosition = result.getPosition();

        assertThat(actualPosition).isEqualTo(originalPosition);
    }

    @Test
    @DisplayName("When execute an Invalid command, it shouldn't have any cost")
    void executeNoCost() {
        Position originalPosition = new Position(0, 0, Facing.NORTH);
        InvalidCommand invalidCommand = new InvalidCommand(originalPosition);
        CommandResult result = invalidCommand.execute();

        Integer actualCost = result.getCost();
        Integer expectedCost = 0;

        assertThat(actualCost).isEqualTo(expectedCost);
    }

}
