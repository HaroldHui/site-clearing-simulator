package com.shu.report;

public class CostReport {
    private final String item;
    private final Integer quantity;
    private final Integer cost;

    public CostReport(String item, Integer quantity, Integer cost) {
        this.item = item;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String getItem() {
        return item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getCost() {
        return cost;
    }
}
