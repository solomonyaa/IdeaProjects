import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(

                new Employee("Amanda", "Kaye", "16/05/2013"),
                new Employee("Thomas", "Jeffery", "03/08/2007"),
                new Employee("Martha", "Wheeler", "01/01/2002"),
                new Employee("David", "FitzGerald", "23/11/2015"),
                new Employee("Justin", "Reynolds", "15/03/2012"),
                new Employee("George", "Hay", "28/02/2017")
        ));

        printOrderedList(employees, SortType.Name, true);
        System.out.println();
        printOrderedList(employees, SortType.YearsWorked, false);

    }

    public static void printOrderedList(List<Employee> list, SortType sortType, boolean isAscending) {

        // Using local class
        class LocalEmployee {

            private final String fullName;
            private final int yearsWorked;

            // Constructor
            public LocalEmployee(Employee employee) {

                this.fullName = String.join(" ", employee.firstName, employee.lastName);
                int yearHired = Integer.parseInt(employee.dateHired.split("/")[2]);
                this.yearsWorked = LocalDate.now().getYear() - yearHired;
            }

            @Override
            public String toString() {
                return "%s has been an employee for %d years".formatted(fullName, yearsWorked);
            }
        }

        List<LocalEmployee> localEmployees = new ArrayList<>();

        for (Employee employee : list) {
            localEmployees.add(new LocalEmployee(employee));
        }

        // Using anonymous class
        var comparator1 = new Comparator<LocalEmployee>() {

            @Override
            public int compare(LocalEmployee o1, LocalEmployee o2) {

                return switch (sortType) {
                    case Name -> o1.fullName.compareTo(o2.fullName);
                    case YearsWorked -> o1.yearsWorked - o2.yearsWorked;
                };
            }
        };

        if (isAscending)
            localEmployees.sort(comparator1);
        else
            localEmployees.sort(comparator1.reversed());

        for (LocalEmployee le : localEmployees) {
            System.out.println(le);
        }
    }

    public enum SortType {Name, YearsWorked}

    public record Employee(String firstName, String lastName, String dateHired) {
    }
}