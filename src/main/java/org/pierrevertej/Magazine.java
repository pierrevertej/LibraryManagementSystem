package org.pierrevertej;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Getter
public class Magazine extends Item {
    private String issueNumber;
    private String publisher;

    public Magazine(String title, String issueNumber, String publisher) {
        super(title);
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }

    public Magazine(String id, String title, Status status, String issueNumber, String publisher) {
        super(id, title, status);
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "M," + super.toString()
                + issueNumber + "," +
                publisher;
    }
}
