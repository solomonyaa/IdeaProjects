import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String str = "Hello-World";

        var res = str.split("-");

        System.out.println(Arrays.toString(res));

        System.out.println("-".repeat(30));


        String str2 = "0_1_2_3_4_5_6_7_8_9";

        var res2 = str2.split("_", 9);

        System.out.println(Arrays.toString(res2));
    }
}