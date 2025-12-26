import java.util.Random;

public class Main {

    public static void main(String[] args) {

        var password = passwordGenerator(true, true, 20);
        System.out.println(password);

    }

    public static String passwordGenerator(boolean numbers, boolean symbols, int length) {
        if (length < 10 || length > 100)
            return null;

        Random rnd = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 1; i <= length; i++) {
            int num = rnd.nextInt(33, 127);

            if (!numbers) {
                if (num >= 48 && num <= 57) {
                    length++;
                    continue;
                }
            }
            if (!symbols) {
                if ((num >= 33 && num <= 47) || (num >= 58 && num <= 64)
                        || (num >= 91 && num <= 96) || (num >= 123 && num <= 126)) {
                    length++;
                    continue;
                }
            }

            char c = (char) num;
            password.append(c);
        }

        return password.toString();
    }
}