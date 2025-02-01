package org.example;

import java.util.Comparator;

/*
  Ár szerinti rendezést biztosító Comparator osztály.
 */
public class BookPriceComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return Double.compare(b1.getPrice(), b2.getPrice());
    }
}