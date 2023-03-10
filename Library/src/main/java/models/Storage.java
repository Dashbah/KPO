package models;

import java.util.*;

/**
 * contains list of free books
 * and list of taken books
 */
public class Storage {
    private final List<Book> freeBooks;
    private final List<Book> takenBooks;

    public Storage() {
        freeBooks = new ArrayList<>();
        takenBooks = new ArrayList<>();
    }

    /**
     * finds all free books with provided caption
     * complexity O(n)
     */
    public List<Book> findAllBooksByCaption(String caption) {
        List<Book> res = new ArrayList<>();
        for (Book book : freeBooks) {
            if (book.getCaption().equals(caption)) {
                res.add(book);
            }
        }
        return res;
    }

    public void addNewBookToStorage(Book book) {
        if (book != null) {
            freeBooks.add(book);
        } else {
            throw new NullPointerException();
        }
    }

    public void addBookToTakenBooksList(Book book) {
        takenBooks.add(book);
    }
    /**
     * finds all taken books with provided caption
     * complexity O(n)
     */
    public List<Book> findAllBooksFromTakenByCaption(String caption) {
        List<Book> res = new ArrayList<>();
        for (Book takenBook : takenBooks) {
            if (takenBook.getCaption().equals(caption)) {
                res.add(takenBook);
            }
        }
        return res;
    }

    /**
     * moves a book from freeBooks to takenBooks
     * if there is no such book ->
     * throws NullPointerException("no such book");
     */
    public void getBookFromStorage(Book book) {
        if (freeBooks.contains(book)) {
            takenBooks.add(book);
            freeBooks.remove(book);
        } else {
            throw new NullPointerException("no such book");
        }
    }

    /**
     * moves a book from takenBooks to freeBooks
     * if there is no such book ->
     * throws NullPointerException("no such book");
     */
    public void putBookToStorage(Book book) {
        if (takenBooks.contains(book)) {
            freeBooks.add(book);
            takenBooks.remove(book);
        } else {
            throw new NullPointerException("no such book");
        }
    }

    /**
     * @return freeBooks
     */
    public List<Book> getAllBooks() {
        return freeBooks;
    }

    /**
     * @return takenBooks
     */
    public List<Book> getTakenBooks() {
        return takenBooks;
    }

    /**
     * add to freeBooks new books
     * num of books = [3, 17]
     * new book is generated with a help of
     * Book::generateRandomBook()
     */
    public void addToStorageRandomBooks(Integer numOfBooks) {
        for (int i = 0; i < numOfBooks; ++i) {
            var newBook = new Book();
            newBook.generateRandomBook();
            freeBooks.add(newBook);
        }
    }
}
