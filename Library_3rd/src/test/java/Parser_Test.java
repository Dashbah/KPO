import Commands.GetBookCommand;
import Commands.PutBookCommand;
import Commands.ShowAllItemsCommand;
import Commands.ShowTakenBooksCommand;
import controllers.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Parser_Test {
    @Test
    void Parser_CommandStartsWithGet_returnsGetBookCommand() {
        assertEquals(Parser.parseCommand("/get something") instanceof GetBookCommand, true);
    }
    @Test
    void Parser_CommandStartsWithPut_returnsPutBookCommand() {
        assertEquals(Parser.parseCommand("/put something") instanceof PutBookCommand, true);
    }
    @Test
    void Parser_CommandStartsWithAll_returnsShowAllItemsCommand() {
        assertEquals(Parser.parseCommand("/all") instanceof ShowAllItemsCommand, true);
    }
    @Test
    void Parser_CommandStartsWithAll_returnsShowTakenBooksCommand() {
        assertEquals(Parser.parseCommand("/list") instanceof ShowTakenBooksCommand, true);
    }
    @Test
    void Parser_WrongCommand_throwsIllegalArgumentException() {
        try {
            Parser.parseCommand("/wrong command");
            fail();
        } catch (IllegalArgumentException ex) {
            assertEquals(ex.getMessage(), "no such command!");
            return;
        }
        fail();
    }
    @Test
    void Parser_GetCommandWithoutName_throwsIllegalArgumentException() {
        try {
            Parser.parseCommand("/get3");
            fail();
        } catch (IllegalArgumentException ex) {
            assertEquals(ex.getMessage(), "no such command!");
            return;
        }
        fail();
    }
    @Test
    void Parser_PutCommandWithoutName_throwsIllegalArgumentException() {
        try {
            Parser.parseCommand("/put3");
            fail();
        } catch (IllegalArgumentException ex) {
            assertEquals(ex.getMessage(), "no such command!");
            return;
        }
        fail();
    }
}