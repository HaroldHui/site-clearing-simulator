package com.shu.commands;

import com.shu.Facing;
import com.shu.Position;
import com.shu.costs.CostUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RightCommandTest {

    @Test
    @DisplayName("When execute with a north facing position, it should return a SUCCESS state")
    void executeWhenFacingNorthSuccess() {
        Position originalPosition = new Position(0, 0, Facing.NORTH);
        RightCommand RightCommand = new RightCommand(originalPosition);
        CommandResult result = RightCommand.execute();

        CommandState actualState = result.getCommandState();
        CommandState expectedState = CommandState.SUCCESS;

        assertThat(actualState).isEqualTo(expectedState);
    }

    @Test
    @DisplayName("When execute with a north facing position, it should return a position with original dimension and facing east")
    void executeWhenFacingNorth() {
        RightCommand RightCommand = new RightCommand(new Position(0, 0, Facing.NORTH));
        CommandResult result = RightCommand.execute();

        Position actualPosition = result.getPosition();
        Facing actualFacing = actualPosition.getFacing();
        Integer expectedxDimension = 0;
        Integer expectedyDimension = 0;
        Facing expectedFacing = Facing.EAST;

        assertThat(actualFacing).isEqualTo(expectedFacing);
        assertThat(actualPosition.getxDimension()).isEqualTo(expectedxDimension);
        assertThat(actualPosition.getyDimension()).isEqualTo(expectedyDimension);
    }

    @Test
    @DisplayName("When execute with a north facing position, it should only have communication cost")
    void executeWhenFacingNorthNoCost() {
        Position originalPosition = new Position(0, 0, Facing.NORTH);
        RightCommand RightCommand = new RightCommand(originalPosition);
        CommandResult result = RightCommand.execute();

        Integer actualCost = CostUtils.calculateCredits(result.getCosts());
        Integer expectedCost = 1;

        assertThat(actualCost).isEqualTo(expectedCost);
    }

    @Test
    @DisplayName("When execute with a east facing position, it should return a SUCCESS state")
    void executeWhenFacingEastSuccess() {
        Position originalPosition = new Position(0, 0, Facing.EAST);
        RightCommand RightCommand = new RightCommand(originalPosition);
        CommandResult result = RightCommand.execute();

        CommandState actualState = result.getCommandState();
        CommandState expectedState = CommandState.SUCCESS;

        assertThat(actualState).isEqualTo(expectedState);
    }

    @Test
    @DisplayName("When execute with a east facing position, it should return a position with original dimension and facing south")
    void executeWhenFacingWest() {
        RightCommand RightCommand = new RightCommand(new Position(0, 0, Facing.EAST));
        CommandResult result = RightCommand.execute();

        Position actualPosition = result.getPosition();
        Facing actualFacing = actualPosition.getFacing();
        Integer expectedxDimension = 0;
        Integer expectedyDimension = 0;
        Facing expectedFacing = Facing.SOUTH;

        assertThat(actualFacing).isEqualTo(expectedFacing);
        assertThat(actualPosition.getxDimension()).isEqualTo(expectedxDimension);
        assertThat(actualPosition.getyDimension()).isEqualTo(expectedyDimension);
    }

    @Test
    @DisplayName("When execute with a east facing position, it should only have communication cost")
    void executeWhenFacingWestNoCost() {
        Position originalPosition = new Position(0, 0, Facing.EAST);
        RightCommand RightCommand = new RightCommand(originalPosition);
        CommandResult result = RightCommand.execute();

        Integer actualCost = CostUtils.calculateCredits(result.getCosts());
        Integer expectedCost = 1;

        assertThat(actualCost).isEqualTo(expectedCost);
    }

    @Test
    @DisplayName("When execute with a south facing position, it should return a SUCCESS state")
    void executeWhenFacingSouthSuccess() {
        Position originalPosition = new Position(0, 0, Facing.SOUTH);
        RightCommand RightCommand = new RightCommand(originalPosition);
        CommandResult result = RightCommand.execute();

        CommandState actualState = result.getCommandState();
        CommandState expectedState = CommandState.SUCCESS;

        assertThat(actualState).isEqualTo(expectedState);
    }

    @Test
    @DisplayName("When execute with a south facing position, it should return a position with original dimension and facing west")
    void executeWhenFacingSouth() {
        RightCommand RightCommand = new RightCommand(new Position(0, 0, Facing.SOUTH));
        CommandResult result = RightCommand.execute();

        Position actualPosition = result.getPosition();
        Facing actualFacing = actualPosition.getFacing();
        Integer expectedxDimension = 0;
        Integer expectedyDimension = 0;
        Facing expectedFacing = Facing.WEST;

        assertThat(actualFacing).isEqualTo(expectedFacing);
        assertThat(actualPosition.getxDimension()).isEqualTo(expectedxDimension);
        assertThat(actualPosition.getyDimension()).isEqualTo(expectedyDimension);
    }

    @Test
    @DisplayName("When execute with a south facing position, it should only have communication cost")
    void executeWhenFacingSouthNoCost() {
        Position originalPosition = new Position(0, 0, Facing.SOUTH);
        RightCommand RightCommand = new RightCommand(originalPosition);
        CommandResult result = RightCommand.execute();

        Integer actualCost = CostUtils.calculateCredits(result.getCosts());
        Integer expectedCost = 1;

        assertThat(actualCost).isEqualTo(expectedCost);
    }

    @Test
    @DisplayName("When execute with a west facing position, it should return a SUCCESS state")
    void executeWhenFacingWestSuccess() {
        Position originalPosition = new Position(0, 0, Facing.WEST);
        RightCommand RightCommand = new RightCommand(originalPosition);
        CommandResult result = RightCommand.execute();

        CommandState actualState = result.getCommandState();
        CommandState expectedState = CommandState.SUCCESS;

        assertThat(actualState).isEqualTo(expectedState);
    }

    @Test
    @DisplayName("When execute with a west facing position, it should return a position with original dimension and facing north")
    void executeWhenFacingEast() {
        RightCommand RightCommand = new RightCommand(new Position(0, 0, Facing.WEST));
        CommandResult result = RightCommand.execute();

        Position actualPosition = result.getPosition();
        Facing actualFacing = actualPosition.getFacing();
        Integer expectedxDimension = 0;
        Integer expectedyDimension = 0;
        Facing expectedFacing = Facing.NORTH;

        assertThat(actualFacing).isEqualTo(expectedFacing);
        assertThat(actualPosition.getxDimension()).isEqualTo(expectedxDimension);
        assertThat(actualPosition.getyDimension()).isEqualTo(expectedyDimension);
    }

    @Test
    @DisplayName("When execute with a west facing position, it should only have communication cost")
    void executeWhenFacingEastNoCost() {
        Position originalPosition = new Position(0, 0, Facing.EAST);
        RightCommand RightCommand = new RightCommand(originalPosition);
        CommandResult result = RightCommand.execute();

        Integer actualCost = CostUtils.calculateCredits(result.getCosts());
        Integer expectedCost = 1;

        assertThat(actualCost).isEqualTo(expectedCost);
    }

}