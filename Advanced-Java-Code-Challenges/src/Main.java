import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        var res = reverseString("ymedacAedoC");
        System.out.println(res);

        int num = 101;

        var res2 = isPrime(num);
        System.out.println("Is " + num + " a prime number? " + res2);

        Singleton singleton = Singleton.getSingleInstance();
        System.out.println(singleton.str);

        singleton.str = reverseString(singleton.str);
        System.out.println(singleton.str);

        MySingleton my_singleton = MySingleton.getSingleInstance();
        System.out.println(my_singleton.str);

        lambdaExp(1074701);

        var phoneNumber = phoneNumberDecoder("101-23 Hello");
        System.out.println(phoneNumber);

        int[] numArr = {6, 7, 5, 4, 3};
        var res3 = consecutiveNumbers(numArr);
        System.out.println("Are numbers consecutive? " + res3);
    }

    private static String reverseString(String input) {

        StringBuilder output = new StringBuilder();

        var arr = input.toCharArray();

        for (int i = input.length() - 1; i >= 0; i--) {
            output.append(arr[i]);
        }

        return output.toString();
    }

    private static boolean isPrime(int num) {

        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private static void lambdaExp(int num) {

        Predicate<Integer> isOdd = (n) -> (n % 2 == 1);
        System.out.println(num + " is " + (isOdd.test(num) ? "odd" : "even"));

        Predicate<Integer> isPrime = (n) -> isPrime(n);
        System.out.println(num + ((isPrime.test(num) ? " is" : " isn't") + " prime"));

        Predicate<String> isPalindrome = (s) ->
                s.contentEquals(new StringBuilder(s).reverse());
        System.out.println(num + ((isPalindrome.test(String.valueOf(num)) ? " is" : " isn't") + " a palindrome"));
    }

    private static String phoneNumberDecoder(String input) {

        var charArray = input.toUpperCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder output = new StringBuilder();

        for (char c : charArray) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                sb.append(c);
            }
        }

        // validation
        if (sb.length() != 10) {
            throw new IllegalArgumentException("Please check your input.");
        }

        charArray = sb.toString().toCharArray();

        Map<Character, Character> letterToDigitMap = getCharacterCharacterMap();

        for (int i = 0; i < 10; i++) {

            // converting letter to number
            if (Character.isLetter(charArray[i])) {
                charArray[i] = letterToDigitMap.get(charArray[i]);
            }
        }

        // formatting
        for (int i = 0; i < 10; i++) {
            if (i == 0)
                output.append("(");
            output.append(charArray[i]);
            if (i == 2)
                output.append(") ");
            if (i == 5)
                output.append("-");
        }

        return output.toString();
    }

    private static Map<Character, Character> getCharacterCharacterMap() {

        Map<Character, Character> letterToDigitMap = new HashMap<>();
        letterToDigitMap.put('A', '2');
        letterToDigitMap.put('B', '2');
        letterToDigitMap.put('C', '2');
        letterToDigitMap.put('D', '3');
        letterToDigitMap.put('E', '3');
        letterToDigitMap.put('F', '3');
        letterToDigitMap.put('G', '4');
        letterToDigitMap.put('H', '4');
        letterToDigitMap.put('I', '4');
        letterToDigitMap.put('J', '5');
        letterToDigitMap.put('K', '5');
        letterToDigitMap.put('L', '5');
        letterToDigitMap.put('M', '6');
        letterToDigitMap.put('N', '6');
        letterToDigitMap.put('O', '6');
        letterToDigitMap.put('P', '7');
        letterToDigitMap.put('Q', '7');
        letterToDigitMap.put('R', '7');
        letterToDigitMap.put('S', '7');
        letterToDigitMap.put('T', '8');
        letterToDigitMap.put('U', '8');
        letterToDigitMap.put('V', '8');
        letterToDigitMap.put('W', '9');
        letterToDigitMap.put('X', '9');
        letterToDigitMap.put('Y', '9');
        letterToDigitMap.put('Z', '9');

        return letterToDigitMap;
    }

    private static boolean consecutiveNumbers(int[] numArray) {

        Arrays.sort(numArray);

        for (int i = 0; i < numArray.length - 1; i++) {

            if (numArray[i] + 1 != numArray[i + 1]) {
                return false;
            }
        }
        return true;
    }

    
}