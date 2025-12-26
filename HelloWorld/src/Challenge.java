public class Challenge
{
    public static void main(String[] args)
    {
        double firstNum = 30.00d;
        double secondNum = 80.00d;
        double result = (firstNum + secondNum) * 100.00d;
        double remainder = result % 40.00d;
        boolean isRemainderZero = (remainder == 0.00) ? true : false;
        System.out.println("isRemainderZero = " + isRemainderZero);
        if (!isRemainderZero)
            System.out.println("got some remainder; " + remainder);

    }
}
