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

    /**
     * Borrows an item; adds it to the borrowed items and change the status to borrowed
     * students needs to be able to borrow the item
     * @param item
     * @return boolean representing whether the operation was successful
     */
    @Override
    public boolean borrowItem(Item item) {
        if (canBorrowItem(item)) {
            borrowedItems.add(item);
            item.setStatus(Item.Status.BORROWED);
            return true;
        } else {
            System.out.println("Can't borrow item");
            return false;
        }
    }

    /**
     * Returns an item; changes status to INSTORE and removes it from borrowed books
     * Book needs to be in borrowed books and be borrowed
     * @param item item that needs to be returned
     * @return boolean representing whether the return was successful
     */
    @Override
    public boolean returnItem(Item item) {
        if (borrowedItems.contains(item)) {
            borrowedItems.remove(item);
            item.setStatus(Item.Status.INSTORE);
            return true;
        } else {
            System.out.println("Can't return item");
            return false;
        }
    }

    /**
     * Checks if the student can borrow this item (must be a book and have less than 5 borrowed items)
     * @param item
     * @return boolean showing if the item can be borrowed
     */
    @Override
    public boolean canBorrowItem(Item item) {
        return item.getStatus() == Item.Status.INSTORE && item instanceof Book && borrowedItems.size() < Constants.MAX_BOOKS_STUDENT;
    }

    @Override
    public String toString() {
        return "S" + super.toString();
    }
}
