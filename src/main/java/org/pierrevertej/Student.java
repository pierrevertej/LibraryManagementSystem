package org.pierrevertej;

import util.Constants;

import java.util.List;

public class Student extends User {
    public Student(String name) {
        super(name);
    }

    public Student(String id, String name, List<Item> borrowedItems) {
        super(id, name, borrowedItems);
    }

    @Override
    public boolean borrowItem(Item item) {
        if (canBorrowItem(item)) {
            borrowedItems.add(item);
            item.setStatus(Item.Status.BORROWED);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean returnItem(Item item) {
        if (borrowedItems.contains(item)) {
            borrowedItems.remove(item);
            item.setStatus(Item.Status.INSTORE);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canBorrowItem(Item item) {
        return !borrowedItems.contains(item) && item.getStatus() == Item.Status.INSTORE && item instanceof Book && borrowedItems.size() < Constants.MAX_BOOKS_STUDENT;
    }
}
