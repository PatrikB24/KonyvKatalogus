package org.example;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * Az Item osztály egy absztrakt osztály, amely egy katalógusban szereplő elemet reprezentál.
 * Minden elem rendelkezik egy egyedi azonosítóval és címmel.
 */
public abstract class Item implements CatalogItem {
    private static final AtomicInteger idGenerator = new AtomicInteger(0);
    private final int id;
    private String title;


    /**
     * Létrehoz egy új Item példányt egyedi azonosítóval és megadott címmel.
     *
     */
    public Item(String title) {
        this.id = idGenerator.incrementAndGet();
        this.title = title;
    }
    /**
     * Visszaadja az elem egyedi azonosítóját.
     *
     * @return Az elem azonosítója.
     */
    public int getId() {
        return id;
    }
    /**
     * Visszaadja az elem címét.
     *
     * @return Az elem címe.
     */
    public String getTitle() {
        return title;
    }
    /**
     * Beállítja az elem új címét.
     *
     * @param title Az új cím.
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Visszaadja az elem információit szöveges formátumban.
     *
     * @return Az elem információi.
     */
    @Override
    public String getItemInfo() {
        return "ID: " + id + ", Cím: " + title;
    }
    /**
     * Ellenőrzi, hogy az elem címe tartalmazza-e a keresett kulcsszót.
     *
     * keyword A keresett kulcsszó.
     * @return {true}, ha a kulcsszó szerepel a címben, különben {false}.
     */
    @Override
    public boolean matches(String keyword) {
        return title.toLowerCase().contains(keyword.toLowerCase());
    }
}