import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static final ArrayList<String> groceries = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean _continue = true;

        while (_continue) {
            System.out.print("""
                    Available actions:
                    0 - to shutdown
                    1 - to add item(s) to list
                    2 - to remove any item(s)
                    Enter a number for which action you want to do:\s""");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1 -> addItems();
                case 2 -> removeItems();
                default -> _continue = false;
            }
            printList();
        }
    }

    public static void addItems() {
        System.out.println("Enter item(s) separated by a comma to be added to the list");
        String[] items = scanner.nextLine().split(",");

        for (String item : items) {
            String trimmed = item.trim();
            if (!groceries.contains(trimmed))
                groceries.add(trimmed);
        }
    }

    public static void removeItems() {
        System.out.println("Enter item(s) separated by a comma to be removed from the list");
        String[] items = scanner.nextLine().split(",");

        for (String item : items) {
            String trimmed = item.trim();
            groceries.remove(trimmed);
        }
    }

    public static void printList() {
        groceries.sort(Comparator.naturalOrder());
        if (!groceries.isEmpty())
            System.out.println("Current list of groceries: " + groceries);
        else
            System.out.println("The list is empty");
    }
}