package com.shu.blocks;

import com.shu.costs.FuelCost;
import com.shu.costs.RepairingDamageCost;

import java.util.List;

public class RemovableTree extends Block {
    public RemovableTree() {
        super(List.of(
                new FuelCost(),
                new FuelCost(),
                new RepairingDamageCost()
        ));
    }

    @Override
    public String toString() {
        return "t";
    }
}
