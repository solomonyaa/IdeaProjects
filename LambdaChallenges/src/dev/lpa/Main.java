package dev.lpa;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {

        //region Challenge-1
        // Consumer lambda variable declaration
        Consumer<String> printWordsLambda = sentence -> {

            var words = sentence.split(" ");
            for (String word : words) {
                System.out.println(word);
            }
        };

        Consumer<String> printWordsForEach = sentence -> {

            var words = sentence.split(" ");
            Arrays.asList(words).forEach((s -> System.out.println(s)));
        };

        // Consumer lambda execution
        printWordsLambda.accept("Split this sentence into words");
        System.out.println("-".repeat(15));
        printWordsForEach.accept("This is a new sentence");

        //endregion

        //region Challenge-2,3
        UnaryOperator<String> everySecondChar = source -> {

            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString(); // return is a must in the unary operator
        };

        var result = everySecondChar.apply("*W*h*a*t* *i*s* *t*h*i*s*?");
        System.out.println(result);
        //endregion


        // Tip: Clicking on the gutter icon (the pink lambda on the left (lines 36, 22))
        // will show the associated method to use in the execution.

        //region Challenge-5
        var res = everySecondChar(everySecondChar, "0123456789");
        System.out.println(res);
        //endregion


        //region Challenge-6,7
        Supplier<String> iLoveJava = () -> "I love Java!";
        var supplierResult = iLoveJava.get().toUpperCase();
        System.out.println(supplierResult);
        //endregion

    }

    //region Challenge-4
    public static String everySecondChar(UnaryOperator<String> unaryOperator, String source) {
        return unaryOperator.apply(source);
    }
    //endregion

}