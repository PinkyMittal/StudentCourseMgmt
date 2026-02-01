package com.airtribe.learntrack.helper;

public class IdGenerator {
    private static int counter = 1000;

    public static int generateId() {
        return ++counter;
    }
}
