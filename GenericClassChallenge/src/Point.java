import java.util.Arrays;

public abstract class Point implements Mappable{

    protected double[] location;

    public Point(String location) {
        this.location = Mappable.stringToLatitudeLongitude(location);
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as POINT (" + Arrays.toString(location) + ")");
    }
}
