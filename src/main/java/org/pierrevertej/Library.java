package org.pierrevertej;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private static List<Item> items = new ArrayList<>();
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

    public void loadUsers() {

    }

    public void loadItems() {

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
