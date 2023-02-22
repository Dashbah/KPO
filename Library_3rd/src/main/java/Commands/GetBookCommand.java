package Commands;

import controllers.Parser;
import models.Storage;

/**
 * command to get the element from storage
 */
public class GetBookCommand implements Command {
    String caption;

    /**
     * @param caption name of a book that should be found
     */
    public GetBookCommand(String caption) {
        this.caption = caption;
    }

    /**
     * gets the list of the books with such caption
     * if there are no books - write about it to console and returns
     * 1 book - takes it and write about it to console
     * >=2 books - asks to choose which one to take
     */
    @Override
    public void execute(Storage storage) {
        var books = storage.findAllBooks(caption);
        switch (books.size()) {
            case 0 -> {
                System.out.println("No such book");
                break;
            }
            case 1 -> {
                storage.getBook(books.get(0));
                System.out.println("you got: " + books.get(0));
            }
            default -> {
                System.out.println("Here are variants:");
                for (int i = 0; i < books.size(); ++i) {
                    System.out.println(i + " " + books.get(i));
                }
                System.out.println("Choose the book (enter it's id)");
                var numberOfTheBook = Parser.intParser(0, books.size() - 1);
                storage.getBook(books.get(numberOfTheBook));
                System.out.println("you got: " + books.get(numberOfTheBook));
                break;
            }
        }
    }
}
