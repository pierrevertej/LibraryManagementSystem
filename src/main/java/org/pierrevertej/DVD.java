package org.pierrevertej;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Getter
public class DVD extends Item {
    private String director;
    private double duration;

    public DVD(String title, String director, double duration) {
        super(title);
        this.director = director;
        this.duration = duration;
    }

    public DVD(String id, String title, Status status, String director, double duration) {
        super(id, title, status);
        this.director = director;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "D," + super.toString()
                + director + "," +
                duration;
    }
}
