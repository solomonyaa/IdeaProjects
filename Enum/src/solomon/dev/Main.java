package solomon.dev;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        /*DayOfTheWeek day = DayOfTheWeek.TUESDAY;
        System.out.println(day);
        System.out.printf("Name = %s, Ordinal Value = %d%n", day.name(), day.ordinal());*/

        System.out.println(getDay(3));

        for (int i = 0; i < 10; i++) {
            DayOfTheWeek day = getRandomDay();
            System.out.printf("Name = %s, Ordinal Value = %d%n", day.name(), day.ordinal());
            if(day == DayOfTheWeek.SUNDAY)
                System.out.println("It's Sunday!!");
        }
        
        for (Topping topping : Topping.values()){
            System.out.println(topping.name() + ": $" + topping.getPrice());
        }


        /*Dice d1 = new Dice();
        Dice d2 = new Dice();

        for (int i = 0; i < 20; i++) {
            int res1 = d1.roll();
            int res2 = d2.roll();

            System.out.printf("[%d], [%d], %s%n", res1, res2, ((res1 == res2) ? "double!" : ""));
        }*/

    }
    public static DayOfTheWeek getRandomDay(){
        int rndInt = new Random().nextInt(7);
        var days = DayOfTheWeek.values();
        return days[rndInt];
    }
    public static DayOfTheWeek getDay(int i){
        if(i >= 1 && i <= 7){
            var days = DayOfTheWeek.values();
            return days[i - 1];
        }
        return null;
    }
}