package com.shu.blocks;

import com.shu.costs.Cost;

import java.util.List;

public class Block {
    private final List<Cost> costs;

    public Block(List<Cost> costs) {
        this.costs = costs;
    }

    public List<Cost> getCosts() {
        return costs;
    }
}
