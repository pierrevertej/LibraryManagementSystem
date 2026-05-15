package org.pierrevertej;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public abstract class Item {
    protected String id;
    protected String title;
    @Setter protected Status status;

    @Setter @Getter private static int nextId = 1;

    public Item(String title) {
        this.id = String.format("%04d", nextId++);
        this.title = title;
        this.status = Status.INSTORE;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(title, item.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    public String toString() {
        return id + ","  + title +
                "," + status + ",";
    }

    public enum Status {
        INSTORE, BORROWED, LOST
    }
}
