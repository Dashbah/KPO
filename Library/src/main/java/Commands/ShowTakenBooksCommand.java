package Commands;

import models.Storage;

/**
 * command to show all taken element at storage
 */
public class ShowTakenBooksCommand implements Command {
    /**
     * prints all taken books to console
     */
    @Override
    public void execute(Storage storage) {
        System.out.println("Here are taken books:");
        var takenBooks = storage.getTakenBooks();
        for (var book : takenBooks) {
            System.out.println(book);
        }
    }
}
