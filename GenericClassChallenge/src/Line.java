import java.util.Arrays;

public abstract class Line implements Mappable {

    protected double[][] locations;

    public Line(String... locations) {
        this.locations = new double[locations.length][];
        int index = 0;
        for (var l : locations) {
            this.locations[index++] = Mappable.stringToLatitudeLongitude(l);
        }
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as LINE (" + Arrays.deepToString(locations) + ")");
    }
}
