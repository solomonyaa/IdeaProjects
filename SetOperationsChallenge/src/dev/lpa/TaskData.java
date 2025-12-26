package dev.lpa;

import java.util.*;

public class TaskData {

    private static final String allTasksData = """
            Infrastructure, Logging, High
            Infrastructure, DB Access, Medium
            Infrastructure, Security, High
            Infrastructure, Password Policy, Medium
            Data Design, Task Table, Medium
            Data Design, Employee Table, Medium
            Data Design, Cross Reference Tables, High
            Data Design, Encryption Policy, High
            Data Access, Write Views, Low
            Data Access, Set Up Users, Low
            Data Access, Set Up Access Policy, Low
            """;

    private static final String annTasksData = """
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy, Medium, In Progress
            Research, Cloud solutions, Medium, In Progress
            Data Design, Encryption Policy, High
            Data Design, Project Table, Medium
            Data Access, Write Views, Low, In Progress
            """;

    private static final String bobTasksData = """
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy, Medium
            Data Design, Encryption Policy, High
            Data Access, Write Views, Low, In Progress
            """;

    private static final String carolTasksData = """
            Infrastructure, Logging, High, In Progress
            Infrastructure, DB Access, Medium
            Infrastructure, Password Policy, Medium
            Data Design, Task Table, High
            Data Access, Write Views, Low
            """;

    public static Set<Task> getTasks(String name){

        String[] lines = switch (name.toLowerCase()) {
            case "ann" -> annTasksData.split("\n");
            case "bob" -> bobTasksData.split("\n");
            case "carol" -> carolTasksData.split("\n");
            case "all" -> allTasksData.split("\n");
            default -> null;
        };

        if(lines == null)
            return new HashSet<>();

        return name.equalsIgnoreCase("all") ? getSet(lines, null) : getSet(lines, name);
    }

    private static Set<Task> getSet(String[] lines, String name){

        Set<Task> setOfTasks = new HashSet<>();

        for (String line : lines) {
            String[] phrases = line.split(", ");
            Task t;

            if (phrases.length == 3) {
                t = new Task(name, phrases[0], phrases[1], phrases[2], null);
            } else { //phrases.length >= 4
                t = new Task(name, phrases[0], phrases[1], phrases[2], phrases[3]);
            }

            setOfTasks.add(t);
        }

        return setOfTasks;
    }
}
