package org.pierrevertej;

public class DVD extends Item {
    private String title;
    private String director;
    private double duration;

    public DVD(String title, String director, double duration) {
        this.title = title;
        this.director = director;
        this.duration = duration;
    }
}
