package org.example;

import java.util.*;
/**
 * A BookCatalog osztály egy könyv katalógust reprezentál, amely támogatja
 * a könyvek hozzáadását, törlését, keresését és fájlkezelését.
 */
public class BookCatalog {
    private List<Book> books;
    private Map<String, List<Book>> bookMap;
    /**
     * Létrehoz egy új könyvkatalógust és betölti a könyveket a bináris fájlból.
     */
    public BookCatalog() {
        this.books = FileHandler.loadBooksFromBinaryFile();
        this.bookMap = new HashMap<>();
        rebuildBookMap();
    }
    /**
     * Könyv hozzáadása a katalógushoz.
     *
     * book A hozzáadandó könyv.
     */
    public void addBook(Book book) {
        books.add(book);
        book.getAuthors().forEach(author ->
                bookMap.computeIfAbsent(author.toLowerCase(), k -> new ArrayList<>()).add(book));
        saveToFile();
    }
    /**
     * Könyv eltávolítása az azonosító alapján.
     *
     * id A törlendő könyv azonosítója.
     */
    public void removeBook(int id) {
        books.removeIf(book -> book.getId() == id);
        bookMap.entrySet().removeIf(entry -> entry.getValue().removeIf(book -> book.getId() == id));
        saveToFile();
    }
    /**
     * Könyvek keresése egy adott kulcsszó alapján.
     *
     * keyword A keresési kulcsszó.
     * return Az egyező könyvek listája.
     */
    public List<Book> searchBooks(String keyword) {
        return bookMap.getOrDefault(keyword.toLowerCase(), Collections.emptyList());
    }
    /**
     * Kiírja a katalógusban található összes könyvet.
     */
    public void listBooks() {
        books.forEach(book -> System.out.println(book.getItemInfo()));
    }

    public List<Book> getBooks() {
        return books;
    }


    private void rebuildBookMap() {
        for (Book book : books) {
            book.getAuthors().forEach(author ->
                    bookMap.computeIfAbsent(author.toLowerCase(), k -> new ArrayList<>()).add(book));
        }
    }

    /**
     * A könyvek mentése fájlba (szöveges és bináris).
     */
    private void saveToFile() {
        FileHandler.saveBooksToTextFile(books);
        FileHandler.saveBooksToBinaryFile(books);
    }
}