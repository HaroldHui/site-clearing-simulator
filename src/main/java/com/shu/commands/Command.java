package com.shu.commands;

import com.shu.costs.CommunicationCost;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Command {

    public CommandResult execute() {
        CommandResult commandResult = executeCommand();
        return new CommandResult(commandResult.getPosition(),
                Stream.of(Collections.singletonList(new CommunicationCost()), commandResult.getCosts())
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList()),
                commandResult.getCommandState());
    }

    protected abstract CommandResult executeCommand();


}
