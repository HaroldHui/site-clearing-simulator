package com.shu.commands;

import com.shu.ConstructionSite;
import com.shu.Position;

public class CommandParser {

    public static Command parse(String command, Position position, ConstructionSite constructionSite) {
        if (null == command || command.isBlank()) {
            return new InvalidCommand(position);
        }
        command = command.trim();
        if (command.equals("l")) {
            return new LeftCommand(position);
        }
        if (command.equals("r")) {
            return new RightCommand(position);
        }
        if (command.startsWith("a")) {
            String numberOfSquares = command.replaceFirst("a", "").trim();
            try {
                return new AdvanceCommand(constructionSite,position,Integer.parseInt(numberOfSquares));
            } catch (NumberFormatException e) {
                return new InvalidCommand(position);
            }
        }
        if(command.equals("q")) {
            return new QuitCommand(position);
        }
        return new InvalidCommand(position);
    }
}
