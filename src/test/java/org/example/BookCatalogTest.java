package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class BookCatalogTest {
    private BookCatalog catalog;
    private Book book1, book2;

    @BeforeEach
    void setUp() {
        catalog = new BookCatalog();
        book1 = new Book("Java kezdőknek", Set.of("Szerző1"), 2021, 5500);
        book2 = new Book("Haladó Java", Set.of("Szerző2"), 2018, 7200);

        catalog.addBook(book1);
        catalog.addBook(book2);
    }

    @Test
    void testAddBook() {
        Book newBook = new Book("Spring Boot", Set.of("Szerző3"), 2022, 6000);
        catalog.addBook(newBook);

        List<Book> books = catalog.searchBooks("Spring Boot");
        assertFalse(books.isEmpty());
        assertEquals("Spring Boot", books.get(0).getTitle());
    }

    @Test
    void testRemoveBook() {
        catalog.removeBook(book1.getId());
        List<Book> books = catalog.searchBooks("Java kezdőknek");

        assertTrue(books.isEmpty());
    }

    @Test
    void testSearchBook() {
        List<Book> result = catalog.searchBooks("Haladó Java");
        assertFalse(result.isEmpty());
        assertEquals("Haladó Java", result.get(0).getTitle());
    }

    @Test
    void testListBooks() {
        assertEquals(2, catalog.getBooks().size());
    }

    @Test
    void testEmptyCatalog() {
        catalog = new BookCatalog();
        assertTrue(catalog.getBooks().isEmpty());
    }

    @Test
    void testDuplicateBooks() {
        Book duplicate = new Book("Java kezdőknek", Set.of("Szerző1"), 2021, 5500);
        catalog.addBook(duplicate);
        assertEquals(3, catalog.getBooks().size());
    }
}