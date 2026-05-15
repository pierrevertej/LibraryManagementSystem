package org.pierrevertej;

import lombok.Getter;
import util.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Library {
    @Getter
    private static List<Item> items = new ArrayList<>();
    @Getter
    private static List<User> users = new ArrayList<>();

    /**
     * loads the data from csv files into the fields
     */
    public static void loadData() {
        loadItems();
        loadUsers();
    }

    /**
     * adds a user to the list of users
     * @param user
     */
    public static void addUser(User user) {
        users.add(user);
    }

    /**
     * adds an item to the list of items
     * @param item
     */
    public static void addItem(Item item) {
        items.add(item);
    }

    /**
     * loads the data from the users.csv file into the users list
     */
    private static void loadUsers() {
        users = new ArrayList<>();
        File file = new File(Constants.USERS_CSV_PATH);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] elements = scanner.nextLine().split(",");
                String id = elements[1];
                String name = elements[2];
                List<Item> borrowedBooks = new ArrayList<>();
                for (int i = 3; i < elements.length; i++) {
                    String itemId = elements[i];
                    for (Item item : items ) {
                        if (item.getId().equals(itemId)) {
                            borrowedBooks.add(item);
                            break;
                        }
                    }
                }
                if (elements[0] == "S") {
                    User user = new Student(id, name, borrowedBooks);
                } else {
                    User user = new Teacher(id, name, borrowedBooks);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * loads the data from the books.csv file into the items list
     */
    private static void loadItems() {
        items = new ArrayList<>();
        File file = new File(Constants.BOOKS_CSV_PATH);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] elements = scanner.nextLine().split(",");
                String id = elements[1];
                String title = elements[2];
                Item.Status status = Item.Status.valueOf(elements[3]);
                if (elements[0] == "B") {
                    String isbn = elements[4];
                    String author = elements[5];
                    String genre = elements[6];
                    Item item = new Book(id, title, status, isbn, author, genre);
                } else if (elements[0] == "D") {
                    String director = elements[4];
                    double duration = Double.parseDouble(elements[5]);
                    Item item = new DVD(id, title, status, director, duration);
                } else {
                    String issueNumber = elements[4];
                    String publisher = elements[5];
                    Item item = new Magazine(id, title, status, issueNumber, publisher);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * search for items that contain a keyword in the title (no duplicates)
     * @param title keyword that is searched in titles
     * @return a list of items that contain the keyword in their title
     */
    public static List<Item> searchTitle(String title) {
        Set<Item> result = new HashSet<>();
        for (Item item : items) {
            if (item.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(item);
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * search for items that contain a keyword in their author (no duplicates)
     * @param title keyword that is searched in authors
     * @return a list of items that contain the keyword in their author's name
     */
    public static List<Item> searchAuthor(String author) {
        Set<Item> result = new HashSet<>();
        for (Item item : items) {
            if (item instanceof Book book && book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                result.add(item);
            }
            else if (item instanceof DVD dvd && dvd.getDirector().toLowerCase().contains(author.toLowerCase())) {
                result.add(item);
            }
            else if (item instanceof Magazine magazine && magazine.getPublisher().toLowerCase().contains(author.toLowerCase())) {
                result.add(item);
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * search for items that contain a keyword in the title (no duplicates)
     * @param title keyword that is searched in titles
     * @return a list of items that contain the keyword in their title
     */
    public static List<Item> searchTitleStream(String title) {
        List<Item> apply = items.stream()
                .filter(item -> item.getTitle().toLowerCase().contains(title.toLowerCase()))
                .toList();
        Set<Item> result = new HashSet<>(apply);
        return new ArrayList<>(result);
    }
    /**
     * search for items that contain a keyword in their author (no duplicates)
     * @param title keyword that is searched in authors
     * @return a list of items that contain the keyword in their author's name
     */
    public static List<Item> searchAuthorStream(String author) {
        List<Item> apply = items.stream()
                .filter(item -> (item instanceof Book book && book.getAuthor().toLowerCase().contains(author.toLowerCase())) ||
                        (item instanceof DVD dvd && dvd.getDirector().toLowerCase().contains(author.toLowerCase())) ||
                        (item instanceof Magazine magazine && magazine.getPublisher().toLowerCase().contains(author.toLowerCase())))
                .toList();
        Set<Item> result = new HashSet<>(apply);
        return new ArrayList<>(result);
    }

    /**
     * search for items that contain a keyword in the title (no duplicates)
     * @param title keyword that is searched in titles
     * @return a list of items that contain the keyword in their title
     */
    public static List<Item> searchTitleRecursion(String title) {
        List<Item> copy = new ArrayList<>(items);
        List<Item> answer = new ArrayList<>();
        helperTitle(copy, answer, title); // helper calls itself
        return answer;
    }
    /**
     * search for items that contain a keyword in their author (no duplicates)
     * @param title keyword that is searched in authors
     * @return a list of items that contain the keyword in their author's name
     */
    public static List<Item> searchAuthorRecursion(String author) {
        List<Item> copy = new ArrayList<>(items);
        List<Item> answer = new ArrayList<>();
        helperAuthor(copy, answer, author); // recursion is because the helper calls itself
        return answer;
    }

    /**
     * goes through elements in copy and adds those that contain the keyword into answer
     * uses recursion
     * @param copy
     * @param answer
     * @param title
     */
    private static void helperTitle(List<Item> copy, List<Item> answer, String title){
        if (copy.isEmpty()) {return;}
        Item item = copy.get(0);
        copy.remove(0);
        if (item.getTitle().toLowerCase().contains(title.toLowerCase())) {answer.add(item);}
        helperTitle(copy, answer, title);
    }

    /**
     * goes through elements in copy and adds those that contain the keyword into answer
     * uses recursion
     * @param copy
     * @param answer
     * @param title
     */
    private static void helperAuthor(List<Item> copy, List<Item> answer, String author){
        if (copy.isEmpty()) {return;}
        Item item = copy.getFirst();
        copy.removeFirst();
        if (item instanceof Book book && book.getAuthor().toLowerCase().contains(author.toLowerCase())) {answer.add(item);}
        else if (item instanceof DVD dvd && dvd.getDirector().toLowerCase().contains(author.toLowerCase())) {answer.add(item);}
        else if (item instanceof Magazine mag && mag.getPublisher().toLowerCase().contains(author.toLowerCase())) {answer.add(item);}
        helperTitle(copy, answer, author);
    }

    /**
     * Sorts the users by the name
     * @return the list of users sorted by name
     */
    public static List<User> sortUsersName() {
        return users.stream()
                .sorted((o1, o2) -> o1.name.compareTo(o2.name))
                .toList();
    }

    /**
     * sorts the users by id
     * @return the list of users sorted by id
     */
    public static List<User> sortUsersId() {
        return users.stream()
                .sorted((o1, o2) -> o1.id.compareTo(o2.id))
                .toList();
    }

    /**
     * sorts the items by id
     * @return the list of items sorted by id
     */
    public static List<Item> sortItemsId() {
        return items.stream()
                .sorted((o1, o2) -> o1.id.compareTo(o2.id))
                .toList();
    }

    /**
     * sorts the items by title
     * @return the list of items sorted by title
     */
    public static List<Item> sortItemsTitle() {
        return items.stream()
                .sorted((o1, o2) -> o1.title.compareTo(o2.title))
                .toList();
    }
}
