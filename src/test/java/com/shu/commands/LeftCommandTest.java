package com.shu.commands;

import com.shu.Facing;
import com.shu.Position;
import com.shu.costs.CommunicationCost;
import com.shu.costs.Cost;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LeftCommandTest {

    @Test
    @DisplayName("When execute with a north facing position, it should return a SUCCESS state")
    void executeWhenFacingNorthSuccess() {
        Position originalPosition = new Position(0, 0, Facing.NORTH);
        LeftCommand LeftCommand = new LeftCommand(originalPosition);
        CommandResult result = LeftCommand.execute();

        CommandState actualState = result.getCommandState();
        CommandState expectedState = CommandState.SUCCESS;

        assertThat(actualState).isEqualTo(expectedState);
    }

    @Test
    @DisplayName("When execute with a north facing position, it should return a position with original dimension and facing west")
    void executeWhenFacingNorth() {
        LeftCommand leftCommand = new LeftCommand(new Position(0, 0, Facing.NORTH));
        CommandResult result = leftCommand.execute();

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
    @DisplayName("When execute with a north facing position, it should only have communication cost")
    void executeWhenFacingNorthNoCost() {
        Position originalPosition = new Position(0, 0, Facing.NORTH);
        LeftCommand leftCommand = new LeftCommand(originalPosition);
        CommandResult result = leftCommand.execute();

        List<Cost> actualCost = result.getCosts();

        assertThat(actualCost.size()).isEqualTo(1);
        assertThat(actualCost.get(0)).isInstanceOf(CommunicationCost.class);
    }

    @Test
    @DisplayName("When execute with a west facing position, it should return a SUCCESS state")
    void executeWhenFacingWestSuccess() {
        Position originalPosition = new Position(0, 0, Facing.WEST);
        LeftCommand LeftCommand = new LeftCommand(originalPosition);
        CommandResult result = LeftCommand.execute();

        CommandState actualState = result.getCommandState();
        CommandState expectedState = CommandState.SUCCESS;

        assertThat(actualState).isEqualTo(expectedState);
    }

    @Test
    @DisplayName("When execute with a west facing position, it should return a position with original dimension and facing south")
    void executeWhenFacingWest() {
        LeftCommand leftCommand = new LeftCommand(new Position(0, 0, Facing.WEST));
        CommandResult result = leftCommand.execute();

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
    @DisplayName("When execute with a west facing position, it should only have communication cost")
    void executeWhenFacingWestNoCost() {
        Position originalPosition = new Position(0, 0, Facing.WEST);
        LeftCommand leftCommand = new LeftCommand(originalPosition);
        CommandResult result = leftCommand.execute();

        List<Cost> actualCost = result.getCosts();

        assertThat(actualCost.size()).isEqualTo(1);
        assertThat(actualCost.get(0)).isInstanceOf(CommunicationCost.class);
    }

    @Test
    @DisplayName("When execute with a south facing position, it should return a SUCCESS state")
    void executeWhenFacingSouthSuccess() {
        Position originalPosition = new Position(0, 0, Facing.SOUTH);
        LeftCommand LeftCommand = new LeftCommand(originalPosition);
        CommandResult result = LeftCommand.execute();

        CommandState actualState = result.getCommandState();
        CommandState expectedState = CommandState.SUCCESS;

        assertThat(actualState).isEqualTo(expectedState);
    }

    @Test
    @DisplayName("When execute with a south facing position, it should return a position with original dimension and facing east")
    void executeWhenFacingSouth() {
        LeftCommand leftCommand = new LeftCommand(new Position(0, 0, Facing.SOUTH));
        CommandResult result = leftCommand.execute();

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
    @DisplayName("When execute with a south facing position, it should only have communication cost")
    void executeWhenFacingSouthNoCost() {
        Position originalPosition = new Position(0, 0, Facing.SOUTH);
        LeftCommand leftCommand = new LeftCommand(originalPosition);
        CommandResult result = leftCommand.execute();

        List<Cost> actualCost = result.getCosts();

        assertThat(actualCost.size()).isEqualTo(1);
        assertThat(actualCost.get(0)).isInstanceOf(CommunicationCost.class);
    }

    @Test
    @DisplayName("When execute with a east facing position, it should return a SUCCESS state")
    void executeWhenFacingEastSuccess() {
        Position originalPosition = new Position(0, 0, Facing.EAST);
        LeftCommand LeftCommand = new LeftCommand(originalPosition);
        CommandResult result = LeftCommand.execute();

        CommandState actualState = result.getCommandState();
        CommandState expectedState = CommandState.SUCCESS;

        assertThat(actualState).isEqualTo(expectedState);
    }

    @Test
    @DisplayName("When execute with a east facing position, it should return a position with original dimension and facing north")
    void executeWhenFacingEast() {
        LeftCommand leftCommand = new LeftCommand(new Position(0, 0, Facing.EAST));
        CommandResult result = leftCommand.execute();

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
    @DisplayName("When execute with a east facing position, it should only have communication cost")
    void executeWhenFacingEastNoCost() {
        Position originalPosition = new Position(0, 0, Facing.EAST);
        LeftCommand leftCommand = new LeftCommand(originalPosition);
        CommandResult result = leftCommand.execute();

        List<Cost> actualCost = result.getCosts();

        assertThat(actualCost.size()).isEqualTo(1);
        assertThat(actualCost.get(0)).isInstanceOf(CommunicationCost.class);
    }

}