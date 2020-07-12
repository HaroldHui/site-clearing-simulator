package com.shu;

import com.shu.blocks.Block;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConstructionSite {
    private Block[][] blocks;
    private final Integer xDimensionLength;
    private final Integer yDimensionLength;

    public ConstructionSite(Block[][] blocks) {
        this.blocks = blocks;
        this.xDimensionLength = blocks[0].length;
        this.yDimensionLength = blocks.length;
    }

    public boolean isOnSite(Position position) {
        return between(position.getxDimension(), 0, xDimensionLength - 1)
                && between(position.getyDimension(), 0, yDimensionLength - 1);
    }

    private boolean between(int i, int minValue, int maxValue) {
        return i >= minValue && i <= maxValue;
    }

    public Block[][] getBlocks() {
        return blocks;
    }

    public String toString() {
        return Arrays.stream(blocks)
                .map(lineOfBlocks -> Arrays.stream(lineOfBlocks)
                        .map(Block::toString)
                        .collect(Collectors.joining(" "))
                ).collect(Collectors.joining(System.lineSeparator()));
    }
}
