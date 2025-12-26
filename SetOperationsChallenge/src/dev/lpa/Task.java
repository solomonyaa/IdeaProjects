package dev.lpa;

import java.util.Objects;

public class Task implements Comparable<Task> {

    private String assignee;
    private String projectName;
    private String description;
    private Status status;
    private Priority priority;

    public Task(String assignee, String projectName, String description, String priority, String status) {
        if(assignee != null)
            this.assignee = assignee.substring(0, 1).toUpperCase() + assignee.substring(1);

        this.projectName = projectName;
        this.description = description;

        if(priority != null)
            this.priority = Priority.valueOf(priority.toUpperCase());

        if(status != null){
            switch (status.toLowerCase()){
                case "in progress":
                    this.status = Status.IN_PROGRESS;
                    break;
                case "assigned":
                    this.status = Status.ASSIGNED;
                    break;
                default:
                    this.status = Status.NOT_YET_ASSIGNED;
                    break;
            }
        } else {
            this.status = Status.NOT_YET_ASSIGNED;
        }
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        if(assignee != null)
            this.assignee = assignee.substring(0, 1).toUpperCase() + assignee.substring(1);
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;
        return getProjectName().equals(task.getProjectName()) &&
                getDescription().equals(task.getDescription());
    }

    @Override
    public int hashCode() {
        int result = getProjectName().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }

    @Override
    public int compareTo(Task o) {

        int projectComparison = this.projectName.compareTo(o.projectName);

        if (projectComparison == 0) {
            return this.description.compareTo(o.description);
        }
        return projectComparison;
    }

    @Override
    public String toString() {
        return "%-20s %-25s %-10s %-10s %s".formatted
                (projectName, description, priority, assignee, status);
    }
}
