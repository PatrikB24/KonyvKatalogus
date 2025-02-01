package org.example;

import java.util.*;

public class BookCatalog {
    private List<Book> books;
    private Map<String, List<Book>> bookMap;

    public BookCatalog() {
        this.books = new ArrayList<>();
        this.bookMap = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        book.getAuthors().forEach(author ->
                bookMap.computeIfAbsent(author.toLowerCase(), k -> new ArrayList<>()).add(book));
    }

    public void removeBook(int id) {
        books.removeIf(book -> book.getId() == id);
        bookMap.entrySet().removeIf(entry -> entry.getValue().removeIf(book -> book.getId() == id));
    }

    public List<Book> searchBooks(String keyword) {
        return bookMap.getOrDefault(keyword.toLowerCase(), Collections.emptyList());
    }

    public void listBooks() {
        books.forEach(book -> System.out.println(book.getItemInfo()));
    }

    public List<Book> getBooks() {
        return books;
    }


    public void saveAllBooksToDatabase() {
        for (Book book : books) {
            DatabaseHelper.saveBook(book);
        }
    }

    public void loadBooksFromDatabase() {
        books.clear();
        books.addAll(DatabaseHelper.loadBooks());
    }


}