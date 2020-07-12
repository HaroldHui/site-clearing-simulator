package com.shu.report;

import com.shu.commands.Command;
import com.shu.costs.Cost;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGenerator {

    public static String generateReport(List<Command> commands, List<Cost> costs) {
        StringBuffer sb = new StringBuffer();
        sb.append("The costs for this land clearing operation were:");
        sb.append(System.lineSeparator());
        sb.append(String.format("%-30.30s%15.15s%10.10s", "Item", "Quantity", "Cost"));
        getCostReport(costs).forEach(costReport -> {
            sb.append(System.lineSeparator());
            sb.append(String.format(
                    "%-30.30s%15.14d%10.10d",
                    costReport.getItem(),
                    costReport.getQuantity(),
                    costReport.getCost()
            ));
        });

        sb.append(System.lineSeparator());
        sb.append("----");
        sb.append(String.format("%-45.45s%10.10d", "Total", calculateCost(costs)));

        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append("Thankyou for using the Aconex site clearing simulator.");

        return sb.toString();
    }

    public static List<CostReport> getCostReport(List<Cost> costs) {
        return costs.stream()
                .collect(Collectors.groupingBy(Cost::getName))
                .entrySet().stream()
                .map(entry -> {
                    String item = entry.getKey();
                    List<Cost> itemizeCosts = entry.getValue();
                    int cost = itemizeCosts.stream().mapToInt(Cost::getCostCredit).sum();
                    return new CostReport(item, itemizeCosts.size(), cost);
                }).collect(Collectors.toList());
    }

    public static Integer calculateCost(List<Cost> costs) {
        return costs.stream().map(Cost::getCostCredit)
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
