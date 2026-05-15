package org.pierrevertej;

import lombok.EqualsAndHashCode;
import lombok.Getter;


@EqualsAndHashCode(callSuper = true)
@Getter
public class Book extends Item {
    private String isbn;
    private String author;
    private String genre;

    public Book(String isbn, String title, String author, String genre) {
        if (!isValidISBN(isbn)) {
            throw new InvalidISBNException("ISBN needs to contain 13 digits");
        }
        super(title);
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
    }

    public Book(String id, String title, Status status, String isbn, String author, String genre) {
        if (!isValidISBN(isbn)) {
            throw new InvalidISBNException("ISBN needs to contain 13 digits");
        }
        super(id, title, status);
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
    }

    /**
     * Checks if the ISBN number is valid (13 digits)
     * @param isbn ISBN
     * @return boolean which indicates the validity of the ISBN number
     */
    public static boolean isValidISBN(String isbn) {
        return isbn.matches("\\d{13}"); // Must be 13 digits
    }

    @Override
    public String toString() {
        return "B," + super.toString()
                + isbn + "," +
                author + "," +
                genre;
    }
}
