package dev.lpa.model;

import java.util.Random;

public class Student {

    protected static Random random = new Random();
    private static String[] firstNames = {"Anne", "Bruce", "Catherine", "David", "Elon", "Frank", "George", "Haley", "Iris", "John"};
    private static String[] courses = {"C++", "Java", "Python", "C#", "Ruby", "Swift", "Go"};
    private String name;
    private String course;
    private int yearStarted;

    public Student() {
        this.name = firstNames[random.nextInt(firstNames.length)] + " " + (char) random.nextInt(65, 91);
        this.course = courses[random.nextInt(courses.length)];
        this.yearStarted = random.nextInt(2018, 2024);
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %d", this.name, this.course, this.yearStarted);
    }

    public int getYearStarted() {
        return yearStarted;
    }
}
