import java.util.Comparator;
import java.util.Random;

public class Student implements Comparable<Student> {

    private static final Random random = new Random();
    private static int LAST_ID = 1000;
    private final int id;
    protected double gpa;
    String name; // package private

    public Student(String name) {
        this.name = name;
        this.id = LAST_ID++;
        this.gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString() {
        return String.format("%d - %s (%.2f)", id, name, gpa);
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
        //return Integer.valueOf(this.id).compareTo(Integer.valueOf(other.id));
    }
}


class StudentGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return (s1.gpa + s1.name).compareTo(s2.gpa + s2.name);
    }
}

