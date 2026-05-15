import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pierrevertej.Book;
import org.pierrevertej.InvalidISBNException;

public class BookTest {
    @DisplayName("Book: '1234' -> InvalidISBNException")
    @Test
    void testBook1() {
        Assertions.assertThrows(InvalidISBNException.class,
                () -> new Book("1234", "Linux", "Linus Torvalds", "Tutorial"));
    }

    @DisplayName("Book: 'abcdefghijklm' -> InvalidISBNException")
    @Test
    void testBook2() {
        Assertions.assertThrows(InvalidISBNException.class,
                () -> new Book("abcdefghijklm", "Linux", "Linus Torvalds", "Tutorial"));
    }

    @DisplayName("Book: 'A234567890123' -> InvalidISBNException")
    @Test
    void testBook3() {
        Assertions.assertThrows(InvalidISBNException.class,
                () -> new Book("A234567890123", "Linux", "Linus Torvalds", "Tutorial"));
    }

    @DisplayName("Book: '1234567890123' -> ")
    @Test
    void testBook4() {
        Assertions.assertDoesNotThrow(() -> new Book("1234567890123", "Linux", "Linus Torvalds", "Tutorial"));
    }
}
