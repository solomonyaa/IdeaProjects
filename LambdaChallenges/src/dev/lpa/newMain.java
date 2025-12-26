package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class newMain {

    public static void main(String[] args) {

        //Challenge-1
        //lambda structure
        Consumer<String> printTheParts = sentence ->
                Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));

        //lambda execution
        printTheParts.accept("I am learning lambda expressions.");

        //Challenge-2, 3
        Function<String, String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondChar.apply("1234567890"));

        //Challenge-5
        System.out.println(invokeFunctionalInterface(everySecondChar, "0123456789"));

        Function<String, String> everyFirstChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 0) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(invokeFunctionalInterface(everyFirstChar, "0123456789"));


        //Challenge-6, 7
        Supplier<String> iLoveJava = () -> "I love Java!".toUpperCase();
        var supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        System.out.println("-".repeat(100));

        //region Lambda Expression Challenge
        String[] names = {"Anna", "Bob", "Charlie", "David", "Elon"};

        Arrays.setAll(names, i -> names[i].toUpperCase());
        printStringArray(names);

        Arrays.setAll(names, i -> names[i] += " " + (char) new Random().nextInt(65, 91) + ". ");
        printStringArray(names);

        Arrays.setAll(names, (i) -> names[i] += new StringBuilder(names[i].split(" ")[0]).reverse().toString());
        printStringArray(names);

        List<String> listOfNames = new ArrayList<>(List.of(names));
        listOfNames.removeIf(s -> {
            var firstName = s.split(" ")[0];
            var lastName = s.split(" ")[2];
            return firstName.equals(lastName);
        });

        System.out.println("-".repeat(100));
        listOfNames.forEach(s -> System.out.print(s + ", "));
        System.out.println();
        //endregion
    }

    //Challenge-4
    public static String invokeFunctionalInterface(Function<String, String> function, String input) {
        return function.apply(input);
    }

    public static void printStringArray(String[] names) {

        Arrays.asList(names).forEach(s -> System.out.print(s + ", "));
        System.out.println();
    }
}
