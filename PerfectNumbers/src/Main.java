public class Main {

    public static void main(String[] args) {

        int[] arrayOfP = new int[]{2, 3, 5, 7, 13, 17, 19, 31};

        for (int p : arrayOfP) {
            System.out.println("p = " + p + " -->\t" + generatePerfectNumber(p));
        }

        //generatePerfectNumbers();

    }

    public static void generatePerfectNumbers() {
        long perfectNum;
        for (int p = 1; p <= 31; p++) {
            if (isPrime(p)) {
                if (isPrime((long) Math.pow(2, p) - 1)) {
                    perfectNum = (long) ((Math.pow(2, p) - 1) * (Math.pow(2, p - 1)));
                    System.out.println("p = " + p +
                            ", Mersenne prime = " + (long) (Math.pow(2, p) - 1) +
                            ", Perfect number = " + perfectNum);
                }
            }
        }
    }

    public static long generatePerfectNumber(long p) {

        long j = p;
        long sum = 0;
        long i;
        for (i = 1; j != 0; i *= 2) {
            sum += i;
            j--;
        }

        if (isPrime(sum)) {
            return sum * (i / 2);
        } else {
            return generatePerfectNumber(++p);
        }
    }

    public static boolean isPrime(long num) {
        if (num < 2)
            return false;
        if (num == 2)
            return true;
        if (num % 2 == 0)
            return false;

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}