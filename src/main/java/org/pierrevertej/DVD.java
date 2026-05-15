package org.pierrevertej;

import lombok.Getter;
import lombok.Setter;

@Getter
public class DVD extends Item {
    private String director;
    private double duration;

    public DVD(String title, String director, double duration) {
        super(title);
        this.director = director;
        this.duration = duration;
    }

    public DVD(String id, Status status, String title, String director, double duration) {
        super(id, title, status);
        this.director = director;
        this.duration = duration;
    }
}
