import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //ASCII
        // filter retains all elements that meet the condition
        // dropWhile will continue until the condition is met and then will exit
        // combined with takeWhile it will determine the range of an ordered stream
        IntStream.iterate((int) 'A', i -> i <= (int) 'z', i -> i + 1)
                .filter(Character::isAlphabetic)
                .map(Character::toUpperCase)
                .distinct()
/*                .dropWhile(i -> i <= 'E')
                .takeWhile(i -> i < 'a')*/
/*                .skip(5)*/
/*                .filter(i -> Character.toUpperCase(i) > 'E')*/
                .forEach(i -> System.out.printf("%c = %d %n", i, i));

        System.out.println("-".repeat(60));
        Random rnd = new Random();

        Stream.generate(() -> rnd.nextInt((int) 'A', (int) 'Z' + 1))
                .limit(50)
                .distinct()
                .sorted()
                .forEach(c -> System.out.printf("%c ", c));

        System.out.println("\n" + "-".repeat(60));

        var abc = Stream
                .iterate((int) 'A', i -> i <= (int) 'z', i -> i + 1)
                .map(c -> (char) c.intValue())
                .filter(Character::isAlphabetic)
                .dropWhile(c -> c < 'a');

        abc.forEach(c -> System.out.print(c + " "));

        System.out.print("\n" + "-".repeat(60));
        System.out.println();
        int maxSeats = 100;
        int seatsInRow = 10;

        var stream =
                Stream.iterate(0, i -> i < maxSeats, i -> i + 1)
                        .map(i -> new Seat((char) (65 + (i / seatsInRow)),
                                ((i % seatsInRow) + 1)))
                        .sorted(Comparator.comparing(Seat::price)
                                .thenComparing(Seat::toString));
                        /*.mapToDouble(Seat::price)
                        .mapToObj("%.2f"::formatted)
                        .boxed()
                        .map("%.2f"::formatted);*/
        stream.forEach(System.out::println);
    }
}