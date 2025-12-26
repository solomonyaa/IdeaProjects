package dev.lpa;

import dev.lpa.domain.Employee;
import dev.lpa.domain.StoreEmployee;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Abby", 2015),
                new Employee(10005, "Bruce", 2013),
                new Employee(10022, "Claire", 2017),
                new Employee(13151, "Damien", 2023),
                new Employee(10055, "Elon", 2021)
        ));

        /*var comparator = new EmployeeComparator<>();
        employees.sort(comparator);*/

        employees.sort(new Employee.EmployeeComparator<>("yearstarted")
                .reversed());

        for (Employee e : employees) {
            System.out.println(e);
        }

        System.out.println("Store Members");

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019, "Target"),
                new StoreEmployee(10515, "Joe", 2021, "Walmart"),
                new StoreEmployee(10105, "Tom", 2020, "Macy's"),
                new StoreEmployee(10215, "Marty", 2018, "Walmart"),
                new StoreEmployee(10322, "Bud", 2016, "Target")
        ));


        var comparator = new StoreEmployee().new StoreComparator<>();
        // Creating an instance of an inner class

        storeEmployees.sort(comparator);

        for (StoreEmployee e : storeEmployees) {
            System.out.println(e);
        }
    }
}