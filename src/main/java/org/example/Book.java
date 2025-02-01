package org.example;

import java.io.Serializable;
import java.util.Set;

public class Book extends Item implements Comparable<Book>, Serializable {
    private Set<String> authors;
    private int publicationYear;
    private double price;

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

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

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

    @Override
    public String getItemInfo() {
        return super.getItemInfo() + ", Szerzők: " + authors + ", Kiadási év: " + publicationYear + ", Ár: " + price + " HUF";
    }
}