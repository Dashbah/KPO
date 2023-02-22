import models.Storage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class Storage_Test {
    Storage storage;

    Storage_Test() {
        storage = new Storage();
        storage.addToStorageRandomElements();
        var books = storage.getAllBooks();
        for (int i = 0; i < books.size(); i += 2) {
            storage.getBook(books.get(i));
        }
    }

    @Test
    void findAllBooks_ShouldFindAllExistingBooksByCaption() {
        var books = storage.getAllBooks();
        for (var book : books) {
            if (storage.findAllBooks(book.getCaption()).isEmpty()) {
                fail();
            }
        }
    }

    @Test
    void findAllTakenBooks_ShouldFindAllExistingBooksByCaption() {
        var books = storage.getTakenBooks();
        for (var book : books) {
            if (storage.findAllBooksFromTaken(book.getCaption()).isEmpty()) {
                fail();
            }
        }
    }


}
