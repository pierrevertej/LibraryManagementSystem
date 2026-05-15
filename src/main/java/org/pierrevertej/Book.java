package org.pierrevertej;

public class Book extends Item {
    private String isbn;
    private String title;
    private String author;
    private String genre;

    public Book(String id, Status status, String isbn, String title, String author, String genre) {
        if (!isValidISBN(isbn)) {
        }
        super(id, status);
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public static boolean isValidISBN(String isbn) {
        return isbn.matches("\\d{13}"); // Must be 13 digits
    }
}
