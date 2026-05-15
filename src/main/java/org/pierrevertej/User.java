package org.pierrevertej;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public abstract class User {
    protected String id;
    protected String name;
    protected List<Item> borrowedItems;

    private static int nextId = 1;

    public User(String name) {
        this.id = String.format("%04d", nextId++);
        this.name = name;
        borrowedItems = new ArrayList<>();
    }

    public abstract boolean borrowItem(Item item);
    public abstract boolean returnItem(Item item);
    public abstract boolean canBorrowItem(Item item);
}
