package Solomon.Dev;

import java.util.Scanner;

public class MinimumElement {

    public static void main(String[] args) {

        var number = readInteger();
        var arr = readElements(number);
        var min = findMin(arr);
        System.out.printf("min = %d", min);
    }

    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number of elements: ");
        int i = scanner.nextInt();
        return i;
    }

    private static int[] readElements(int elements) {

        Scanner s = new Scanner(System.in);
        int[] intArr = new int[elements];

        System.out.println("Please enter the elements values: ");

        for (int i = 0; i < elements; i++) {
            intArr[i] = s.nextInt();
        }
        return intArr;
    }

    private static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
