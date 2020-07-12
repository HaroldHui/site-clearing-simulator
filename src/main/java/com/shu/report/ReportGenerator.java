package com.shu.report;

import com.shu.commands.Command;
import com.shu.costs.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGenerator {

    private final static Map<String, Class> costTypes = Map.of(
            "communication overhead", CommunicationCost.class,
            "fuel usage", FuelCost.class,
            "uncleared squares", UnclearedSquareCost.class,
            "destruction of protected tree", DestructionProtectedTreeCost.class,
            "paint damage to bulldozer", RepairingDamageCost.class
    );

    public static String generateReport(List<Command> commands, List<Cost> costs) {
        StringBuffer sb = new StringBuffer();

        sb.append("These are the commands you issued:");
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append(commands.stream().map(Command::toString).collect(Collectors.joining(", ")));
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());

        generateCostReport(costs, sb);

        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append("Thankyou for using the Aconex site clearing simulator.");
        return sb.toString();
    }

    private static void generateCostReport(List<Cost> costs, StringBuffer sb) {
        sb.append("The costs for this land clearing operation were:");
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append(String.format("%-30.30s%15.15s%10.10s", "Item", "Quantity", "Cost"));
        transformCosts(costs).forEach(costReport -> {
            sb.append(System.lineSeparator());
            sb.append(String.format(
                    "%-30.30s%15.15s%10.10s",
                    costReport.getItem(),
                    costReport.getQuantity(),
                    costReport.getCost()
            ));
        });

        sb.append(System.lineSeparator());
        sb.append("----");
        sb.append(System.lineSeparator());
        sb.append(String.format("%-45.45s%10.10s", "Total", calculateCost(costs)));
    }

    private static List<CostReport> transformCosts(List<Cost> costs) {
        return costTypes.entrySet().stream()
                .map(entry -> {
                    String item = entry.getKey();
                    Class costClass = entry.getValue();
                    List<Cost> itemizeCosts = costs.stream().filter(cost -> cost.getClass() == costClass).collect(Collectors.toList());
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
