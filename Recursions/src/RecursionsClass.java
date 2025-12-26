import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecursionsClass {

    public static int factorial(int num) {

        if (num < 0) return -1;
        if (num == 0) return 1;

        return num * factorial(num - 1);


    }

    public static int sum(int num) {

        if (num < 0) return -1;
        if (num == 1) return 1;

        return num + sum(num - 1);
    }

    public static int fibonacci(int index) {

        if (index < 0) return -1;
        if (index == 0) return 0;
        if (index == 1) return 1;

        return fibonacci(index - 2) + fibonacci(index - 1);
    }

    public static double exponentiation(double base, int exponent) {

        if (exponent < 0) return (1 / exponentiation(base, exponent * -1));
        if (exponent == 0) return 1;

        return base * exponentiation(base, --exponent);
    }

    public static boolean isPalindrome(String str) {

        return isPalindrome(0, str);
    }

    private static boolean isPalindrome(int index, String str) {

        if (index >= str.length() - index - 1) return true;

        if (str.charAt(index) == str.charAt(str.length() - index - 1)) {
            return isPalindrome(++index, str);
        } else {
            return false;
        }
    }

    public static String reverse(String str) {

        if (str.isBlank()) return "";
        return reverse(str, new StringBuilder(), 0);
    }

    private static String reverse(String str, StringBuilder sb, int i) {

        if (i >= str.length()) return sb.toString();
        sb.append(str.charAt(str.length() - i - 1));
        return reverse(str, sb, ++i);
    }

    public static <T> int instancesCounter(T[] array, T element) {

        return instancesCounter(array, element, 0, 0);
    }

    private static <T> int instancesCounter(T[] array, T element, int index, int counter) {

        if (index >= array.length) return counter;

        if (Objects.equals(array[index], element)) {
            counter++;
        }
        return instancesCounter(array, element, ++index, counter);
    }

    public static int oddNumSum(Integer[] array) {

        return oddNumSum(array, 0, 0);
    }

    private static int oddNumSum(Integer[] array, int sum, int index) {

        if (index >= array.length) return sum;

        if (array[index] % 2 == 1) {
            sum += array[index];
        }
        return oddNumSum(array, sum, ++index);
    }

    public static int findLength(String str) {

        if (str.isEmpty()) return 0;

        return 1 + findLength(str.substring(1));
    }

    public static int digitSum(int num) {

        if (num == 0) return 0;
        int a = num % 10;
        return a + digitSum(num / 10);
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] array) {

        return isSorted(array, 1);
    }

    private static <T extends Comparable<T>> boolean isSorted(T[] array, int index) {

        if (index >= array.length) return true;

        if (array[index - 1].compareTo(array[index]) > 0) {
            return false;
        }
        return isSorted(array, ++index);
    }

    public static List<Integer> getPrimes(int amount) {

        if (amount < 0) return new ArrayList<>();
        return getPrimes(amount, new ArrayList<>(), 2);
    }

    private static List<Integer> getPrimes(int amount, List<Integer> list, int nextNum) {

        if (list.size() == amount) return list;

        if (isPrime(nextNum)) {
            list.add(nextNum);
        }
        return getPrimes(amount, list, ++nextNum);
    }

    public static boolean isPrime(int num) {

        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
