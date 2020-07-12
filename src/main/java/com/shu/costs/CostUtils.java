package com.shu.costs;

import java.util.List;

public class CostUtils {
    public static Integer calculateCredits(List<Cost> costs) {
        return costs.stream().map(Cost::getCostCredit)
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
