package dev.lpa.model;

import java.util.Comparator;

public class StudentCourseAndYearComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (o1.course + o1.yearStarted).compareTo(o2.course + o2.yearStarted);
    }
}
