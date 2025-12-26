import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /*System.out.println(reverse("house"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(translateToPigLatin("pig"));*/

        int[] arr = new int[]{4, 3, 7, 1, 5, 2, 6, 0};
        System.out.println(isConsecutive(arr));

    }

    public static boolean isConsecutive(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + 1 != arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String str) {
        return str.compareTo(reverse(str)) == 0;
    }

    public static String reverse(String str) {

        StringBuilder reversed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }

        return String.valueOf(reversed);
    }

    public static String translateToPigLatin(String str) {

        StringBuilder sb = new StringBuilder();

        if (isVowel(str.charAt(0))) {
            sb.append(str);
            sb.append("way");
            return String.valueOf(sb);
        }

        StringBuilder suffix = new StringBuilder();

        while (!isVowel(str.charAt(0))) {
            suffix.append(str.charAt(0));
            str = str.substring(1);
        }

        sb.append(str);
        sb.append(suffix);
        sb.append("ay");

        return String.valueOf(sb);
    }

    public static boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }
}