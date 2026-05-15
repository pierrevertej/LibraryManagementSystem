package org.pierrevertej;

import lombok.Getter;

@Getter
public class Admin implements Reportable {
    private String id;
    private String name;

    private static int nextId=1;

    public void backupItems() {

    }

    public void backupUsers() {

    }

    public Admin(String name) {
        this.id = String.format("%04d", nextId++);
        this.name = name;
    }

    @Override
    public String generateReport() {
        return "";
    }
}
