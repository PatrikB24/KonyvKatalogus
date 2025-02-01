package org.example;

import java.util.Comparator;

/*
  Kiadási év szerinti rendezést biztosító Comparator osztály.
 */
public class BookYearComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return Integer.compare(b1.getPublicationYear(), b2.getPublicationYear());
    }
}