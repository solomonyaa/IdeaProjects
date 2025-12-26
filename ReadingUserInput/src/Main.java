import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int currentYear = 2023;

        /*try
        {
            System.out.println(getInputFromConsole(currentYear));
        } catch (NullPointerException e)
        {
            System.out.println(getInputFromScanner(currentYear));
        }*/

        //System.out.println(getLargestPrime1(7));
        printSquareStar(5);

        //inputChallenge();
        //min_max_Challenge();

        //inputThenPrintSumAndAverage();

        //System.out.println(getBucketCount(3.26, 0.75));

        //multiplicationTable();
    }

    public static String getInputFromConsole(int currentYear)
    {
        String name = System.console().readLine("Hi, What's your name? ");
        System.out.println("Hi " + name);

        String dateOfBirth = System.console().readLine("What year were you born? ");
        int age = currentYear - Integer.parseInt(dateOfBirth);

        return "So you are " + age + " years old.";
    }
    public static String getInputFromScanner(int currentYear)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi. What's your name? ");
        String name = scanner.nextLine();

        System.out.println("Hi " + name);
        System.out.println("What year were you born? ");

        int age = -1;
        do
        {
            System.out.println("Enter a year of birth >= " + (currentYear - 125) + " and <= " + currentYear);
            String dateOfBirth = scanner.nextLine();
            try
            {
                age = checkData(currentYear, dateOfBirth);
            } catch(NumberFormatException badUserData)
            {
                System.out.println("Characters not allowed! Try again.");
            }

        } while(age == -1);

         return "So you are " + age + " years old.";
    }

    public static int checkData(int currentYear, String dataOfBirth) // validation method
    {
        int dob = Integer.parseInt(dataOfBirth);
        int minimumYear = currentYear - 125;

        if ((dob < minimumYear) || (dob > currentYear))
            return -1; // invalid value

        return currentYear - dob; // Age
    }

    public static boolean canPack(int bigCount, int smallCount, int goal)
    {
        if (bigCount < 0 || smallCount < 0 || goal < 0) return false;

        int flourKG = (bigCount * 5) + smallCount;

        if (flourKG < goal)
            return false;
        if(flourKG == goal)
            return true;

        if(flourKG > goal)
        {
            if((goal % 5) <= smallCount)
                return true;
            else
                return false;
        }
        return false;
    }
    public static int getLargestPrime(int number)
    {
        if(number < 2)
            return -1;

        int maxPrime = -1;

        for (int i = 2; i < number; i++)
        {
            if (number % i == 0 && isPrime(i))
            {
                maxPrime = i;
            }
        }
        return maxPrime;
    }
    public static boolean isPrime(int number)
    {
        if(number < 2) return false;
        if(number == 2) return true;
        if(number % 2 == 0) return false;

        for (int i = 2; i < number / 2; i++)
        {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static int getLargestPrime1(int number)
    {
        if(number < 2)
            return -1;

        int maxPrime = -1;
        boolean isPrime = true;

        for (int i = 2; i <= number; i++)
        {
            for (int j = 2; j < i; j++)
            {
                if (number % i == 0 && i % j == 0)
                {
                    isPrime = false;
                    break;
                }
            }
            if (number % i == 0 && isPrime)
            {
                maxPrime = i;
            }
        }
        return maxPrime;
    }
    public static void printSquareStar(int number)
    {
        if (number < 5)
        {
            System.out.println("Invalid Value");
            return;
        }

        for (int i = 1; i <= number; i++)
        {
            for (int j = 1; j <= number; j++)
            {
                if (i == 1 || i == number || i == j || j == 1 || j == number || j == number - i + 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void inputChallenge()
    {
        int sum = 0;
        int counter = 1;
        Scanner scanner = new Scanner(System.in);

        do
        {
            System.out.print("Please enter number #" + counter + ": ");
            String input = scanner.nextLine();
            try
            {
                int num = Integer.parseInt(input); // if is not valid lines 181, 182 are skipped
                counter++;
                sum += num;
            }catch (NumberFormatException nfe)
            {
                System.out.println("Invalid Number");
            }

        } while(counter <= 5);

        System.out.println("sum = " + sum);
    }

    public static void min_max_Challenge()
    {
        Scanner scanner = new Scanner(System.in);
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        do
        {
            System.out.println("Please enter a number to continue or any character to quit: ");
            String input = scanner.nextLine();

            try
            {
                double num = Double.parseDouble(input);
                if(num > max)
                    max = num;
                if(num < min)
                    min = num;
            }catch(NumberFormatException nfe)
            {
                break;
            }
        } while (true);
        System.out.println("minimum = " + min + ", maximum = " + max);
    }

    public static void inputThenPrintSumAndAverage()
    {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        long avg = 0;
        int counter = 0;

        while(true)
        {
            String input = scanner.nextLine();
            try
            {
                int num = Integer.parseInt(input);
                counter++;
                sum += num;
            }catch(NumberFormatException nfe)
            {
                break;
            }
        }
        if(counter != 0)
            avg = Math.round((double) sum / counter);
        System.out.println("SUM = " + sum + " AVG = " + avg);
    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets)
    {
        if(width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0)
            return -1;

        double numOfBucketsFrac = ((width * height) - (areaPerBucket * extraBuckets)) / areaPerBucket;
        return (int)Math.ceil(numOfBucketsFrac);
    }
    public static int getBucketCount(double width, double height, double areaPerBucket)
    {
        if(width <= 0 || height <= 0 || areaPerBucket <= 0)
            return -1;

        double numOfBucketsFrac = ((width * height)) / areaPerBucket;
        return (int)Math.ceil(numOfBucketsFrac);
    }
    public static int getBucketCount(double area, double areaPerBucket)
    {
        if(area <= 0 || areaPerBucket <= 0)
            return -1;

        double numOfBucketsFrac = area / areaPerBucket;
        return (int)Math.ceil(numOfBucketsFrac);
    }

    public static void multiplicationTable()
    {
        for (int i = 1; i <= 10; i++)
        {
            for (int j = 1; j <= 10; j++)
            {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }
}