package org.pierrevertej;

import lombok.Getter;
import lombok.Setter;

@Getter
public class DVD extends Item {
    private String title;
    private String director;
    private double duration;

    public DVD(String title, String director, double duration) {
        this.title = title;
        this.director = director;
        this.duration = duration;
    }

    public DVD(String id, Status status, String title, String director, double duration) {
        super(id, status);
        this.title = title;
        this.director = director;
        this.duration = duration;
    }
}
