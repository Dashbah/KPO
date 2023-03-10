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
        assertTrue(Parser.parseCommand("/get something") instanceof GetBookCommand);
    }
    @Test
    void Parser_CommandStartsWithPut_returnsPutBookCommand() {
        assertTrue(Parser.parseCommand("/put something") instanceof PutBookCommand);
    }
    @Test
    void Parser_CommandStartsWithAll_returnsShowAllItemsCommand() {
        assertTrue(Parser.parseCommand("/all") instanceof ShowAllItemsCommand);
    }
    @Test
    void Parser_CommandStartsWithAll_returnsShowTakenBooksCommand() {
        assertTrue(Parser.parseCommand("/list") instanceof ShowTakenBooksCommand);
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