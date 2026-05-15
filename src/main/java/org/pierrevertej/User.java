package org.pierrevertej;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Setter
@Getter
public abstract class User {
    protected String id;
    protected String name;
    protected List<Item> borrowedItems;

    @Getter @Setter private static int nextId = 1;

    public User(String name) {
        this.id = String.format("%04d", nextId++);
        this.name = name;
        borrowedItems = new ArrayList<>();
        Library.addUser(this);
    }

    public User(String id, String name, List<Item> borrowedItems) {
        this.id = id;
        this.name = name;
        this.borrowedItems = borrowedItems;
        nextId++;
        Library.addUser(this);
    }

    @Override
    public String toString() {
        String str =  "," + id + "," + name;
        for (Item item : borrowedItems) {
            str += "," + item.getId();
        }
        return str;
    }

    // documentation in each implementation of the abstract methods
    public abstract boolean borrowItem(Item item);
    public abstract boolean returnItem(Item item);
    public abstract boolean canBorrowItem(Item item);
}
