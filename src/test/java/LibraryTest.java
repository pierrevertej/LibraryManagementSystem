import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pierrevertej.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryTest {
    Item o1;
    Item o2;
    Item o3;
    Item o4;

    @DisplayName("SearchTitle: world -> [o1, o3]")
    @Test()
    void testSearchTitle1() {
        Library.setItems(new ArrayList<>());
        Item o1 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item o2 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item o3 = new Magazine("Richest People in the World", "Vol. 2", "Time");
        Item o4 = new DVD("Dune", "Villeneuve", 155);
        List<Item> actual = Library.searchTitle("world");
        List<Item> expected = new ArrayList<>(Arrays.asList(o1, o3));
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("SearchAuthor: L -> [o1, o4]")
    @Test
    void testSearchAuthor1() {
        Library.setItems(new ArrayList<>());
        Item o1 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item o2 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item o3 = new Magazine("Richest People in the World", "Vol. 2", "Time");
        Item o4 = new DVD("Dune", "Villeneuve", 155);
        List<Item> actual = Library.searchAuthor("L");
        List<Item> expected = new ArrayList<>(Arrays.asList(o1, o4));
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("SearchTitleStream: world -> [o1, o3]")
    @Test()
    void testSearchTitleStream1() {
        Library.setItems(new ArrayList<>());
        Item o1 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item o2 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item o3 = new Magazine("Richest People in the World", "Vol. 2", "Time");
        Item o4 = new DVD("Dune", "Villeneuve", 155);
        List<Item> actual = Library.searchTitleStream("world");
        List<Item> expected = new ArrayList<>(Arrays.asList(o1, o3));
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("SearchAuthorStream: L -> [o1, o4]")
    @Test
    void testSearchAuthorStream1() {
        Library.setItems(new ArrayList<>());
        Item o1 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item o2 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item o3 = new Magazine("Richest People in the World", "Vol. 2", "Time");
        Item o4 = new DVD("Dune", "Villeneuve", 155);
        List<Item> actual = Library.searchAuthorStream("L");
        List<Item> expected = new ArrayList<>(Arrays.asList(o1, o4));
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("SearchTitleRecursion: world -> [o1, o3]")
    @Test()
    void testSearchTitleRecursion1() {
        Library.setItems(new ArrayList<>());
        Item o1 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item o2 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item o3 = new Magazine("Richest People in the World", "Vol. 2", "Time");
        Item o4 = new DVD("Dune", "Villeneuve", 155);
        List<Item> actual = Library.searchTitleRecursion("world");
        List<Item> expected = new ArrayList<>(Arrays.asList(o1, o3));
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("SearchAuthorRecursion: L -> [o1, o4]")
    @Test
    void testSearchAuthorRecursion1() {
        Library.setItems(new ArrayList<>());
        Item o1 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item o2 = new Book("1234567890123", "Brave New World", "Aldous Huxley", "dystopian");
        Item o3 = new Magazine("Richest People in the World", "Vol. 2", "Time");
        Item o4 = new DVD("Dune", "Villeneuve", 155);
        List<Item> actual = Library.searchAuthorRecursion("L");
        List<Item> expected = new ArrayList<>(Arrays.asList(o1, o4));
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("sortItemsId: [o2, o3, o1, o4]")
    @Test
    void testSortItemsId1() {
        Library.setItems(new ArrayList<>());
        Item o1 = new Book("0030", "Brave New World", Item.Status.INSTORE, "1234567890123","Aldous Huxley", "dystopian");
        Item o2 = new Book("0010", "Brave New World", Item.Status.INSTORE, "1234567890123","Aldous Huxley", "dystopian");
        Item o3 = new Magazine("0020", "Richest People in the World", Item.Status.INSTORE, "Vol. 2", "Time");
        Item o4 = new DVD("0040", "Dune", Item.Status.INSTORE, "Villeneuve", 155);
        List<Item> actual = Library.sortItemsId();
        List<Item> expected = new ArrayList<>(Arrays.asList(o2, o3, o1, o4));
        Assertions.assertEquals(actual, expected);
    }

    @DisplayName("sortItemsTitle: [o2, o3, o1, o4]")
    @Test
    void testSortItemsTitle1() {
        Library.setItems(new ArrayList<>());
        Item o1 = new Book("0030", "Brave New World", Item.Status.INSTORE, "1234567890123","Aldous Huxley", "dystopian");
        Item o2 = new Book("0010", "Brave New World", Item.Status.INSTORE, "1234567890123","Aldous Huxley", "dystopian");
        Item o3 = new Magazine("0020", "Richest People in the World", Item.Status.INSTORE, "Vol. 2", "Time");
        Item o4 = new DVD("0040", "Dune", Item.Status.INSTORE, "Villeneuve", 155);
        List<Item> actual = Library.sortItemsTitle();
        List<Item> expected = new ArrayList<>(Arrays.asList(o1, o2, o4, o3));
        Assertions.assertEquals(actual, expected);
    }

    @DisplayName("SortUsersId: [o2, o1, o4, o3]")
    @Test
    void testSortUsersId1() {
        Library.setUsers(new ArrayList<>());
        User o1 = new Student("0020", "Jade", new ArrayList<>());
        User o2 = new Student("0010", "Mike", new ArrayList<>());
        User o3 = new Teacher("0040", "Yi", new ArrayList<>());
        User o4 = new Teacher("0030", "John", new ArrayList<>());
        List<User> actual = Library.sortUsersId();
        List<User> expected = new ArrayList<>(Arrays.asList(o2, o1, o4, o3));
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("SortUsersName: [o1, o4, o2, o3]")
    @Test
    void testSortUsersName1() {
        Library.setUsers(new ArrayList<>());
        User o1 = new Student("0020", "Jade", new ArrayList<>());
        User o2 = new Student("0010", "Mike", new ArrayList<>());
        User o3 = new Teacher("0040", "Yi", new ArrayList<>());
        User o4 = new Teacher("0030", "John", new ArrayList<>());
        List<User> actual = Library.sortUsersName();
        List<User> expected = new ArrayList<>(Arrays.asList(o1, o4, o2, o3));
        Assertions.assertEquals(expected, actual);
    }
}
