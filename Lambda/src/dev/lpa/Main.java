package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> natoAlphabet = new ArrayList<>(List.of(
                "alfa", "bravo", "charlie", "delta", "echo", "foxtrot"
        ));

        for (var word : natoAlphabet) {
            System.out.println(word);
        }

        System.out.println("-".repeat(20));

        // Lambda Expression #1
        natoAlphabet.forEach(word -> System.out.println(word));

        System.out.println("-".repeat(20));

        // Lambda Expression #2
        natoAlphabet.forEach((var word) -> {
            char c = word.toUpperCase().charAt(0);
            System.out.println(word + " means " + c);
        });

        System.out.println("-".repeat(20));

        // Getting back an Integer wrapper instance (the lambda expression performs an automatic boxing)
        var result = calculator((var a, var b) -> a + b, 5, 2);

        // Getting back a Double wrapper instance
        var result2 = calculator((a, b) -> a / b, 12.0, 4.0);

        var result3 = calculator((a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "oll", "korrect");

        var result4 = calculator((a, b) -> {
            var c = a.toUpperCase().charAt(0) + "" + b.toUpperCase().charAt(0);
            return c;
        }
        , "oll", "korrect");


        var result5 = calculator2((list) -> {
                    int sum = 0;
                    for (var element : list){
                        sum += element;
                    }

                    return sum;
                }, Arrays.asList(1, 2, 3, 4, 5));

        var result6 = calculator2((sentence) -> {
            StringBuilder res = new StringBuilder();

            for (var element : sentence){
                res.append(element);

                if(sentence.get(sentence.size() - 1).equals(element)){
                    res.append(".");
                }
                else{
                    res.append(" ");
                }
            }

            return res.toString();
        }, Arrays.asList("This", "is", "a", "sentence"));
    }

    // A public, static, generic method.
    public static <T> T calculator(Operation<T> function, T value1, T value2) {

        T result = function.operate(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }

    public static <T> T calculator2(MultiOperation<T> function, List<T> list) {

        T result = function.operate(list);
        System.out.println("Result of operation: " + result);
        return result;
    }
}