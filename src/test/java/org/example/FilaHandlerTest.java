package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    private final Book book1 = new Book("Könyv 1", Set.of("Szerző A"), 2015, 3000);
    private final Book book2 = new Book("Könyv 2", Set.of("Szerző B"), 2018, 4500);

    @BeforeEach
    void setUp() {
        FileHandler.saveBooksToTextFile(List.of(book1, book2));
        FileHandler.saveBooksToBinaryFile(List.of(book1, book2));
    }

    @AfterEach
    void tearDown() {
        new File("books.txt").delete();
        new File("books.dat").delete();
    }

    @Test
    void testSaveAndLoadBooksFromTextFile() {
        List<Book> loadedBooks = FileHandler.loadBooksFromTextFile();
        assertEquals(2, loadedBooks.size());
        assertEquals("Könyv 1", loadedBooks.get(0).getTitle());
        assertEquals("Könyv 2", loadedBooks.get(1).getTitle());
    }

    @Test
    void testSaveAndLoadBooksFromBinaryFile() {
        List<Book> loadedBooks = FileHandler.loadBooksFromBinaryFile();
        assertEquals(2, loadedBooks.size());
        assertEquals("Könyv 1", loadedBooks.get(0).getTitle());
        assertEquals("Könyv 2", loadedBooks.get(1).getTitle());
    }
}