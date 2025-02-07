package org.example;

import java.io.Serializable;
import java.util.Set;


/**
 * A Book osztály egy könyvet reprezentál a katalógusban.
 * Egy könyvnek van címe, szerzői, kiadási éve és ára.
 */
public class Book extends Item implements Comparable<Book>, Serializable {
    private Set<String> authors;
    private int publicationYear;
    private double price;
    /**
     * Létrehoz egy új {@code Book} példányt a megadott adatokkal.
     *
     */
    public Book(String title, Set<String> authors, int publicationYear, double price) {
        super(title);
        this.authors = authors;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    @Override
    public int compareTo(Book other) {
        return this.getTitle().compareToIgnoreCase(other.getTitle());
    }
    /**
     * Visszaadja a könyv szerzőinek listáját.
     *
     * return A szerzők halmaza.
     */
    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }
    /**
     * Visszaadja a könyv kiadási évét.
     *
     * return A kiadási év.
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    /**
     * Visszaadja a könyv árát.
     *
     * return A könyv ára.
     */
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getItemInfo();
    }
    /**
     * A könyv információit adja vissza szöveges formátumban.
     *
     * return A könyv adatai egy formázott szövegben.
     */
    @Override
    public String getItemInfo() {
        return super.getItemInfo() + ", Szerzők: " + authors + ", Kiadási év: " + publicationYear + ", Ár: " + price + " HUF";
    }
}