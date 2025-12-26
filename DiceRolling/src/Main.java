import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> intList = reRoll();

        String textBlock = """
                Press Enter to Score
                Type "All" to re-roll all the dice.
                List numbers (separated by spaces) to re-roll selected dice.
                -->""";

        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Your dice are: " + intList);
            System.out.print(textBlock + " ");
            input = scanner.nextLine().toLowerCase();

            if (input.isEmpty()) {
                System.out.println("Game Over, Score = " + sum(intList));
                break;
            } else if (input.equals("all")) {
                intList = reRoll();
            } else if (extractNumbers(input) != null) {
                var res = extractNumbers(input); // numbers to replace
                intList = replaceFirstOccurrences(intList, res);
            }

        } while (true);
    }

    public static List<Integer> extractNumbers(String input) {

        if (input == null || input.isEmpty()) {
            return null; // Return null for invalid input
        }

        // Regular expression to match numbers separated by spaces
        if (!input.matches("(\\d+\\s?)+")) {
            return null; // Return null if the input is not valid
        }

        // Split the input into numbers
        String[] parts = input.split("\\s+"); // Split by one or more spaces
        List<Integer> numbers = new ArrayList<>();

        for (String part : parts) {
            numbers.add(Integer.parseInt(part)); // Convert each number to an Integer
        }

        return numbers;
    }

    public static List<Integer> reRoll() {

        return new Random().ints(1, 7)
                .limit(5)
                .boxed()
                //.sorted()
                .toList();
    }

    public static List<Integer> replaceFirstOccurrences(List<Integer> intList, List<Integer> numbersToReplace) {
        // Create a set for quick lookup of numbers to replace
        Set<Integer> replaceSet = new HashSet<>(numbersToReplace);

        // Use a map to track if a number has already been replaced
        Map<Integer, Boolean> replaced = new HashMap<>();

        return intList.stream()
                .map(num -> {
                    if (replaceSet.contains(num) && !replaced.getOrDefault(num, false)) {
                        replaced.put(num, true); // Mark as replaced
                        return new Random().nextInt(1, 7);
                    }
                    return num; // Keep the original number
                })
                .collect(Collectors.toList());
    }

    public static int sum(List<Integer> list) {

        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }
        return sum;
    }
}