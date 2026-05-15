import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pierrevertej.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeacherTest {
    @Test
    void testCanBorrowItem1() {
        User teacher = new Teacher("Jade");
        Item book = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        boolean actual = teacher.canBorrowItem(book);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCanBorrowItem2() {
        User teacher = new Teacher("Jade");
        Item book = new Book("0001", "Brave New World", Item.Status.BORROWED, "1234567890123", "Aldous Huxley", "dystopian");
        boolean actual = teacher.canBorrowItem(book);
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCanBorrowItem3() {
        User teacher = new Teacher("Jade");
        Item mag = new Magazine("0020", "Richest People in the World", Item.Status.INSTORE, "Vol. 2", "Time");
        boolean actual = teacher.canBorrowItem(mag);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCanBorrowItem4() {
        User teacher = new Teacher("Jade");
        Item book1 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item book2 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item book3 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item book4 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item book5 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item book6 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item book7 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item book8 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item book9 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item book10 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item book11 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        teacher.borrowItem(book1);teacher.borrowItem(book2);teacher.borrowItem(book3);teacher.borrowItem(book4);teacher.borrowItem(book5);
        teacher.borrowItem(book6);teacher.borrowItem(book7);teacher.borrowItem(book8);teacher.borrowItem(book9);teacher.borrowItem(book10);
        boolean actual = teacher.canBorrowItem(book11);
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testBorrowItem1() {
        User teacher = new Teacher("Jade");
        Item book = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        teacher.borrowItem(book);
        List<Item> actual = teacher.getBorrowedItems();
        List<Item> expected = new ArrayList<>(Arrays.asList(book));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testBorrowItem2() {
        User teacher = new Teacher("Jade");
        Item mag = new Magazine("0020", "Richest People in the World", Item.Status.INSTORE, "Vol. 2", "Time");
        teacher.borrowItem(mag);
        List<Item> actual = teacher.getBorrowedItems();
        List<Item> expected = new ArrayList<>(Arrays.asList(mag));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testReturnItem1() {
        User teacher = new Teacher("Jade");
        Item book = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        teacher.borrowItem(book);
        teacher.returnItem(book);
        List<Item> actual = teacher.getBorrowedItems();
        List<Item> expected = new ArrayList<>();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testReturnItem2() {
        User teacher = new Teacher("Jade");
        Item book = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item mag = new Magazine("0020", "Richest People in the World", Item.Status.INSTORE, "Vol. 2", "Time");
        teacher.borrowItem(book);
        teacher.returnItem(mag);
        List<Item> actual = teacher.getBorrowedItems();
        List<Item> expected = new ArrayList<>(Arrays.asList(book));
        Assertions.assertEquals(expected, actual);
    }
}
