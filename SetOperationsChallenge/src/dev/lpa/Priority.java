package dev.lpa;

public enum Priority {

    HIGH,
    MEDIUM,
    LOW;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
