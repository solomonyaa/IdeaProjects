package dev.lpa;

public enum Status {

    ASSIGNED,
    IN_PROGRESS,
    NOT_YET_ASSIGNED,
    COMPLETED;

    @Override
    public String toString() {
        String output = this.name().replace('_', ' ').toLowerCase();
        output = output.substring(0, 1).toUpperCase() + output.substring(1);
        return output;
    }
}
