import dev.lpa.model.LPAStudent;
import dev.lpa.model.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int studentCount = 10;

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
        students.add(new LPAStudent());
        printList(students);
        printMoreLists(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
        printList(lpaStudents);
        printMoreLists(lpaStudents);

        testList(new ArrayList<String>(List.of("Able", "Barry", "Charlie")));
        testList(new ArrayList<Integer>(List.of(1, 2, 3)));

    }

    public static <T extends Student> void printList(List<T> students) {

        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    public static void printMoreLists(List<? extends Student> students) {

        for (var student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

    public static void testList(List<?> list) {
        for (var element : list) {
            if (element instanceof String s) {
                System.out.print("String: " + s.toUpperCase() + ", ");
            } else if (element instanceof Integer i) {
                System.out.print("Integer: " + i.floatValue() + ", ");
            }
        }
        System.out.println();
    }
}