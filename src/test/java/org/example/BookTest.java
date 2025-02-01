package org.example;

import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testBookCreation() {
        Set<String> authors = Set.of("J.K. Rowling");
        Book book = new Book("Harry Potter", authors, 1997, 3500.0);

        assertEquals("Harry Potter", book.getTitle());
        assertEquals(authors, book.getAuthors());
        assertEquals(1997, book.getPublicationYear());
        assertEquals(3500.0, book.getPrice());
    }

    @Test
    void testBookCompareTo() {
        Book book1 = new Book("A könyv", Set.of("Író"), 2020, 5000);
        Book book2 = new Book("B könyv", Set.of("Másik Író"), 2019, 4000);

        assertTrue(book1.compareTo(book2) < 0);
    }

    @Test
    void testGetItemInfo() {
        Book book = new Book("Sample Book", Set.of("Author1", "Author2"), 2000, 2500);
        String expectedInfo = "ID: " + book.getId() + ", Cím: Sample Book, Szerzők: [Author1, Author2], Kiadási év: 2000, Ár: 2500.0 HUF";

        assertEquals(expectedInfo, book.getItemInfo());
    }
}