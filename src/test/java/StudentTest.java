import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pierrevertej.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentTest {
    @Test
    void testCanBorrowItem1() {
        User student = new Student("Jade");
        Item book = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        boolean actual = student.canBorrowItem(book);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCanBorrowItem2() {
        User student = new Student("Jade");
        Item book = new Book("0001", "Brave New World", Item.Status.BORROWED, "1234567890123", "Aldous Huxley", "dystopian");
        boolean actual = student.canBorrowItem(book);
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCanBorrowItem3() {
        User student = new Student("Jade");
        Item mag = new Magazine("0020", "Richest People in the World", Item.Status.INSTORE, "Vol. 2", "Time");
        boolean actual = student.canBorrowItem(mag);
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCanBorrowItem4() {
        User student = new Student("Jade");
        Item book1 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item book2 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item book3 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item book4 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item book5 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item book6 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        student.borrowItem(book1);student.borrowItem(book2);student.borrowItem(book3);student.borrowItem(book4);student.borrowItem(book5);
        boolean actual = student.canBorrowItem(book6);
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testBorrowItem1() {
        User student = new Student("Jade");
        Item book = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        student.borrowItem(book);
        List<Item> actual = student.getBorrowedItems();
        List<Item> expected = new ArrayList<>(Arrays.asList(book));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testBorrowItem2() {
        User student = new Student("Jade");
        Item mag = new Magazine("0020", "Richest People in the World", Item.Status.INSTORE, "Vol. 2", "Time");
        student.borrowItem(mag);
        List<Item> actual = student.getBorrowedItems();
        List<Item> expected = new ArrayList<>();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testReturnItem1() {
        User student = new Student("Jade");
        Item book = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        student.borrowItem(book);
        student.returnItem(book);
        List<Item> actual = student.getBorrowedItems();
        List<Item> expected = new ArrayList<>();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testReturnItem2() {
        User student = new Student("Jade");
        Item book = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item mag = new Magazine("0020", "Richest People in the World", Item.Status.INSTORE, "Vol. 2", "Time");
        student.borrowItem(book);
        student.returnItem(mag);
        List<Item> actual = student.getBorrowedItems();
        List<Item> expected = new ArrayList<>(Arrays.asList(book));
        Assertions.assertEquals(expected, actual);
    }
}
