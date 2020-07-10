package com.shu.commands;

import com.shu.ConstructionSite;
import com.shu.Position;

public class CommandParser {

    public static Command parse(String command, Position position, ConstructionSite constructionSite) {
        if (null == command || command.isBlank()) {
            return new InvalidCommand(position);
        }
        command = command.trim();
        if (command.equals("Left")) {
            return new LeftCommand(position);
        }
        if (command.equals("Right")) {
            return new RightCommand(position);
        }
        if (command.startsWith("Advance")) {
            String numberOfSquares = command.replace("Advance", "").trim();
            try {
                return new AdvanceCommand(constructionSite,position,Integer.parseInt(numberOfSquares));
            } catch (NumberFormatException e) {
                return new InvalidCommand(position);
            }
        }
        if(command.equals("Quit")) {
            return new QuitCommand(position);
        }
        return new InvalidCommand(position);
    }
}
