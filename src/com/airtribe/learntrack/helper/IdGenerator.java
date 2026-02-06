package com.airtribe.learntrack.helper;

public class IdGenerator {
    private static int counter = 1000;
    private static int courseId = 1000;

    public static int generateId() {
        return ++counter;
    }

    public static int generateCourseId() {
        return ++courseId;
    }
}
