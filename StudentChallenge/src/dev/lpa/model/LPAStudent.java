package dev.lpa.model;

public class LPAStudent extends Student {

    private final double percentComplete;

    public LPAStudent() {
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        return "%s %10.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {

        if (fieldName.equalsIgnoreCase("PercentComplete")) {
            return this.percentComplete >= Double.parseDouble(value);
        } // else
        return super.matchFieldValue(fieldName, value);
    }
}
