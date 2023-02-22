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
    public List<Book> findAllBooks(String caption) {
        List<Book> res = new ArrayList<>();
        for (Book book : freeBooks) {
            if (book.getCaption().equals(caption)) {
                res.add(book);
            }
        }
        return res;
    }

    /**
     * finds all taken books with provided caption
     * complexity O(n)
     */
    public List<Book> findAllBooksFromTaken(String caption) {
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
    public void getBook(Book book) {
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
    public void putBook(Book book) {
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
    public void addToStorageRandomElements() {
        Random rnd = new Random();
        int numOfBooks = rnd.nextInt(15) + 3;
        for (int i = 0; i < numOfBooks; ++i) {
            var newBook = new Book();
            newBook.generateRandomBook();
            freeBooks.add(newBook);
        }
    }
}
