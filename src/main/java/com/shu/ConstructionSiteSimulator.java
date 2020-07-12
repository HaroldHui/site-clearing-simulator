package com.shu;

import com.shu.blocks.Block;
import com.shu.blocks.PreservedTree;
import com.shu.blocks.VisitedBlock;
import com.shu.commands.Command;
import com.shu.commands.CommandParser;
import com.shu.commands.CommandResult;
import com.shu.commands.CommandState;
import com.shu.costs.Cost;
import com.shu.costs.UnclearedSquareCost;
import com.shu.report.ReportGenerator;

import java.util.*;

public class ConstructionSiteSimulator {

    private final static List<CommandState> endingEvent = List.of(
            CommandState.QUIT,
            CommandState.INVALID_COMMAND,
            CommandState.BEYOND_BOUNDARIES,
            CommandState.REMOVE_PRESERVED_TREE);

    private final ConstructionSite constructionSite;
    private final Scanner scanner;
    private final List<Cost> costs;
    private final List<Command> commands;
    private Position position;


    public ConstructionSiteSimulator(Block[][] blocks, Scanner scanner) {
        this.constructionSite = new ConstructionSite(blocks);
        this.scanner = scanner;
        this.position = new Position(-1, 0, Facing.EAST);
        this.costs = new ArrayList<>();
        this.commands = new ArrayList<>();
    }

    public void start() {
        System.out.println("Welcome to the Aconex site clearing simulator. This is a map of the site:");
        System.out.println(System.lineSeparator());
        System.out.println(constructionSite.toString());
        System.out.println(System.lineSeparator());
        System.out.println("The bulldozer is currently located at the Northern edge of the site, immediately to the West of the site, and facing East");
        System.out.println(System.lineSeparator());

        while (true) {
            System.out.print("(l)eft, (r)ight, (a)dvance <n>, (q)uit: ");
            String commandString = scanner.nextLine();
            CommandState state = runCommand(commandString);
            if (endingEvent.contains(state)) {
                System.out.print(String.format("The simulation has ended at your request, last command state: %s. ", state.name()));
                break;
            }
        }
        addUnclearedSquaresCost();

        System.out.println(ReportGenerator.generateReport(commands, costs));
        System.out.println("Thankyou for using the Aconex site clearing simulator.");
    }

    private CommandState runCommand(String commandString) {
        Command command = CommandParser.parse(commandString, this.position, this.constructionSite);
        CommandResult commandResult = command.execute();
        this.costs.addAll(commandResult.getCosts());
        this.commands.add(command);
        this.position = commandResult.getPosition();
        return commandResult.getCommandState();
    }

    private void addUnclearedSquaresCost() {
        long unclearedBlocks = Arrays.stream(this.constructionSite.getBlocks())
                .flatMap(Arrays::stream)
                .filter(block -> block.getClass() != VisitedBlock.class && block.getClass() != PreservedTree.class)
                .count();
        costs.addAll(Collections.nCopies(Math.toIntExact(unclearedBlocks), new UnclearedSquareCost()));
    }
}
