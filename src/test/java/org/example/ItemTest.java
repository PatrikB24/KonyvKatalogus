package org.example;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void testGetTitle() {
        Item item = new Book("Java programozás", Set.of("Szerző1"), 2019, 5000);
        assertEquals("Java programozás", item.getTitle());
    }

    @Test
    void testMatches() {
        Item item = new Book("Java fejlesztés", Set.of("Szerző1"), 2020, 6000);
        assertTrue(item.matches("Java"));
        assertFalse(item.matches("Python"));
    }

    @Test
    void testGetItemInfo() {
        Item item = new Book("Java mesterkurzus", Set.of("Szerző1"), 2021, 7000);
        String expectedInfo = "ID: " + item.getId() + ", Cím: Java mesterkurzus";
        assertEquals(expectedInfo, item.getItemInfo());
    }
}