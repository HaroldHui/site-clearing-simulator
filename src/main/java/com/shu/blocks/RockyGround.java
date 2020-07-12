package com.shu.blocks;

import com.shu.costs.FuelCost;

import java.util.List;

public class RockyGround extends Block {
    public RockyGround() {
        super(List.of(
                new FuelCost(),
                new FuelCost()
        ));
    }

    @Override
    public String toString() {
        return "r";
    }
}
