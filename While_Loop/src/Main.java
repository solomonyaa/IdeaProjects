public class Main
{
    public static void main(String[] args)
    {
        /*int totalEven = 0;
        int totalOdd = 0;

        int j = 5;
        while (j <= 20)
        {
            if (totalEven >= 5)
                break;
            if (isEvenNumber(j))
            {
                System.out.print(j + ", ");
                totalEven++;
            }
            else
                totalOdd++;
            j++;
        }
        System.out.println("\ntotal even: " + totalEven);
        System.out.println("total odd: " + totalOdd);*/

        //System.out.println(sumDigits(547789822));
        //System.out.println(isPalindrome(687));
        //System.out.println(sumFirstAndLastDigit(-7));
        //System.out.println(getEvenDigitSum(445584));
        //System.out.println(hasSharedDigit(9, 9));
        //System.out.println(hasSameLastDigit(937, 14, 81));
        //printFactors(41);
        //System.out.println(getGreatestCommonDivisor(12, 36));
        /*int number = 35;
        String isPerfect = isPerfectNumber(number) ? "a perfect" : "not a perfect";
        System.out.println(number + " is " + isPerfect + " number");*/
        //System.out.println(getDigitCount(12345));
        //System.out.println(reverse(234));
        numberToWords(1000000);
    }

    public static boolean isEvenNumber(int num)
    {
        return num % 2 == 0;
    }
    public static int sumDigits(int number)
    {
        if (number < 0)
            return -1;
        int sum = 0;
        while(number != 0)
        {
            sum += (number % 10);
            number /= 10;
        }
        return sum;
    }
    public static boolean isPalindrome(int number)
    {
        if (number < 0)
            number = number * -1;
        int copy = number;
        int reverse = 0;

        while(number != 0)
        {
            int lastDigit = number % 10;
            reverse *= 10;
            reverse += lastDigit;
            number /= 10;
        }
        return (copy == reverse);
    }

    public static int sumFirstAndLastDigit(int number)
    {
        if(number < 0)
            return -1;

        int lastDigit = number % 10;

        while(number > 9)
        {
            number /= 10;
        }
        int firstDigit = number;

        return firstDigit + lastDigit;
    }

    public static int getEvenDigitSum(int number)
    {
        if(number < 0)
            return -1;
        int sum = 0;

        while(number != 0)
        {
            int lastDigit = number % 10;
            if (lastDigit % 2 == 0)
            {
                sum += lastDigit;
            }
            number /= 10;
        }
        return sum;
    }

    public static boolean hasSharedDigit(int a, int b)
    {
        if (!(a >= 10 && a <= 99) || (!(b >= 10 && b <= 99)))
            return false;
        int copiedB = b;

        while(a != 0)
        {
            int lastDigitA = a % 10;
            while(b != 0)
            {
                int lastDigitB = b % 10;
                if (lastDigitA == lastDigitB)
                    return true;
                b /= 10;
            }
            a /= 10;
            b = copiedB;
        }
        return false;
    }
    public static boolean hasSameLastDigit(int a, int b, int c)
    {
        if (!isValid(a) || !isValid(b) || !isValid(c))
            return false;

        int ld_a = a % 10;
        int ld_b = b % 10;
        int ld_c = c % 10;

        return(ld_a == ld_b || ld_b == ld_c || ld_a == ld_c);
    }
    public static boolean isValid(int number)
    {
        if (number >= 10 && number <= 1000)
            return true;
        return false;
    }

    public static void printFactors(int number)
    {
        if (number < 1)
            System.out.println("Invalid Value");
        int count = 0;
        int index = 1;
        while(index <= number)
        {
            if (number % index == 0)
            {
                System.out.print(index + " ");
                count++;
            }
            index++;
        }
        if (count == 2)
            System.out.println("\n" + number + " is prime");
    }

    public static int getGreatestCommonDivisor(int first, int second)
    {
        if (first < 10 || second < 10)
            return -1;

        int min;
        int max;
        int greatestDivisor = 1;

        if (first <= second)
        {
            min = first;
            max = second;
        }

        else
        {
            min = second;
            max = first;
        }

        for (int index = 1; index <= min; index++)
        {
            if (min % index == 0 && max % index == 0)
            {
                greatestDivisor = index;
            }
        }
        return greatestDivisor;
    }

    public static boolean isPerfectNumber(int number)
    {
        if (number < 1) return false;
        int sumOfDivisors = 0;
        int index = 1;

        while(index < number)
        {
            if (number % index == 0)
            {
                sumOfDivisors += index;
            }
            index++;
        }
        return number == sumOfDivisors;
    }

    public static int getDigitCount(int number)
    {
        if(number < 0)
            return -1;
        int numOfDigits = 0;

        do
        {
            numOfDigits++;
            number /= 10;
        } while (number != 0);

        return numOfDigits;
    }
    public static int reverse(int number)
    {
        int reverse = 0;

        while(number != 0)
        {
            int lastDigit = number % 10;
            reverse *= 10;
            reverse += lastDigit;
            number /= 10;
        }
        return reverse;
    }
    public static void numberToWords(int number)
    {
        if (number < 0)
        {
            System.out.println("Invalid Value");
            return;
        }

        String answer = "";
        int originalNum = number;
        int reversedNum = reverse(number);
        number = reverse(number);

        do
        {
            int lastDigit = number % 10;
            switch (lastDigit) {
                case 0:
                    answer += "Zero ";
                    break;
                case 1:
                    answer += "One ";
                    break;
                case 2:
                    answer += "Two ";
                    break;
                case 3:
                    answer += "Three ";
                    break;
                case 4:
                    answer += "Four ";
                    break;
                case 5:
                    answer += "Five ";
                    break;
                case 6:
                    answer += "Six ";
                    break;
                case 7:
                    answer += "Seven ";
                    break;
                case 8:
                    answer += "Eight ";
                    break;
                case 9:
                    answer += "Nine ";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + lastDigit);
            }
            number /= 10;
        } while (number != 0);

        int difference = getDigitCount(originalNum) - getDigitCount(reversedNum);

        for (int i = 0; i < difference; i++)
        {
            answer += "Zero ";
        }

        System.out.println(answer);
    }
}