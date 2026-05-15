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

    public Library() {
        loadItems();
        loadUsers();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    private void loadUsers() {
        File file = new File(Constants.USERS_CSV_PATH);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                User user;
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
                    user = new Student(id, name, borrowedBooks);
                } else {
                    user = new Teacher(id, name, borrowedBooks);
                }
                users.add(user);
                User.setNextId(User.getNextId() + 1);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadItems() {
        File file = new File(Constants.BOOKS_CSV_PATH);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                Item item;
                String[] elements = scanner.nextLine().split(",");
                String id = elements[1];
                String title = elements[2];
                Item.Status status = Item.Status.valueOf(elements[3]);
                if (elements[0] == "B") {
                    String isbn = elements[4];
                    String author = elements[5];
                    String genre = elements[6];
                    item = new Book(id, title, status, isbn, author, genre);
                } else if (elements[0] == "D") {
                    String director = elements[4];
                    double duration = Double.parseDouble(elements[5]);
                    item = new DVD(id, title, status, director, duration);
                } else {
                    String issueNumber = elements[4];
                    String publisher = elements[5];
                    item = new Magazine(id, title, status, issueNumber, publisher);
                }
                items.add(item);
                Item.setNextId(Item.getNextId() + 1);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } ;
    }

    public List<Item> searchTitle(String title) {
        Set<Item> result = new HashSet<>();
        for (Item item : items) {
            if (item.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(item);
            }
        }
        return new ArrayList<>(result);
    }

    public List<Item> searchAuthor(String author) {
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

    public List<Item> searchTitleStream(String title) {
        List<Item> apply = items.stream()
                .filter(item -> item.getTitle().toLowerCase().contains(title.toLowerCase()))
                .toList();
        Set<Item> result = new HashSet<>(apply);
        return new ArrayList<>(result);
    }

    public List<Item> searchAuthorStream(String author) {
        List<Item> apply = items.stream()
                .filter(item -> (item instanceof Book book && book.getAuthor().toLowerCase().contains(author.toLowerCase())) ||
                        (item instanceof DVD dvd && dvd.getDirector().toLowerCase().contains(author.toLowerCase())) ||
                        (item instanceof Magazine magazine && magazine.getPublisher().toLowerCase().contains(author.toLowerCase())))
                .toList();
        Set<Item> result = new HashSet<>(apply);
        return new ArrayList<>(result);
    }

    public List<Item> searchTitleRecursion(String title) {
        List<Item> copy = new ArrayList<>(items);
        List<Item> answer = new ArrayList<>();
        helperTitle(copy, answer, title);
        return answer;
    }

    public List<Item> searchAuthorRecursion(String author) {
        List<Item> copy = new ArrayList<>(items);
        List<Item> answer = new ArrayList<>();
        helperTitle(copy, answer, author);
        return answer;
    }

    private void helperTitle(List<Item> copy, List<Item> answer, String title){
        if (copy.isEmpty()) {return;}
        Item item = copy.get(0);
        copy.remove(0);
        if (item.getTitle().toLowerCase().contains(title.toLowerCase())) {answer.add(item);}
        helperTitle(copy, answer, title);
    }

    private void helperAuthor(List<Item> copy, List<Item> answer, String author){
        if (copy.isEmpty()) {return;}
        Item item = copy.getFirst();
        copy.removeFirst();
        if (item instanceof Book book && book.getAuthor().toLowerCase().contains(author.toLowerCase())) {answer.add(item);}
        else if (item instanceof DVD dvd && dvd.getDirector().toLowerCase().contains(author.toLowerCase())) {answer.add(item);}
        else if (item instanceof Magazine mag && mag.getPublisher().toLowerCase().contains(author.toLowerCase())) {answer.add(item);}
        helperTitle(copy, answer, author);
    }

    public List<User> sortUsersName() {
        return users.stream()
                .sorted((o1, o2) -> o1.name.compareTo(o2.name))
                .toList();
    }

    public List<User> sortUsersId() {
        return users.stream()
                .sorted((o1, o2) -> o1.id.compareTo(o2.id))
                .toList();
    }

    public List<Item> sortItemsId() {
        return items.stream()
                .sorted((o1, o2) -> o1.id.compareTo(o2.id))
                .toList();
    }

    public List<Item> sortItemsTitle() {
        return items.stream()
                .sorted((o1, o2) -> o1.title.compareTo(o2.title))
                .toList();
    }
}
