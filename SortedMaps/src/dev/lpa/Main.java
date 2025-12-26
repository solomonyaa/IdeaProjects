package dev.lpa;

import java.time.LocalDate;
import java.util.*;

public class Main {

    private static Map<String, Purchase> purchases = new LinkedHashMap<>();
    private static NavigableMap<String, Student> students = new TreeMap<>();

    public static void main(String[] args) {

        Course jmc = new Course("jmc101", "Java Master Class", "Java");
        Course python = new Course("pyt101", "Python Master Class", "Python");

        addPurchase("Mary Martin", jmc, 129.99);
        addPurchase("Andy Martin", jmc, 139.99);
        addPurchase("Mary Martin", python, 149.99);
        addPurchase("Joe Jones", jmc, 149.99);
        addPurchase("Bill Brown", python, 119.99);

        purchases.forEach((key, purchase) -> System.out.println(key + ": " + purchase));
        System.out.println("-".repeat(50));
        students.forEach((name, student) -> System.out.println(name + " " + student));

        NavigableMap<LocalDate, List<Purchase>> datedPurchases = new TreeMap<>();

        for (Purchase p : purchases.values()) {
            datedPurchases.compute(p.purchaseDate(),
                    (pdate, plist) -> {
                        List<Purchase> list = (plist == null) ? new ArrayList<>() : plist;
                        list.add(p);
                        return list;
                    });
        }

        System.out.println("-".repeat(50));
        datedPurchases.forEach((date, purchase) -> System.out.println(date + " " + purchase));


        int currentYear = LocalDate.now().getYear();
        LocalDate firstDay = LocalDate.ofYearDay(currentYear, 1);
        LocalDate week1LastDate = firstDay.plusDays(7);

        Map<LocalDate, List<Purchase>> week1Purchases = datedPurchases.headMap(week1LastDate);
        Map<LocalDate, List<Purchase>> week2Purchases = datedPurchases.tailMap(week1LastDate);

        System.out.println("-".repeat(50));
        week1Purchases.forEach((date, purchases) -> System.out.println(date + " " + purchases));
        System.out.println("-".repeat(50));
        week2Purchases.forEach((date, purchases) -> System.out.println(date + " " + purchases));


    }

    private static void addPurchase(String name, Course course, double price) {

        Student existingStudent = students.get(name);
        if (existingStudent == null) {
            existingStudent = new Student(name, course);
            students.put(name, existingStudent);
        } else {
            existingStudent.addCourse(course);
        }

        int day = new Random().nextInt(1, 15);
        String key = course.courseId() + "_" + existingStudent.getId();
        int year = LocalDate.now().getYear();

        Purchase purchase = new Purchase(
                course.courseId(), existingStudent.getId(), price, year, day);

        purchases.put(key, purchase);
    }
}