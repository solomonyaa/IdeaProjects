import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Integer number = 5;
        Integer[] otherNumbers = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(otherNumbers));

        for (Integer i : otherNumbers) {
            int value = number.compareTo(i);
            System.out.printf("%d %s %d: compareTo = %d%n", number,
                    (value == 0 ? "==" : (value < 0) ? "<" : ">"), i, value);
        }

        System.out.println();

        Student tim = new Student("Tim");
        Student johnny = new Student("Johnny");
        Student anna = new Student("Anna");

        Student[] students = {tim, johnny, anna};
        Arrays.sort(students); // uses compareTo()
        System.out.println(Arrays.toString(students));

        Comparator<Student> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students, gpaSorter.reversed()); // uses compare()
        System.out.println(Arrays.toString(students));


        //region GenericArray
        /*GenericArray<Integer> intArray = new GenericArray<>(10);
        for (int i = 0; i < 10; i++) {
            intArray.setElement(i, i + 1);
        }
        intArray.print();*/
        //endregion
    }
}