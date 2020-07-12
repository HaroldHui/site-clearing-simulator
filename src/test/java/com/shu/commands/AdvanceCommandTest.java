package com.shu.commands;

import com.shu.ConstructionSite;
import com.shu.Facing;
import com.shu.Position;
import com.shu.blocks.*;
import com.shu.costs.CostUtils;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AdvanceCommandTest {
    @Test
    @DisplayName("When execute Advance command successfully, it should return a Success state")
    void executeSuccessState() {
        ConstructionSite constructionSite = generateConstructionSite();
        Position originalPosition = new Position(0, 0, Facing.EAST);
        AdvanceCommand advanceCommand = new AdvanceCommand(constructionSite, originalPosition, 1);
        CommandResult result = advanceCommand.execute();

        CommandState actualState = result.getCommandState();
        CommandState expectedState = CommandState.SUCCESS;

        assertThat(actualState).isEqualTo(expectedState);
    }

    @Test
    @DisplayName("When execute Advance command successfully, it should return correct cost")
    void executeCorrectCost() {
        ConstructionSite constructionSite = generateConstructionSite();
        Position originalPosition = new Position(-1, 0, Facing.EAST);
        AdvanceCommand advanceCommand = new AdvanceCommand(constructionSite, originalPosition, 3);
        CommandResult result = advanceCommand.execute();

        Integer actualCost = CostUtils.calculateCredits(result.getCosts());
        Integer expectedCost = 1 + 1 + 4 + 2; // communication cost + 3 block costs

        assertThat(actualCost).isEqualTo(expectedCost);
    }

    @Test
    @DisplayName("When execute Advance command successfully, it should change visited blocks to VisitedBlock")
    void executeInvalidState() {
        ConstructionSite constructionSite = generateConstructionSite();
        Position originalPosition = new Position(-1, 0, Facing.EAST);
        AdvanceCommand advanceCommand = new AdvanceCommand(constructionSite, originalPosition, 3);
        CommandResult result = advanceCommand.execute();

        Block[][] actualBlocks = constructionSite.getBlocks();
        ArrayList<Block> visitedBlocks = Lists.list(actualBlocks[0][0], actualBlocks[0][1], actualBlocks[0][2]);

        assertThat(visitedBlocks).asList().allSatisfy(block -> assertThat(block).isInstanceOf(VisitedBlock.class));
    }

    @Test
    @DisplayName("When execute Advance command that could go out of boundary, it should return a BEYOND_BOUNDARIES state")
    void executeBeyondBoundaries() {
        ConstructionSite constructionSite = generateConstructionSite();
        Position originalPosition = new Position(2, 1, Facing.SOUTH);
        AdvanceCommand advanceCommand = new AdvanceCommand(constructionSite, originalPosition, 3);
        CommandResult result = advanceCommand.execute();

        CommandState actualState = result.getCommandState();
        CommandState expectedState = CommandState.BEYOND_BOUNDARIES;

        assertThat(actualState).isEqualTo(expectedState);
    }

    @Test
    @DisplayName("When execute Advance command that could go out of boundary, it should return correct cost")
    void executeBeyondBoundariesCorrectCost() {
        ConstructionSite constructionSite = generateConstructionSite();
        Position originalPosition = new Position(2, 1, Facing.SOUTH);
        AdvanceCommand advanceCommand = new AdvanceCommand(constructionSite, originalPosition, 3);
        CommandResult result = advanceCommand.execute();

        Integer actualCost = CostUtils.calculateCredits(result.getCosts());
        Integer expectedCost = 1 + 1 + 2 + 0; // communication cost + 2 block costs

        assertThat(actualCost).isEqualTo(expectedCost);
    }

    @Test
    @DisplayName("When execute Advance command that could go out of boundary, it should change visited blocks to VisitedBlock")
    void executeBeyondBoundariesVisitedBlock() {
        ConstructionSite constructionSite = generateConstructionSite();
        Position originalPosition = new Position(2, 1, Facing.SOUTH);
        AdvanceCommand advanceCommand = new AdvanceCommand(constructionSite, originalPosition, 3);
        CommandResult result = advanceCommand.execute();

        Block[][] actualBlocks = constructionSite.getBlocks();
        ArrayList<Block> visitedBlocks = Lists.list(actualBlocks[2][2], actualBlocks[3][2]);

        assertThat(visitedBlocks).asList().allSatisfy(block -> assertThat(block).isInstanceOf(VisitedBlock.class));
    }

    @Test
    @DisplayName("When execute Advance command with preserved tree, it should return a REMOVE_PRESERVED_TREE state")
    void executePreservedTree() {
        ConstructionSite constructionSite = generateConstructionSite();
        Position originalPosition = new Position(1, 3, Facing.NORTH);
        AdvanceCommand advanceCommand = new AdvanceCommand(constructionSite, originalPosition, 3);
        CommandResult result = advanceCommand.execute();

        CommandState actualState = result.getCommandState();
        CommandState expectedState = CommandState.REMOVE_PRESERVED_TREE;

        assertThat(actualState).isEqualTo(expectedState);
    }

    @Test
    @DisplayName("When execute Advance command with preserved tree, it should return correct cost")
    void executePreservedTreeCorrectCost() {
        ConstructionSite constructionSite = generateConstructionSite();
        Position originalPosition = new Position(1, 3, Facing.NORTH);
        AdvanceCommand advanceCommand = new AdvanceCommand(constructionSite, originalPosition, 3);
        CommandResult result = advanceCommand.execute();

        Integer actualCost = CostUtils.calculateCredits(result.getCosts());
        Integer expectedCost = 1 + 2 + 10; // communication cost + 3 block costs

        assertThat(actualCost).isEqualTo(expectedCost);
    }

    @Test
    @DisplayName("When execute Advance command successfully, it should change visited blocks to VisitedBlock")
    void executePreservedTreeVisitedBlock() {
        ConstructionSite constructionSite = generateConstructionSite();
        Position originalPosition = new Position(1, 3, Facing.NORTH);
        AdvanceCommand advanceCommand = new AdvanceCommand(constructionSite, originalPosition, 3);
        CommandResult result = advanceCommand.execute();

        Block[][] actualBlocks = constructionSite.getBlocks();
        Block actualBlock = actualBlocks[2][1];

        assertThat(actualBlock).isInstanceOf(VisitedBlock.class);
    }

    @Test
    @DisplayName("When execute Advance command successfully, it should stop and only change the preserved tree block")
    void executePreservedTreeStop() {
        ConstructionSite constructionSite = generateConstructionSite();
        Position originalPosition = new Position(2, 2, Facing.WEST);
        AdvanceCommand advanceCommand = new AdvanceCommand(constructionSite, originalPosition, 2);
        CommandResult result = advanceCommand.execute();

        Block[][] actualBlocks = constructionSite.getBlocks();
        Block actualBlock = actualBlocks[3][0];

        assertThat(actualBlock).isInstanceOf(PlainLand.class);
    }

    private ConstructionSite generateConstructionSite() {
        Block[][] blocks = {
                {new PlainLand(), new RemovableTree(), new RockyGround(), new PlainLand()},
                {new PlainLand(), new PlainLand(), new PlainLand(), new PlainLand()},
                {new PlainLand(), new PreservedTree(), new RockyGround(), new PlainLand()},
                {new PlainLand(), new PlainLand(), new PlainLand(), new PlainLand()}
        };
        return new ConstructionSite(blocks);
    }
}
