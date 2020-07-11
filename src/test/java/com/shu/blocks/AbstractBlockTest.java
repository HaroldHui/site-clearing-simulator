package com.shu.blocks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AbstractBlockTest {

    @Test
    @DisplayName("When visit a block, it should return the correct cost")
    void visitBlockWithCorrectCost() {
        TestBlock block = new TestBlock(5, 5);

        Integer expectedCost = 1 + 5 * 1 + 5;
        Integer actualCost = block.cost();

        assertThat(actualCost).isEqualTo(expectedCost);
    }

    private class TestBlock extends AbstractBlock {
        public TestBlock(Integer fuelUsage, Integer extraCost) {
            super(fuelUsage, extraCost);
        }

        @Override
        public String toString() {
            return "";
        }
    }
}