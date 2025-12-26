package dev.lpa;

public class Main {

    public static void main(String[] args) {

/*        Person jane = new Person();
        jane.setName("Jane");
        Person jim = new Person();
        jim.setName("Jim");
        Person joe = new Person();
        joe.setName("Joe");

        Person john = new Person();
        john.setName("John");
        john.setDateOfBirth("05/05/1900");
        john.setKids(new Person[]{jane, jim, joe});
        System.out.println(john);*/

        Person jane = new Person("Jane", "01/01/1930");
        Person jim = new Person("Jim", "02/02/1932");
        Person joe = new Person("Joe", "03/03/1934");

        Person[] johnsKids = {jane, jim, joe};
        Person john = new Person("John", "05/05/1900", johnsKids);
        System.out.println(john);

    }
}