package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FileHandler {

    private static final String TEXT_FILE = "books.txt";
    private static final String BINARY_FILE = "books.dat";

    // Könyvek mentése szöveges fájlba
    public static void saveBooksToTextFile(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEXT_FILE))) {
            for (Book book : books) {
                writer.write(book.getTitle() + ";" + String.join(",", book.getAuthors()) + ";"
                        + book.getPublicationYear() + ";" + book.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Könyvek betöltése szöveges fájlból
    public static List<Book> loadBooksFromTextFile() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TEXT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    String title = parts[0];
                    String[] authorsArray = parts[1].split(",");
                    int year = Integer.parseInt(parts[2]);
                    double price = Double.parseDouble(parts[3]);
                    books.add(new Book(title, Set.of(authorsArray), year, price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Könyvek mentése bináris fájlba
    public static void saveBooksToBinaryFile(List<Book> books) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(BINARY_FILE))) {
            out.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Könyvek betöltése bináris fájlból
    public static List<Book> loadBooksFromBinaryFile() {
        List<Book> books = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(BINARY_FILE))) {
            books = (List<Book>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }
}