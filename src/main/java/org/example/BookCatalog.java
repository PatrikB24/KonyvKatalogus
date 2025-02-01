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
        bookMap.values().forEach(bookList -> bookList.removeIf(book -> book.getId() == id));
    }

    public List<Book> searchBooks(String keyword) {
        return bookMap.getOrDefault(keyword.toLowerCase(), Collections.emptyList());
    }

    public void listBooks() {
        books.forEach(book -> System.out.println(book.getItemInfo()));
    }
}