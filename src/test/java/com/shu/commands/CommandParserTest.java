package com.shu.commands;

import com.shu.ConstructionSite;
import com.shu.Facing;
import com.shu.Position;
import com.shu.blocks.AbstractBlock;
import com.shu.blocks.PlainLand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CommandParserTest {

    private final Position position = new Position(0, 0, Facing.NORTH);
    private final AbstractBlock[][] blocks = {{new PlainLand()}};
    private final ConstructionSite constructionSite = new ConstructionSite(blocks);

    @Test
    @DisplayName("When get a Right command, it should parse it to a RightCommand")
    void parseRightCommand() {
        Command actualCommand = CommandParser.parse("Right", position, constructionSite);

        assertThat(actualCommand).isInstanceOf(RightCommand.class);
    }

    @Test
    @DisplayName("When get a Left command, it should parse it to a LeftCommand")
    void parseLeftCommand() {
        Command actualCommand = CommandParser.parse("Left", position, constructionSite);

        assertThat(actualCommand).isInstanceOf(LeftCommand.class);
    }

    @Test
    @DisplayName("When get a Quit command, it should parse it to a QuitCommand")
    void parseQuitCommand() {
        Command actualCommand = CommandParser.parse("Quit", position, constructionSite);

        assertThat(actualCommand).isInstanceOf(QuitCommand.class);
    }

    @Test
    @DisplayName("When get a correct Advance command, it should parse it to a AdvanceCommand")
    void parseAdvanceCommandSuccess() {
        Command actualCommand = CommandParser.parse("Advance 12", position, constructionSite);

        assertThat(actualCommand).isInstanceOf(AdvanceCommand.class);
    }

    @Test
    @DisplayName("When get an advance command with invalid number, it should parse it to a InvalidCommand")
    void parseAdvanceCommandInvalid() {
        Command actualCommand = CommandParser.parse("Advance 1a", position, constructionSite);

        assertThat(actualCommand).isInstanceOf(InvalidCommand.class);
    }

    @Test
    @DisplayName("When get an invalid command, it should parse it to a InvalidCommand")
    void parseInvalidCommand() {
        Command actualCommand = CommandParser.parse("Something", position, constructionSite);

        assertThat(actualCommand).isInstanceOf(InvalidCommand.class);
    }

    @Test
    @DisplayName("When get a null command, it should parse it to a InvalidCommand")
    void parseEmptyCommand() {
        Command actualCommand = CommandParser.parse(null, position, constructionSite);

        assertThat(actualCommand).isInstanceOf(InvalidCommand.class);
    }
}