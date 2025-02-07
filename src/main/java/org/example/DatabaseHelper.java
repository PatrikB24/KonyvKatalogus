package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
/**
 * A DatabaseHelper osztály felelős az adatbáziskapcsolat kezeléséért.
 */
public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/konyvkatalogus";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void saveBook(Book book) {
        String sql = "INSERT INTO books (title, authors, year, price) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, String.join(",", book.getAuthors()));
            stmt.setInt(3, book.getPublicationYear());
            stmt.setDouble(4, book.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Set<Book> loadBooks() {
        Set<Book> books = new HashSet<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String title = rs.getString("title");
                Set<String> authors = new HashSet<>(Set.of(rs.getString("authors").split(",")));
                int year = rs.getInt("year");
                int price = rs.getInt("price");
                books.add(new Book(title, authors, year, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}