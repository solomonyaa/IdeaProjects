package Solomon.Dev;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] intArray = new int[11];

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i * 9;
            System.out.print(intArray[i] + ", ");
        }
        newLine();


        for (int element : intArray) { // for-each / enhanced loop
            System.out.print(element / 9 * 7 + ", ");
        }

        newLine();
        System.out.println(Arrays.toString(intArray));

        Object objectVar = intArray;

        System.out.printf("Is objectVar an array of integers? %n%b", objectVar instanceof int[]);
        newLine();

        Object[] objects = new Object[4];
        objects[0] = "Hello";
        objects[1] = new StringBuilder("World");
        objects[2] = intArray;
        objects[3] = new String[]{"I'm ", "starting ", "to understand!"};


        for (Object element : objects) {
            System.out.print(element + ", ");
        }
        newLine();

        for (Object element : objects) {
            System.out.print(element.getClass() + ", ");
        }
        newLine();

        String[] sentence = (String[]) objects[3];
        for (String word : sentence) {
            System.out.print(word);
        }

        newLine();
        var rndArr = getRandomArray(5, 100);
        System.out.println(Arrays.toString(rndArr));
        Arrays.sort(rndArr);
        System.out.println(Arrays.toString(rndArr));
        newLine();

        var arr1 = getRandomArray(5, 100);
        System.out.println(Arrays.toString(arr1));
        var arr2 = sortArray(arr1);
        System.out.println(Arrays.toString(arr2));
        newLine();

        /*var intArr = getIntegers(5);
        printArray(sortArray(intArr));
        newLine();*/

        /*var integerArray = readIntegers();
        System.out.println(Arrays.toString(integerArray));
        System.out.println("The minimum value is: " + findMin(integerArray));
        System.out.println("The maximum value is: " + findMax(integerArray));*/

        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        reverse(arr); // This method changes the passed array
        System.out.println(Arrays.toString(arr));
    }

    public static void newLine() {
        System.out.printf("%n%s%n", "-".repeat(100));
    }

    public static int[] getRandomArray(int length, int maxValue) {

        Random rnd = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(maxValue + 1);
        }
        return arr;
    }

    public static int[] getIntegers(int length) {
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        int[] arr = new int[length];

        while (index < length) {
            System.out.print("Please enter the next number: ");
            int number = scanner.nextInt();
            arr[index] = number;
            index++;
        }
        return arr;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + ": " + array[i]);
        }
    }

    public static int[] sortArray(int[] arr) {

        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        boolean continueSorting = true;
        int temp;

        while (continueSorting) {
            continueSorting = false;
            for (int i = 0; i < sortedArr.length - 1; i++) {
                if (sortedArr[i] < sortedArr[i + 1]) {
                    temp = sortedArr[i];
                    sortedArr[i] = sortedArr[i + 1];
                    sortedArr[i + 1] = temp;
                    continueSorting = true;
                }
            }
        }
        return sortedArr;
    }

    public static int[] readIntegers() {

        Scanner s = new Scanner(System.in);
        System.out.println("Please enter numbers separated by commas:");
        String input = s.nextLine();
        String[] stringArr = input.split(",");

        int[] intArr = new int[stringArr.length];

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(stringArr[i].trim());
        }
        return intArr;
    }

    public static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

}
