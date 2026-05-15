package org.pierrevertej;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static void main() {
        Magazine mag1 = new Magazine("vsnd", "vaev", "fae");
        Magazine mag2 = new Magazine("vsnd", "vaev", "fae");
        System.out.println(mag1.equals(mag2));

        List<Item> items = new ArrayList<>(Arrays.asList(mag1, mag2));
        System.out.println(items);
    }
}
