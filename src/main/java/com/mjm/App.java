package com.mjm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Hello world!
 *
 * @author majunmin
 */
public class App {

    private static String oor = "Hello World!";
    private static final String ior = "Hello World!";

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(11);
        integers.add(13);
        integers.add(15);

        Collections.sort(integers);
        System.out.println(integers.toString());
    }
}
