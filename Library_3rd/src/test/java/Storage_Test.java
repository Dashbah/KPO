import models.Book;
import models.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {

    private Storage storage;

    @BeforeEach
    void setUp() {
        storage = new Storage();
    }

    @Test
    void findAllBooksByCaption_TwoDifferentBooks_FindsTwoCorrect() {
        Book book1 = new Book("Title1", Collections.singletonList("Author1"), 1900);
        Book book2 = new Book("Title2", Collections.singletonList("Author2"), 1901);
        Book book3 = new Book("Title1", Collections.singletonList("Author3"), 1902);

        storage.getAllBooks().add(book1);
        storage.getAllBooks().add(book2);
        storage.getAllBooks().add(book3);

        List<Book> booksByCaption = storage.findAllBooksByCaption("Title1");

        assertEquals(2, booksByCaption.size());
        assertTrue(booksByCaption.contains(book1));
        assertTrue(booksByCaption.contains(book3));
    }

    @Test
    void findAllBooksFromTakenByCaption_TwoDifferentBooks_FindsTwoCorrect() {
        Book book1 = new Book("Title1", Collections.singletonList("Author1"), 1900);
        Book book2 = new Book("Title2", Collections.singletonList("Author2"), 1901);
        Book book3 = new Book("Title1", Collections.singletonList("Author3"), 1902);

        storage.getTakenBooks().add(book1);
        storage.getTakenBooks().add(book2);
        storage.getTakenBooks().add(book3);

        List<Book> takenBooksByCaption = storage.findAllBooksFromTakenByCaption("Title1");

        assertEquals(2, takenBooksByCaption.size());
        assertTrue(takenBooksByCaption.contains(book1));
        assertTrue(takenBooksByCaption.contains(book3));
    }

    @Test
    void addNewBookToStorage() {
        Book book = new Book("Title", Collections.singletonList("Author"), 1900);

        storage.addNewBookToStorage(book);

        List<Book> result = storage.getAllBooks();

        assertEquals(1, result.size());
        assertEquals(book, result.get(0));
    }


    @Test
    void getBookFromStorage() {
        Book book1 = new Book("Title1", Collections.singletonList("Author1"), 1900);
        Book book2 = new Book("Title2", Collections.singletonList("Author2"), 1901);

        storage.addNewBookToStorage(book1);
        storage.addNewBookToStorage(book2);
        ;

        storage.getBookFromStorage(book1);

        assertFalse(storage.getAllBooks().contains(book1));
        assertTrue(storage.getTakenBooks().contains(book1));
    }

    @Test
    void getBookFromStorage_NoSuchBook_NullPointerException() {
        assertThrows(NullPointerException.class, () -> storage.getBookFromStorage(new Book()));
    }

    @Test
    void putBookToStorage() {
        Book book1 = new Book("Title1", Collections.singletonList("Author1"), 1900);

        storage.addBookToTakenBooksList(book1);

        // assertThrows(NullPointerException.class, () -> storage.putBookToStorage(new Book()));

        assertFalse(storage.getTakenBooks().contains(book1));
        assertTrue(storage.getAllBooks().contains(book1));
    }

    @Test
    void putBookToStorage_BookWasNotTaken_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> storage.putBookToStorage(new Book()));
    }

    @Test
    void getAllBooks() {
        Book book1 = new Book("Title1", Collections.singletonList("Author1"), 1900);
        Book book2 = new Book("Title2", Collections.singletonList("Author2"), 1901);

        storage.addNewBookToStorage(book1);
        storage.addNewBookToStorage(book2);

        List<Book> allBooks = storage.getAllBooks();

        assertEquals(2, allBooks.size());
        assertTrue(allBooks.contains(book1));
        assertTrue(allBooks.contains(book2));
        assertFalse(allBooks.contains(new Book()));
    }

    @Test
    void getTakenBooks() {
        Book book1 = new Book("Title1", Collections.singletonList("Author1"), 1900);
        Book book2 = new Book("Title2", Collections.singletonList("Author2"), 1901);

        storage.addBookToTakenBooksList(book1);
        storage.addBookToTakenBooksList(book2);

        List<Book> takenBooks = storage.getTakenBooks();

        assertEquals(2, takenBooks.size());
        assertTrue(takenBooks.contains(book1));
        assertTrue(takenBooks.contains(book2));
        assertFalse(takenBooks.contains(new Book()));
    }

    @Test
    void addToStorageRandomBooks() {
        int numOfBooksToAdd = 5;

        storage.addToStorageRandomBooks(numOfBooksToAdd);

        assertEquals(numOfBooksToAdd, storage.getAllBooks().size());
        for (var book : storage.getAllBooks()) {
            assertNotNull(book);
        }
    }
}