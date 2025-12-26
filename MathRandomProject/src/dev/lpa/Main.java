package dev.lpa;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        final int x = 5;
        int maxMinusFive = Integer.MAX_VALUE - x;
        for (int j = 0, id = maxMinusFive; j < x; j++, id = Math.incrementExact(id)) {
            System.out.printf("Assigning id %,d%n", id);
        }

        System.out.println(Math.abs(-50));
        System.out.println(Math.abs(Integer.MIN_VALUE));
        //System.out.println(Math.absExact(Integer.MIN_VALUE));

        System.out.println(Math.abs((long) Integer.MIN_VALUE));

        System.out.printf("Max = %d", Math.max(10, -10));
        System.out.println("\nMin = " + Math.min(10.0000002, 10.001));

        //returned type - long
        System.out.println("Round Down = " + Math.round(10.2)); // 10
        System.out.println("Round Up = " + Math.round(10.8)); // 11
        System.out.println("Round ? = " + Math.round(10.5)); // 11

        //returned type - double
        System.out.println("Floor = " + Math.floor(12.7)); // 12
        System.out.println("Ceil = " + Math.ceil(12.2)); // 13

        int num = 256;
        System.out.println("Square root of " + num + " = " + Math.sqrt(num));
        System.out.println("2^3 = " + Math.pow(2, 3));

        System.out.println("\nRandom doubles between 0.0 and 1.0:");
        for (int i = 0; i < 10; i++) {
            System.out.println(Math.random()); // >= 0.0 && < 1.0
        }

        for (int i = 0; i < 10; i++) {
            System.out.printf("%1$d = %1$c%n", (int) (Math.random() * 26) + 65);
        }

        System.out.println("-".repeat(50));
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            System.out.printf("%1$d = %1$c%n", r.nextInt(65, 91));
        }

        System.out.println("-".repeat(50));

        for (int i = 0; i < 10; i++) {
            System.out.printf("%1$d = %1$c%n", r.nextInt('A', 'Z' + 1));
        }

        System.out.println("\nASCII Table (Letters Only)");

        for (int i = 65; i < 91; i++) {
            char uCase = (char) i;
            char lCase = Character.toLowerCase(uCase);
            System.out.printf("%c = %d, %c = %d%n", uCase, i, lCase, (int) lCase);
        }

        System.out.println("-".repeat(50));

        r.ints()
                .limit(10)
                .forEach(System.out::println);

        System.out.println("-".repeat(50));

        r.ints(0, 10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("-".repeat(50));

        r.ints(10, 0, 10)
                .forEach(System.out::println);

        System.out.println("-".repeat(50));

        r.ints(10)
                .forEach(System.out::println);
    }
}