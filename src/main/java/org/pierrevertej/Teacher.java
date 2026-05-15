package org.pierrevertej;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import util.Constants;

import java.util.List;

@Getter
@EqualsAndHashCode(callSuper = true)
public class Teacher extends User {
    public Teacher(String name) {
        super(name);
    }

    public Teacher(String id, String name, List<Item> borrowedItems) {
        super(id, name, borrowedItems);
    }

    /**
     * Borrows an item; adds it to the borrowed items and change the status to borrowed
     * teacher needs to be able to borrow the item
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
            return false;
        }
    }

    /**
     * Checks if the teacher can borrow this item (must have less than 10 borrowed items)
     * @param item
     * @return boolean showing if the item can be borrowed
     */
    @Override
    public boolean canBorrowItem(Item item) {
        return item.getStatus() == Item.Status.INSTORE &&  borrowedItems.size() < Constants.MAX_ITEMS_TEACHER;
    }

    @Override
    public String toString() {
        return "T" + super.toString();
    }
}
