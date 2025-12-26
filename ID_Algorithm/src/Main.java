import java.util.Random;

public class Main {

    public static void main(String[] args) {

        var id = "310647730";
        System.out.println("The ID: " + id + " is " +
                (checkID(id) ? "valid." : "not valid."));

        id = "31064775";
        var iDigit = inspectionDigit(id);
        System.out.println("The inspection digit for " + id + " is: " + iDigit);

        System.out.println("Random ID: " + getRandomID());
    }

    public static boolean checkID(String id) {

        if (id.length() > 9) return false;

        StringBuilder sb = new StringBuilder(id);

        while (sb.length() < 9) {
            sb.insert(0, "0");
        }

        var strArr = sb.toString().split("");

        int[] numbers = new int[9];

        for (int i = 0; i < 9; i++) {
            numbers[i] = Integer.parseInt(strArr[i]);
        }

        int sum = 0;

        for (int i = 0; i < 9; i++) {
            if (i % 2 == 1) {
                numbers[i] = numbers[i] * 2;
            }
            if (numbers[i] > 9) {
                numbers[i] = (numbers[i] % 10) + 1;
            }
            sum += numbers[i];
        }

        return (sum % 10) == 0;
    }

    public static int inspectionDigit(String id) {

        if (id.length() != 8) return -1;

        var strArr = id.split("");

        int[] numbers = new int[8];

        for (int i = 0; i < 8; i++) {
            numbers[i] = Integer.parseInt(strArr[i]);
        }

        int sum = 0;

        for (int i = 0; i < 8; i++) {
            if (i % 2 == 1) {
                numbers[i] = numbers[i] * 2;
            }
            if (numbers[i] > 9) {
                numbers[i] = (numbers[i] % 10) + 1;
            }
            sum += numbers[i];
        }

        return (10 - (sum % 10)) % 10;
    }

    public static String getRandomID() {

        Random rnd = new Random();

        int[] numbers = new int[9];

        for (int i = 0; i < 8; i++) {

            if (i == 0) {
                numbers[i] = rnd.nextInt(0, 4);
            } else {
                numbers[i] = rnd.nextInt(0, 10);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            sb.append(numbers[i]);
        }

        numbers[8] = inspectionDigit(sb.toString());
        sb.append(numbers[8]);

        return sb.toString();
    }

}