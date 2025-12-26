import dev.lpa.model.LPAStudent;
import dev.lpa.model.Student;
import dev.lpa.model.StudentCourseAndYearComparator;
import dev.lpa.util.QueryList;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        QueryList<LPAStudent> students = new QueryList<>();

        for (int i = 1; i <= 25; i++) {
            students.add(new LPAStudent());
        }

        students.sort(Comparator.naturalOrder());
        System.out.println("All students sorted by ID:");
        printList(students);

        System.out.println("-".repeat(70));

        var matches = students
                .getMatches("PercentComplete", "50");

        matches.sort(new StudentCourseAndYearComparator());
        System.out.println("Only students who have completed at least 50% of their course.\nSorted by course and year started:");
        printList(matches);
    }

    public static void printList(List<? extends Student> students) {

        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

}