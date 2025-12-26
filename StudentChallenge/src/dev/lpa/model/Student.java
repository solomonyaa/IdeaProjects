package dev.lpa.model;

import dev.lpa.util.QueryItem;

import java.util.Random;

public class Student implements QueryItem, Comparable<Student> {

    private static int index = 1000;
    protected String id;
    protected String name;
    protected String course;
    protected int yearStarted;

    protected static Random random = new Random();

    private static final String[] firstNames = {"Anne", "Bruce", "Catherine", "David", "Elon", "Frank", "George", "Haley", "Iris", "John"};
    private static final String[] courses = {"C++", "Java", "Python", "C#"};

    public Student() {
        this.id = String.valueOf(++index);
        int lastNameIndex = random.nextInt(65, 91);
        name = firstNames[random.nextInt(firstNames.length)] + " " + (char) lastNameIndex;
        course = courses[random.nextInt(courses.length)];
        yearStarted = random.nextInt(2018, 2024);
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-15s %d", id, name, course, yearStarted);
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {

        String fName = fieldName.toUpperCase();
        return switch(fName) {
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == (Integer.parseInt(value));
            default -> false;
        };
    }

    @Override
    public int compareTo(Student other) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(other.id));
    }

}
