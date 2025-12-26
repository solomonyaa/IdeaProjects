import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Player player = new Player("Tim", 10, 15);
        Monster monster = new Monster("Werewolf", 20, 40);

        System.out.println(player);
        System.out.println(monster);

        System.out.println("-".repeat(100));

        List<String> list1 = new ArrayList<>();
        list1.add("Max");
        list1.add("20");
        list1.add("25");
        list1.add("Crossbow");

        List<String> list2 = new ArrayList<>();
        list2.add("Dragon");
        list2.add("70");
        list2.add("60");


        player.read(list1);

        monster.read(list2);

        System.out.println(player);
        System.out.println(monster);

    }
}