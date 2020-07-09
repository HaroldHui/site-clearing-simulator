package com.shu.blocks;

public abstract class AbstractBlock {

    private final static Integer FUEL_COST = 1;
    private final static Integer COMMUNICATION_COST = 1;

    protected Integer fuelUsage;
    protected Integer extraCost;

    public AbstractBlock(Integer fuelUsage, Integer extraCost) {
        this.fuelUsage = fuelUsage;
        this.extraCost = extraCost;
    }

    public Integer cost() {
        return COMMUNICATION_COST + fuelUsage * FUEL_COST + extraCost;
    }
}
