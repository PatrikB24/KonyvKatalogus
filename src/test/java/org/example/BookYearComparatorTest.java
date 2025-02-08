package org.example;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BookYearComparatorTest {

    @Test
    void testCompare() {
        Book book1 = new Book("Java alapok", Set.of("Szerző1"), 2018, 6000);
        Book book2 = new Book("Haladó Java", Set.of("Szerző2"), 2020, 6500);

        Comparator<Book> comparator = new BookYearComparator();
        assertTrue(comparator.compare(book1, book2) < 0);
        assertTrue(comparator.compare(book2, book1) > 0);
        assertEquals(0, comparator.compare(book1, new Book("Másik Java", Set.of("Szerző3"), 2018, 5500)));
    }
}