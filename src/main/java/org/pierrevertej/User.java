package org.pierrevertej;

import java.util.List;

public abstract class User {
    protected String id;
    protected String name;
    protected List<Item> borrowedItems;

    public boolean borrowItem;
    public boolean returnItem;
    public boolean canBorrowItem;
}
