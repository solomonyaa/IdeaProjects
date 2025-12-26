package dev.lpa;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        // Each BigDecimal instance has a:
        // Value - a decimal number
        // Unscaled Value - the value provided without a decimal point
        // Scale - amount of digits to the right of the decimal point
        // Precision - the amount of all digits in the value

        // It's better to use the String constructor of BigDecimal.
        // BigDecimal bd = new BigDecimal[some string representing a decimal number];

        String[] tests = {"15.456", "8", "10000.000001", ".125"};
        BigDecimal[] bds = new BigDecimal[tests.length];
        Arrays.setAll(bds, i -> new BigDecimal(tests[i]));

        System.out.printf("%-14s %-15s %-8s %s%n",
                "Value", "Unscaled Value", "Scale", "Precision");

        for (var bd : bds) {
            System.out.printf("%-15s %-15d %-8d %d %n",
                    bd, bd.unscaledValue(), bd.scale(), bd.precision());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            System.out.printf("%-15s %-15d %-8d %d %n",
                    bd, bd.unscaledValue(), bd.scale(), bd.precision());
        }

        BigDecimal percent = BigDecimal.ONE.divide(BigDecimal.valueOf(3),
            MathContext.DECIMAL32);
        System.out.println(percent);

        BigDecimal percent2 = BigDecimal.ONE.divide(BigDecimal.valueOf(3),
                new MathContext(60, RoundingMode.UP));
        System.out.println(percent2);

        //pascalTriangle(new int[]{1}, 4);


        HashSet<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Pear");
        fruits.add("Banana");

        System.out.println(fruits);

        var iterator = fruits.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        
    }


    private static void pascalTriangle(int[] arr, int lines) {

        if (lines <= 0) return;

        for (int i = 1; i <= lines + 1; i++) {
            System.out.print(" ");
        }

        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }

        int newSize = arr.length + 1;
        int[] newArr = new int[newSize];

        for (int i = 0; i < newArr.length; i++) {

            if (i == 0 || i == newSize - 1) {
                newArr[i] = 1;
            } else {
                newArr[i] = arr[i - 1] + arr[i];
            }
        }

        System.out.println();
        pascalTriangle(newArr, --lines);
    }
}