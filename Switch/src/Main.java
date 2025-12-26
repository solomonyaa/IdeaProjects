import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class Main
{
    public static void main(String[] args)
    {
        /*//region Switch_1
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int switchValue;
        try
        {
            switchValue = Integer.parseInt(input.readLine());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        switch (switchValue) {
            case 1:
                System.out.println("Value = 1");
                break;
            case 2:
                System.out.println("Value = 2");
                break;
            default:
                System.out.println("Value = " + switchValue);
                break;
        }
        //endregion*/

        //System.out.println(natoAlphabet('C') + " " + natoAlphabet('B'));
        //System.out.println(dayOfWeek(2));
        //System.out.println(printNumberInWord(8));

        System.out.println(getDaysInMonth(2, 2023) + " days");
    }

    public static String natoAlphabet(char letter)
    {
        return switch (letter) {
            case 'A' -> "Able";
            case 'B' -> "Baker";
            case 'C' -> "Charlie";
            case 'D' -> "Dog";
            case 'E' -> "Easy";
            default -> letter + " was not found.";
        };
    }
    public static String dayOfWeek(int day)
    {
        String dayOfWeek = switch (day)
        {
            case 0 -> { yield "Sunday"; }
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid Day";
        };
        return dayOfWeek;
    }
    public static String printNumberInWord(int number)
    {
        return switch (number)
        {
            case 0 -> "ZERO";
            case 1 -> "ONE";
            case 2 -> "TWO";
            case 3 -> "THREE";
            case 4 -> "FOUR";
            case 5 -> "FIVE";
            case 6 -> "SIX";
            case 7 -> "SEVEN";
            case 8 -> "EIGHT";
            case 9 -> "NINE";
            default -> "OTHER";
        };
    }
    public static boolean isLeapYear(int year)
    {
        if (year < 1 || year > 9999)
            return false;

        if (year % 4 == 0)
        {
            if (year % 100 == 0)
            {
                if (year % 400 == 0)
                    return true;
                else
                    return false;
            }
            else
                return true;
        }
        else
            return false;
    }
    public static int getDaysInMonth(int month, int year)
    {
        if (month < 1 || month > 12)
            return -1;
        if (year < 1 || year > 9999)
            return -1;

        int res;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                res = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                res = 30;
                break;
            case 2:
                if (isLeapYear(year))
                    res = 29;
                else
                    res = 28;
                break;
            default:
                res = -1;
                break;
        }
        return res;
    }
}