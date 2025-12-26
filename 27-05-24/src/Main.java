public class Main {

    public static void main(String[] args) {

        int num = 1;
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = num++;
        }

        for (int element : arr){
            System.out.println(element);
        }


        int seed = 1;
        
    }
}