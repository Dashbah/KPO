package Commands;

import controllers.Parser;
import models.Storage;

/**
 * command to put back the element to storage
 */
public class PutBookCommand implements Command {
    String caption;

    /**
     * @param caption name of a book that should be returned
     */
    public PutBookCommand(String caption) {
        this.caption = caption;
    }

    /**
     * gets the list of taken books with such caption
     * if there are no books - write about it to console and returns
     * 1 book - returns it and write about it to console
     * >=2 books - asks to choose which one to return
     */
    @Override
    public void execute(Storage storage) {
        var books = storage.findAllBooksFromTakenByCaption(caption);
        switch (books.size()) {
            case 0 -> {
                System.out.println("You didn't take this book");
                break;
            }
            case 1 -> {
                storage.putBookToStorage(books.get(0));
                System.out.println("Thank for returning " + books.get(0));
            }
            default -> {
                System.out.println("Books you have with this caption:");
                for (int i = 0; i < books.size(); ++i) {
                    System.out.println(i + " " + books.get(i));
                }
                System.out.println("Choose the book (enter it's id)");
                var numberOfTheBook = Parser.intParser(0, books.size() - 1);
                storage.putBookToStorage(books.get(numberOfTheBook));
                System.out.println("Thank for returning " + books.get(numberOfTheBook));
            }
        }
    }
}
