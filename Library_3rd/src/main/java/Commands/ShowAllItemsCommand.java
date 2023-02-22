package Commands;

import models.Storage;

/**
 * command to show all element at storage
 */
public class ShowAllItemsCommand implements Command {
    /**
     * prints all books to console
     */
    @Override
    public void execute(Storage storage) {
        System.out.println("Here are all books we have now:");
        var books = storage.getAllBooks();
        for (var book : books) {
            System.out.println(book);
        }
    }
}