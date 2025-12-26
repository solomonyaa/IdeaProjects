
public record Star(char symbol, String name, double mass, boolean doubleStar, double x, double y) {

    public String getPosition(){
        return String.format("\nSun's position: (%.1f, %.1f)%n", this.x, this.y);
    }

    @Override
    public String toString() {
        return  name + " (" + symbol + ")" +
                ", Mass: " + String.format("%.5e", mass) + " kg" +
                ", Is a double star? " + (doubleStar ? "Yes" : "No");
    }

}
