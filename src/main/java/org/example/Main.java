package org.example;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BookCatalog catalog = new BookCatalog();

    public static void main(String[] args) {
        System.out.println("Betöltött könyvek: ");
        catalog.listBooks();

        while (true) {
            System.out.println("\nFőmenü:");
            System.out.println("1. Könyv hozzáadása");
            System.out.println("2. Könyv törlése");
            System.out.println("3. Könyvek listázása");
            System.out.println("4. Könyv keresése");
            System.out.println("5. Kilépés");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> catalog.listBooks();
                case 4 -> searchBook();
                case 5 -> {
                    System.out.println("Kilépés...");
                    return;
                }
                default -> System.out.println("Érvénytelen választás!");
            }
        }
    }

    private static void addBook() {
        System.out.print("Cím: ");
        String title = scanner.nextLine();

        System.out.print("Szerző(k) (vesszővel elválasztva): ");
        Set<String> authors = new HashSet<>(Arrays.asList(scanner.nextLine().split(",")));

        System.out.print("Kiadási év: ");
        int year = scanner.nextInt();

        System.out.print("Ár: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Book book = new Book(title, authors, year, price);
        catalog.addBook(book);
        System.out.println("Könyv hozzáadva!");
    }

    private static void removeBook() {
        System.out.print("Törlendő könyv ID: ");
        int id = scanner.nextInt();
        catalog.removeBook(id);
        System.out.println("Könyv törölve!");
    }

    private static void searchBook() {
        System.out.print("Keresési kulcsszó: ");
        String keyword = scanner.nextLine();
        List<Book> results = catalog.searchBooks(keyword);
        results.forEach(book -> System.out.println(book.getItemInfo()));
    }
}