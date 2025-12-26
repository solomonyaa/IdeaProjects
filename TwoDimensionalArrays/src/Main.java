import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[][] twoDimensionalArray = new int[10][10];
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray.length; j++) {
                twoDimensionalArray[i][j] = (i + 1) * (j + 1);
            }
        }
        print2dArr(twoDimensionalArray);

        print2dArr(create2dStringArray(8));
    }
    public static String[][] create2dStringArray(int size){
        String[][] twodArray = new String[size][size];

        for (int i = 0; i < twodArray.length; i++) {
            for (int j = 0; j < twodArray.length; j++) {
                if(i == j || i + j == size - 1){
                    twodArray[i][j] = "*";
                }
                else{
                    if(i + j < size - 1)
                        twodArray[i][j] = "<";
                    if(i + j > size - 1)
                        twodArray[i][j] = ">";
                }
            }
        }
        return twodArray;
    }
    public static void print2dArr(String[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void print2dArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
}