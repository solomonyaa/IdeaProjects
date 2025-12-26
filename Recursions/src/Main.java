import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int res = RecursionsClass.factorial(5);
        System.out.println("5! = " + res);

        res = RecursionsClass.sum(10);
        System.out.printf("Σ{1,2,3,…,10} = %d%n", res);

        int index = 8;
        res = RecursionsClass.fibonacci(index);
        System.out.printf("Fibonacci(%d) = %d%n", index, res);

        int base = 2;
        int exponent = 8;
        double res2 = RecursionsClass.exponentiation(base, exponent);
        System.out.printf("%d^%d = %s%n", base, exponent, res2);

        String str = "deified";
        boolean isPalindrome = RecursionsClass.isPalindrome(str);
        System.out.printf("'%s' is a palindrome = %b%n", str, isPalindrome);

        str = "главрыба";
        String reversed = RecursionsClass.reverse(str);
        System.out.printf("'%s' reversed is: '%s'%n", str, reversed);

        Integer[] int_arr = new Integer[]{1, 3, 2, 1, 1, 3, 2, 1};
        int element = 1;

        int counter = RecursionsClass.instancesCounter(int_arr, element);
        System.out.printf("Number of instances of '%d' in: %s = %d%n",
                element, Arrays.toString(int_arr), counter);

        counter = RecursionsClass.oddNumSum(int_arr);
        System.out.printf("Sum of odd numbers in: %s = %d%n",
                Arrays.toString(int_arr), counter);

        str = "Hello World!";
        counter = RecursionsClass.findLength(str);
        System.out.printf("Length of '%s' = %d%n", str, counter);

        int num = 7603;
        int sum = RecursionsClass.digitSum(num);
        System.out.printf("Digits sum for %d = %d%n", num, sum);

        Integer[] int_arr_2 = new Integer[]{7, 11, 13, 17, 19, 18};
        boolean result = RecursionsClass.isSorted(int_arr_2);
        System.out.printf("%s is sorted = %b%n", Arrays.toString(int_arr_2), result);

        boolean primeOrNot = RecursionsClass.isPrime(num);
        System.out.printf("%d is prime = %b%n", num, primeOrNot);

        int amount = 7;
        var primes = RecursionsClass.getPrimes(amount);
        System.out.printf("The first %d prime numbers = %s%n", amount, primes);
    }
}