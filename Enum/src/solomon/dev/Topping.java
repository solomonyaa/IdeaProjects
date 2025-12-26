package solomon.dev;

public enum Topping {
    MUSTARD,
    PICKLES,
    BACON,
    CHEDDAR,
    TOMATO; // The semicolon is required for adding any methods


    public double getPrice() {
        return switch (this.name()) {
            case "MUSTARD" -> 0.3;
            case "PICKLES", "TOMATO" -> 0.7;
            case "CHEDDAR" -> 1.0;
            case "BACON" -> 1.5;
            default -> 0;
        };
    }
}
