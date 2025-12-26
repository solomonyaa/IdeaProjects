import dev.lpa.Task;
import dev.lpa.TaskData;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Task> bossesTasks = TaskData.getTasks("All");
        sortAndPrint("All Tasks", bossesTasks);

        //Comparator<Task> sortByPriority = Comparator.comparing(task -> task.getPriority());
        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);

        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann's Tasks", annsTasks, sortByPriority);

        Set<Task> bobsTasks = TaskData.getTasks("Bob");
        sortAndPrint("Bob's Tasks", bobsTasks);

        Set<Task> carolsTasks = TaskData.getTasks("Carol");
        sortAndPrint("Carol's Tasks", carolsTasks);

        System.out.println("*".repeat(120));

        var assignedTasks = getUnion(List.of(annsTasks, bobsTasks, carolsTasks));
        sortAndPrint("Assigned Tasks", assignedTasks);

        var fullTaskSet = getUnion(List.of(bossesTasks, assignedTasks));
        sortAndPrint("Full Task List", fullTaskSet);

        var missingTasks = getDifference(fullTaskSet, bossesTasks);
        sortAndPrint("Missing Tasks", missingTasks);

        var unassignedTasks = getDifference(bossesTasks, assignedTasks);
        sortAndPrint("Unassigned Tasks", unassignedTasks, sortByPriority);

        var overlap = getUnion(List.of(
                getIntersect(annsTasks, bobsTasks),
                getIntersect(bobsTasks, carolsTasks),
                getIntersect(annsTasks, carolsTasks)
        ));
        sortAndPrint("Assigned to Multiples", overlap, sortByPriority);

        List<Set<Integer>> intSets = new ArrayList<>();
        intSets.add(Set.of(1, 2, 3, 4));
        intSets.add(Set.of(2, 3, 4, 5));
        intSets.add(Set.of(2, 3, 4, 5, 6));

        Set<Integer> result = getIntersect(intSets);
        System.out.println(result);


        Set<Integer> originalSet = (Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        List<Set<Integer>> intSets2 = new ArrayList<>();
        intSets2.add(Set.of(1, 4, 7, 9));
        intSets2.add(Set.of(0, 5, 7, 8));

        Set<Integer> result2 = getDifference(originalSet, intSets2);
        System.out.println(result2);

    }

    private static void sortAndPrint(String header, Collection<Task> tasks) {
        sortAndPrint(header, tasks, null);
    }

    private static void sortAndPrint(String header, Collection<Task> tasks,
                                     Comparator<Task> sorter) {

        List<Task> list = new ArrayList<>(tasks);
        list.sort(sorter);

        System.out.println("-".repeat(120));
        System.out.println(header);
        System.out.println("-".repeat(120));
        list.forEach(System.out::println);
    }


    private static <T> Set<T> getUnion(List<Set<T>> listOfSets) {

        Set<T> union = new HashSet<>();

        for (Set<T> set : listOfSets) {
            union.addAll(set);
        }

        return union;
    }

    private static <T> Set<T> getIntersect(Set<T> set1, Set<T> set2) {

        Set<T> intersect = new HashSet<>(set1);
        intersect.retainAll(set2);

        return intersect;
    }

    private static <T> Set<T> getIntersect(List<Set<T>> listOfSets) {

        if (listOfSets == null || listOfSets.isEmpty()) {
            return new HashSet<>();
        }

        Set<T> intersect = new HashSet<>(listOfSets.get(0));

        // Start iterating from the second set
        for (int i = 1; i < listOfSets.size(); i++) {
            intersect.retainAll(listOfSets.get(i));
        }

        return intersect;
    }

    private static <T> Set<T> getDifference(Set<T> set1, Set<T> set2) {

        Set<T> difference = new HashSet<>(set1);
        difference.removeAll(set2);

        return difference;
    }

    private static <T> Set<T> getDifference(Set<T> set1, List<Set<T>> listOfSets) {

        if(set1 == null){
            return new HashSet<>();
        }

        if (listOfSets == null || listOfSets.isEmpty()) {
            return set1;
        }

        Set<T> difference = new HashSet<>(set1);

        for (Set<T> tSet : listOfSets) {
            difference.removeAll(tSet);
        }

        return difference;
    }
}