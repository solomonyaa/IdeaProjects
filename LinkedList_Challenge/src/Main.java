import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LinkedList<Place> placesToVisit = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean _continue = true;
        boolean forward = true;

        addPlace(placesToVisit, new Place("Brisbane", 917));
        addPlace(placesToVisit, new Place("Adelaide", 1374));
        addPlace(placesToVisit, new Place("Darwin", 3972));
        addPlace(placesToVisit, new Place("Alice Springs", 2771));
        addPlace(placesToVisit, new Place("Sydney", 0));
        addPlace(placesToVisit, new Place("Perth", 3923));
        addPlace(placesToVisit, new Place("Melbourne", 877));

        var iterator = placesToVisit.listIterator(0);
        printMenu();

        while (_continue) {
            if (!iterator.hasPrevious()) {
                System.out.println("Originating: " + iterator.next());
                forward = true;
            }
            if (!iterator.hasNext()) {
                System.out.println("Final: " + iterator.previous());
                forward = false;
            }

            switch (scanner.nextLine().toLowerCase().substring(0, 1)) {
                case "f" -> {
                    if (!forward) {           // Reversing Direction
                        forward = true;
                        if (iterator.hasNext()) {
                            iterator.next();  // Adjust position forward
                        }
                    }
                    if (iterator.hasNext())
                        System.out.println(iterator.next());
                }
                case "b" -> {
                    if (forward) {           // Reversing Direction
                        forward = false;
                        if (iterator.hasPrevious()) {
                            iterator.previous();  // Adjust position backwards
                        }
                    }
                    if (iterator.hasPrevious())
                        System.out.println(iterator.previous());
                }
                case "l" -> listPlaces(placesToVisit);
                case "m" -> printMenu();
                //case "q" -> _continue = false;
                default -> _continue = false;
            }
        }

    }

    private static void listPlaces(LinkedList<Place> list) {
        var iterator = list.listIterator();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(iterator.next());
        }
    }

    private static void printMenu() {
        System.out.print("""
                Available actions (enter a word or a letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit
                """);
    }

    private static void addPlace(LinkedList<Place> list, Place place) {
        for (Place p : list) {
            if (p.getName().equalsIgnoreCase(place.getName()))
                return;
        }
        var iterator = list.listIterator(0);
        int index = 0;

        while ((iterator.hasNext()) && place.getDistance() > iterator.next().getDistance()) {
            index++;
        }
        list.add(index, place);
    }

}