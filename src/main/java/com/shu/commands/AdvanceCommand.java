package com.shu.commands;

import com.shu.ConstructionSite;
import com.shu.Facing;
import com.shu.Position;
import com.shu.blocks.AbstractBlock;
import com.shu.blocks.PreservedTree;
import com.shu.blocks.VisitedBlock;

import java.util.function.Function;

public class AdvanceCommand implements Command {

    private final ConstructionSite constructionSite;
    private final Position position;
    private final Integer numberOfSquares;

    public AdvanceCommand(ConstructionSite constructionSite, Position position, Integer numberOfSquares) {
        this.constructionSite = constructionSite;
        this.position = position;
        this.numberOfSquares = numberOfSquares;
    }

    @Override
    public CommandResult execute() {
        return move(position, getNextPositionFunc(position.getFacing()), numberOfSquares);
    }

    private CommandResult move(Position currentPosition, Function<Position, Position> nextPositionFunc, Integer steps) {
        Position nextPosition = nextPositionFunc.apply(currentPosition);

        if (!constructionSite.isOnSite(nextPosition)) {
            return new CommandResult(currentPosition, 0, CommandState.BEYOND_BOUNDARIES);
        }

        AbstractBlock block = getBlock(nextPosition);
        Integer cost = block.cost();
        CommandState state = block.getClass() == PreservedTree.class ? CommandState.REMOVE_PRESERVED_TREE : CommandState.SUCCESS;

        constructionSite.getBlocks()[nextPosition.getyDimension()][nextPosition.getxDimension()] = new VisitedBlock();

        if (state == CommandState.REMOVE_PRESERVED_TREE || steps == 1) {
            return new CommandResult(nextPosition, cost, state);
        }

        CommandResult nextMoveResult = move(nextPosition, nextPositionFunc, steps - 1);
        return new CommandResult(nextPosition, cost + nextMoveResult.getCost(), nextMoveResult.getCommandState());
    }

    private AbstractBlock getBlock(Position position) {
        return constructionSite.getBlocks()[position.getyDimension()][position.getxDimension()];
    }

    private Function<Position, Position> getNextPositionFunc(Facing facing) {
        switch (facing) {
            case EAST: {
                return (Position p) -> new Position(p.getxDimension() + 1, p.getyDimension(), p.getFacing());
            }
            case NORTH: {
                return (Position p) -> new Position(p.getxDimension(), p.getyDimension() - 1, p.getFacing());
            }
            case WEST: {
                return (Position p) -> new Position(p.getxDimension() - 1, p.getyDimension(), p.getFacing());
            }
            default: {
                return (Position p) -> new Position(p.getxDimension(), p.getyDimension() + 1, p.getFacing());
            }
        }
    }
}
