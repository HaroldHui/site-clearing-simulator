package com.shu.blocks;

import com.shu.costs.FuelCost;

import java.util.List;

public class VisitedBlock extends Block {
    public VisitedBlock() {
        super(List.of(new FuelCost()));
    }

    @Override
    public String toString() {
        return "V";
    }
}
