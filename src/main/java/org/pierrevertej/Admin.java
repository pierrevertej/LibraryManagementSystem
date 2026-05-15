package org.pierrevertej;

import lombok.Getter;
import util.Constants;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Admin implements Reportable {

    /**
     * Backs up the items and users lists into the csv files
     */
    public void backup() {
        backupItems();
        backupUsers();
    }

    /**
     * Puts the item data into the books.csv file
     */
    private void backupItems() {
        List<Item> items = Library.getItems();
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item + "\n");
        }

        File file = new File(Constants.BOOKS_CSV_PATH);
        try (FileWriter fw = new FileWriter(file, false)) {
            fw.append(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Puts the user data into the users.csv file
     */
    private void backupUsers() {
        List<User> users = Library.getUsers();
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(user + "\n");
        }

        File file = new File(Constants.USERS_CSV_PATH);
        try (FileWriter fw = new FileWriter(file, false)) {
            fw.append(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Print information about every item of the library
     */
    @Override
    public void generateReport() {
        Map<Item.Status, List<Item>> report = new HashMap<>();
        for (Item item : Library.getItems()) {
            report.putIfAbsent(item.getStatus(), new ArrayList<>());
            report.get(item.getStatus()).add(item);
        }
        System.out.println(report);
    }
}
