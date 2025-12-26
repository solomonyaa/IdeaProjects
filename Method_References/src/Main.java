import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;

class PlainOld {

    private static int last_id = 1;

    private int id;

    public PlainOld() {
        this.id = PlainOld.last_id++;
        System.out.println("Creating a PlainOld Object: id = " + id);
    }
}

public class Main {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>(List.of(
                "Anna", "Bob", "Chuck", "Dave"));

        //list.forEach(s -> System.out.println(s));
        list.forEach(System.out::println);

        //(a, b) -> a + b => function, 10 => value1, 25 => value2
        calculator((a, b) -> a + b, 10, 25);

        //Integer::sum => function, 10 => value1, 25 => value2
        calculator(Integer::sum, 10, 25);

        //Double::sum => function, 2.5 => value1, 7.5 => value2
        calculator(Double::sum, 2.5, 7.5);

        //PlainOld::new == () -> new PlainOld()
        Supplier<PlainOld> reference1 = PlainOld::new;

        var po1 = reference1.get();

        System.out.println("Getting Array");
        var poArr = seedArray(PlainOld::new, 5);

        //(s1, s2) -> s1.concat(s2) == String::concat
        calculator(String::concat, "Hello ", "World");

        BinaryOperator<String> b1 = String::concat;
        BiFunction<String, String, String> b2 = String::concat;
        UnaryOperator<String> u1 = String::toUpperCase;

        System.out.println(b1.apply("Binary ", "Operator"));
        System.out.println(b2.apply("Bi ", "Function"));
        System.out.println(u1.apply("Unary Operator"));

        String res = "Hello".transform(u1);
        System.out.println("toUpperCase = " + res);

        res = "Hello".transform(String::toLowerCase);
        System.out.println("toLowerCase = " + res);

        Function<String, Boolean> f0 = String::isEmpty;
        var resultBoolean = res.transform(f0);
        System.out.println("isEmpty = " + resultBoolean);


        //region Method Reference Challenge

        String[] names = {"Anna", "Bob", "Charlie", "David", "Elon"};

        UnaryOperator<String> unaryToUpperCase = String::toUpperCase;
        Function<String, String> middleInitialFun = source ->
                source + " " + (char) new Random().nextInt(65, 91) + ". ";
        Function<String, String> reverseNameFunction = source ->
                source + new StringBuilder(source.split(" ")[0]).reverse();
        Function<String, String> isEqualFun = source ->
        {
            boolean isEqual = source.split(" ")[0].compareTo(source.split(" ")[2]) == 0;
            return source + " (" + isEqual  + ")";
        };


        List<Function<String, String>> functionList = new ArrayList<>();
        functionList.add(unaryToUpperCase);
        //functionList.add(Main::reverse);
        functionList.add(middleInitialFun);
        functionList.add(reverseNameFunction);
        functionList.add(isEqualFun);

        transformNames(names, functionList);

        System.out.println(Arrays.toString(names));

        //endregion

    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {

        T result = function.apply(value1, value2);
        System.out.println("Result: " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {

        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }

    private static void transformNames(String[] names, List<Function<String, String>> functionList){

        for (int i = 0; i < names.length; i++) {
            for (Function<String, String> function : functionList) {
                names[i] = names[i].transform(function);
            }
        }
    }

    private static String reverse(String s){
        return reverse(s, 0, s.length());
    }
    private static String reverse(String s, int start, int end){
        return new StringBuilder(s.substring(start, end)).reverse().toString();
    }
}