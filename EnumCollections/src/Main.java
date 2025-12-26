import java.util.*;


public class Main {

    // Adjusted to the insane jewish week!
    enum WeekDay {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}

    public static void main(String[] args) {

        List<WeekDay> annsWorkdays = new ArrayList<>(List.of(WeekDay.MONDAY,
                WeekDay.TUESDAY, WeekDay.THURSDAY, WeekDay.FRIDAY));

        var annsDaySet = EnumSet.copyOf(annsWorkdays);
        System.out.println(annsDaySet.getClass().getSimpleName());

        // Ann's EnumSet bit vector:
        // 0, 1, 1, 0, 1, 1, 0,

        annsDaySet.forEach(System.out::println);

        var allDaysSet = EnumSet.allOf(WeekDay.class);
        System.out.println("-".repeat(20));
        allDaysSet.forEach(System.out::println);


        // All the days Ann doesn't work
        // EnumSet bit vector: 1, 0, 0, 1, 0, 0, 1
        Set<WeekDay> newPersonDays = EnumSet.complementOf(annsDaySet);
        System.out.println("-".repeat(20));
        newPersonDays.forEach(System.out::println);


        System.out.println("newPersonDays EnumSet bit vector:");
        allDaysSet.forEach(e -> {
            if (newPersonDays.contains(e)) {
                System.out.print(1 + ", ");
            } else {
                System.out.print(0 + ", ");
            }
        });

        System.out.println();

        Set<WeekDay> anotherWay = EnumSet.copyOf(allDaysSet);
        anotherWay.removeAll(annsDaySet);
        System.out.println(anotherWay);

        Set<WeekDay> anotherWay2 = EnumSet.copyOf(allDaysSet);
        anotherWay2.retainAll(newPersonDays);
        System.out.println(anotherWay2);

        System.out.println("Is equals? " + anotherWay.equals(anotherWay2));

        // range
        Set<WeekDay> businessDays = EnumSet.range(WeekDay.SUNDAY, WeekDay.THURSDAY);
        System.out.println(businessDays);

        ////////////////////////////////////////////////////////////

        Map<WeekDay, String[]> employeesMap = new EnumMap<>(WeekDay.class);

        employeesMap.put(WeekDay.FRIDAY, new String[]{"Ann", "Mary", "Bob"});
        employeesMap.put(WeekDay.MONDAY, new String[]{"Mary", "Bob"});
        employeesMap.forEach((k, v) -> System.out.println(k + ": " + Arrays.toString(v)));
    }
}