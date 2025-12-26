import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
/*

        // Boxing - converting a primitive type into a wrapper class
        // How to box?

        Integer boxedInt = Integer.valueOf(12); // - manually
        Integer boxedInt2 = new Integer(15); // - deprecated code

        Integer boxedInt3 = 13; // - auto-boxing (preferred)

        // Unboxing - returning the primitive type from a wrapper class
        int unboxedInt = boxedInt.intValue(); // - manually
        int unboxedInt2 = boxedInt2; // - auto-unboxing (preferred)

        //* It's only possible to run methods on a boxed type (= on the instance of a wrapper class).
        //* The default value for a wrapper class is null.


        var arrList = getList(1, 2, 3, 4, 5);
        System.out.println(arrList);

        var list = List.of(6, 7, 8, 9, 10); //immutable
        System.out.println(list);
*/

        Customer dave = new Customer("Dave");
        dave.deposit(6500);
        Customer matt = new Customer("Matt");
        matt.deposit(3700);
        Customer sarah = new Customer("Sarah", 21000);
        Customer paul = new Customer("Paul", -50);



        Bank barclays = new Bank("Barclays");
        barclays.addCustomer(dave);
        barclays.addCustomer(matt);
        barclays.addCustomer(sarah);
        barclays.addCustomer(paul);



        System.out.println(barclays.getCustomers());
        barclays.printInfo();
        barclays.addTransaction("Dave", "Matt", 1500);
        barclays.addTransaction("Sarah", "Dave", 5000);
        barclays.addTransaction("Dave", "Paul", 5000);

        barclays.addTransaction("Dave", "Paul", 6000); // won't be performed
        barclays.addTransaction("Paul", "Sarah", 4200);

        System.out.println(barclays.getCustomers());
        barclays.printInfo();

    }

    private static ArrayList<Integer> getList(int... varargs) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : varargs) {
            list.add(num);
        }
        return list;
    }
}