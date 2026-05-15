package org.pierrevertej;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public abstract class Item {
    protected String id;
    @Setter
    protected Status status;

    @Setter private static int nextId = 1;

    public Item() {
        this.id = String.format("%04d", nextId++);
        this.status = Status.INSTORE;
    }

    public enum Status {
        INSTORE, BORROWED, LOST
    }
}
