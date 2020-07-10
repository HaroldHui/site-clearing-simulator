package com.shu;

import com.shu.blocks.AbstractBlock;

public class ConstructionSite {
    private AbstractBlock[][] blocks;
    private final Integer xDimensionLength;
    private final Integer yDimensionLength;

    public ConstructionSite(AbstractBlock[][] blocks) {
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

    public AbstractBlock[][] getBlocks() {
        return blocks;
    }
}
