package Solomon.Dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

record GroceryItem(String name, String type, int count) {
    public GroceryItem(String name) {
        this(name, "Dairy", 1);
    }

    @Override
    public String toString() {
        return String.format("%d %s (%s)", count, name, type);
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {

        GroceryItem[] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apples", "Fruits", 6);
        groceryArray[2] = new GroceryItem("oranges", "Fruits", 5);
        //printArray(groceryArray);

        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
        groceryList.add(new GroceryItem("Yogurt"));
        groceryList.add(new GroceryItem("Milk"));
        groceryList.add(0, new GroceryItem("Tomatoes", "Vegetables", 8));
        groceryList.remove(1);
        System.out.println(groceryList);


        String[] items = {"apples", "bananas", "milk", "eggs"};
        List<String> list = List.of(items);  //immutable
        System.out.println(list);

        ArrayList<String> groceries = new ArrayList<>(list); // mutable
        groceries.add("yogurt");
        System.out.println(groceries);

        ArrayList<String> nextList = new ArrayList<>(
                List.of("pickles", "mustard", "cheese"));
        groceries.addAll(nextList);
        System.out.println(groceries);

        System.out.println("Fourth item is: " + groceries.get(3));

        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);
        System.out.println();

        var groceriesArr = groceries.toArray(new String[groceries.size()]); // converting list to an array
        System.out.println(groceriesArr.length + " items: ");
        printArray(groceriesArr);
        System.out.println("\n" + groceriesArr.getClass().getSimpleName());

        String[] originalArray = new String[]{"First", "Second", "Third"};
        var originalList = Arrays.asList(originalArray); // converting array into an array-list
        System.out.println(originalList.getClass().getSimpleName());

        originalList.set(0, "One"); // any change made to the list affects the array as well
        System.out.println("list: " + originalList);
        System.out.println("array: " + Arrays.toString(originalArray));


        ArrayList<String> sl = new ArrayList<>(List.of("January", "February", "March"));
        String[] sa = sl.toArray(new String[0]);
        System.out.println("length of array = " + sa.length);
        printArray(sa);


    }

    public static void printArray(Object[] arr) {
        for (Object o : arr) {
            System.out.print(o + ", ");
        }
    }
}
