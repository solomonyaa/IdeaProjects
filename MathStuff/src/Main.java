public class Main {
    public static void main(String[] args) {

        /*int number = -5;
        String str = number >= 1 ? "Number of Steps: " + collatz(number) : "Please enter a natural number";
        System.out.print(str);*/

        //fibonacci(20);

        System.out.println(factorial(3));
        System.out.println(factorialRecursion(5));
    }

    public static int collatz(int num) {
        if (num < 1) return -1;

        int numOfSteps = 0;
        while (num != 1) {
            System.out.print(num + "->");
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = (num * 3) + 1;
            }
            numOfSteps++;
        }
        System.out.println(num);
        return numOfSteps;
    }

    public static void fibonacci(int num) {
        int num1 = 1;
        int num2 = 1;
        if (num == 0) return;
        else if (num == 1) {
            System.out.print(num1);
            return;
        }
        System.out.print(num1 + ", " + num2 + ", ");
        for (int i = 1; i <= num - 2; i++) {
            int next = num1 + num2;
            System.out.print(next + ", ");
            num1 = num2;
            num2 = next;
        }
        double goldenRatio = (double) num2 / num1;
        System.out.printf("\nThe golden ratio is: %.3f", goldenRatio);
    }

    public static int factorial(int num) {

        if(num < 0)
            return -1;
        if(num == 0)
            return 1;

        for (int i = num - 1; i >= 1; i--) {
            num *= i;
        }
        return num;
    }

    public static int factorialRecursion(int num) {

        if(num < 0)
            return -1;
        if(num == 0 || num == 1)
            return 1;

        return factorialRecursion(num - 1) * num;
    }

}