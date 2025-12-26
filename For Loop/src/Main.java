public class Main
{
    public static void main(String[] args)
    {
        /*for (double rate = 7.5; rate <= 10; rate += 0.25)
        {
            double interestAmount = calculateInterest(100.00, rate);
            if (interestAmount > 8.5)
                break;
            System.out.println("$100.00 at " + rate + "% interest = $" + interestAmount);
        }*/

        /*int counter = 0;
        for (int i = 10; i <= 50; i++)
        {
            if (isPrime(i))
            {
                System.out.println(i);
                counter++;
            }
            if (counter >= 3)
                break;
        }*/

        //sum_3_5();
        System.out.println(sumOdd(100, 1000));
    }

    public static double calculateInterest(double amount, double interestRate)
    {
        return (amount * (interestRate / 100));
    }
    public static boolean isPrime(int number)
    {
        if (number <= 1)
            return false;
        if (number == 2)
            return true;
        if(number % 2 == 0)
            return false;

        for (int i = 2; i <= number / 2; i++)
        {
            if (number % i == 0)
                return false;
        }
        return true;
    }
    public static void sum_3_5()
    {
        int counter = 0;
        int sum = 0;
        for (int i = 1; i <= 1000; i++)
        {
            if (i % 3 == 0 && i % 5 == 0)
            {
                sum += i;
                counter++;
                System.out.print(i + ", ");
            }
            if (counter >= 5)
                break;
        }
        System.out.println("\nThe sum of numbers that are divisible by 3 and 5 is: " + sum);
        System.out.println("There are " + counter + " numbers like these.");
    }
    public static boolean isOdd(int number)
    {
        if (number <= 0)
            return false;
        return number % 2 == 1;
    }
    public static int sumOdd(int start, int end)
    {
        if (end < start || start <= 0 || end <= 0)
            return -1;

        int sum = 0;
        for (int i = start; i <= end; i++)
        {
            if (isOdd(i))
            {
                sum += i;
            }
        }
        return sum;
    }
}