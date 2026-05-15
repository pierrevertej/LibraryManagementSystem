package org.pierrevertej;

import util.Constants;

import java.util.List;

public class Teacher extends User {
    public Teacher(String name) {
        super(name);
    }

    public Teacher(String id, String name, List<Item> borrowedItems) {
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
        return !borrowedItems.contains(item) && item.getStatus() == Item.Status.INSTORE && item instanceof Book && borrowedItems.size() < Constants.MAX_ITEMS_TEACHER;
    }
}
