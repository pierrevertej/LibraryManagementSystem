package org.pierrevertej;

public class Magazine extends Item {
    private String issueNumber;
    private String publisher;

    public Magazine(String title, String issueNumber, String publisher) {
        super(title);
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }
}
