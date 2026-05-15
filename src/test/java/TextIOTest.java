import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pierrevertej.*;
import util.Constants;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Testing for textIO functions in Admin.java and Library.java (backup and load)
 */

public class TextIOTest {
    @Test
    void testItems() {
        try (PrintWriter writer = new PrintWriter(Constants.BOOKS_CSV_PATH)) {
            // empties the file
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Library.setItems(new ArrayList<>());
        Admin admin = new Admin();
        Item o1 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item o2 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item o3 = new Magazine("Richest People in the World", "Vol. 2", "Time");
        Item o4 = new DVD("Dune", "Villeneuve", 155);
        List<Item> expected = new ArrayList<>(Library.getItems());
        admin.backup();
        Library.loadData();
        List<Item> actual = Library.getItems();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testUsers() { // Run with both csv files emptied
        try (PrintWriter writer = new PrintWriter(Constants.BOOKS_CSV_PATH)) {
            // empties the file
        } catch (IOException e) {
            throw new RuntimeException(e);
        }try (PrintWriter writer = new PrintWriter(Constants.USERS_CSV_PATH)) {
            // empties the file
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Library.setItems(new ArrayList<>());
        Library.setUsers(new ArrayList<>());
        Admin admin = new Admin();
        Item o1 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item o2 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item o3 = new Magazine("Richest People in the World", "Vol. 2", "Time");
        Item o4 = new DVD("Dune", "Villeneuve", 155);
        User student = new Student("Jade");
        User teacher = new Teacher("Yi");
        teacher.borrowItem(o1);teacher.borrowItem(o3);teacher.borrowItem(o4);
        student.borrowItem(o2);
        List<User> expected = new ArrayList<>(Library.getUsers());
        admin.backup();
        Library.loadData();
        List<User> actual = Library.getUsers();
        Assertions.assertEquals(expected, actual);
    }
}
