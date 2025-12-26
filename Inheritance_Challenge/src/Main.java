public class Main
{
    public static void main(String[] args)
    {
        Worker john = new Worker("John", "28/09/1981");
        System.out.println(john);
        System.out.println("Age: " + john.getAge());
        System.out.println("Pay: " + john.collectPay());


        Employee tim = new Employee("Tim", "11/11/1985", "01/01/2020");
        System.out.println(tim);

        SalariedEmployee joe = new SalariedEmployee("Joe", "11/11/1990",
                "03/03/2020", 35000);
        System.out.println(joe);
        System.out.println("Joe's paycheck is: $" + joe.collectPay());
        joe.retire("12/12/2025");
        System.out.println("Joe's pension check: $" + joe.collectPay());

        HourlyEmployee mary = new HourlyEmployee("Mary", "05/05/1970",
                "03/03/2021", 15, 40);
        System.out.println(mary);
        System.out.println("Mary's paycheck is: $" + mary.collectPay());
        System.out.println("Mary's holiday paycheck is: $" + mary.getDoublePay());
    }
}