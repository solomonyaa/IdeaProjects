import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Planet implements Comparable<Planet> {

    static final double SECONDS_IN_YEAR = 31557600;
    static final double GRAVITATIONAL_CONSTANT = 6.67430 * Math.pow(10, -11);
    static final double ANGLE = Math.PI / 18;

    private final char symbol;
    private final String name;
    private final double massInKg;
    private final double radiusInKm;
    private final double orbitalPeriodInYears;
    private final long distanceToStarInKm;
    private final double r;
    private final double phi;
    private double x;
    private double y;
    private double theta;
    private String imagePath;

    public Planet(char symbol, String name, double massInKg, double radiusInKm, double orbitalPeriodInYears, long distanceToStarInKm) {

        this.symbol = symbol;
        this.name = name;
        this.massInKg = massInKg;
        this.radiusInKm = radiusInKm;
        this.orbitalPeriodInYears = orbitalPeriodInYears;
        this.distanceToStarInKm = distanceToStarInKm;
        this.r = ((double) this.distanceToStarInKm / 1000000) + 50;
        this.x = r;
        this.y = 0;
        this.phi = Math.atan2(y, x);
        this.theta = ANGLE;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public double getMassInKg() {
        return massInKg;
    }

    public double getRadiusInKm() {
        return radiusInKm;
    }

    public double getOrbitalPeriodInYears() {
        return orbitalPeriodInYears;
    }

    public long getDistanceToStarInKm() {
        return distanceToStarInKm;
    }

    private void toOrbit() {

        this.x = r * Math.cos(this.phi + this.theta);
        this.y = r * Math.sin(this.phi + this.theta);
        this.theta += ANGLE;
    }

    public double[][] getOrbit() {

        var numOfPoints = (int) ((2 * Math.PI) / getTheta());
        double[][] coordinates = new double[numOfPoints][2];

        for (int i = 0; i < numOfPoints; i++) {

            coordinates[i] = this.getPosition();
            this.toOrbit();
        }

        return coordinates;
    }

    public List<Point> getOrbitList() {

        List<Point> pointList = new ArrayList<>();
        for (var point : this.getOrbit()) {
            pointList.add(new Point((int) point[0], (int) point[1]));
        }
        return pointList;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getTheta() {
        return theta;
    }

    public double[] getPosition() {

        String formattedNumber1 = String.format("%.3f", this.x);
        String formattedNumber2 = String.format("%.3f", this.y);

        double num1 = Double.parseDouble(formattedNumber1);
        double num2 = Double.parseDouble(formattedNumber2);

        return new double[]{num1, num2};
    }

    public String getOrbitDistance() {

        var circumference = 2 * Math.PI * distanceToStarInKm;
        return String.format("%,.1f", circumference) + " km";
    }

    public String getOrbitalSpeed() {

        return String.format("%.3f", OrbitalSpeed()) + " km/s";
    }

    private double OrbitalSpeed() {

        return (2 * Math.PI * distanceToStarInKm) / (orbitalPeriodInYears * SECONDS_IN_YEAR);
    }

    public String getSurfaceGravity() {

        double radiusInMeters = this.radiusInKm * 1000;
        double g = (GRAVITATIONAL_CONSTANT * this.massInKg) / (Math.pow(radiusInMeters, 2));
        return String.format("%.3f", g) + " m/s²";
    }

    public String getVolumeInKmCubed() {

        var volume = ((double) 4 / 3 * Math.PI * Math.pow(this.radiusInKm, 3));
        return String.format("%.4e", volume) + " km³";
    }

    private double getOrbitalPeriodInDays() {
        return this.orbitalPeriodInYears * 365.25;
    }


    @Override
    public String toString() {

        String res = symbol + "\t\t" + name + "\t\t" +
                String.format("%.4e", massInKg) + " kg" + "\t\t" +
                getVolumeInKmCubed() + "\t\t";

        if (name.startsWith("1"))
            res += String.format("%.2f", getOrbitalPeriodInDays()) + " days" + "\t\t";
        else
            res += String.format("%.4f", orbitalPeriodInYears) + " years" + "\t\t";

        res += String.format("%,d", distanceToStarInKm) + " km";

        return res;
    }

    // from interface Comparable
    @Override
    public int compareTo(Planet p) {

        return (int) (this.massInKg - p.massInKg);
    }

    @Override
    public boolean equals(Object p) {

        if (!p.getClass().getSimpleName().equals("Planet"))
            return false;
        var otherPlanet = (Planet) p;

        Comparator<Planet> planetSorter = new PlanetComparator();

        return this.name.equals(otherPlanet.name) && planetSorter.compare(this, otherPlanet) == 0;
    }
}

class PlanetComparator implements Comparator<Planet> {

    // from interface Comparator
    @Override
    public int compare(Planet p1, Planet p2) {

        return Long.compare(p1.getDistanceToStarInKm(), p2.getDistanceToStarInKm());
    }
}
