package com.shu.blocks;

import com.shu.costs.DestructionProtectedTreeCost;
import com.shu.costs.FuelCost;

import java.util.List;

public class PreservedTree extends Block {
    public PreservedTree() {
        super(List.of(
                new FuelCost(),
                new FuelCost(),
                new DestructionProtectedTreeCost()
        ));
    }

    @Override
    public String toString() {
        return "T";
    }
}
