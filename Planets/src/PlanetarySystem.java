import java.util.*;
import java.util.function.Consumer;


public class PlanetarySystem {

    private final String name;
    private final Star star;
    private final ArrayList<Planet> planets;


    public PlanetarySystem() {

        this.name = "The Solar System";
        this.star = new Star('☉', "The Sun", 1.988435 * Math.pow(10, 30), false, 0, 0);

        this.planets = new ArrayList<>(List.of(
                new Planet('☿', "Mercury", 3.3011 * Math.pow(10, 23), 2439.7, 0.240846, 57909176L),
                new Planet('♀', "Venus", 4.8675 * Math.pow(10, 24), 6051.8, 0.615198, 108208926L),
                new Planet('♁', "Earth", 5.9722 * Math.pow(10, 24), 6371.0, 1.0, 149598023L),
                new Planet('♂', "Mars", 6.4171 * Math.pow(10, 23), 3389.5, 1.88085, 227936637L),
                new Planet('♃', "Jupiter", 1.8982 * Math.pow(10, 27), 69911.0, 11.862, 778340821L),
                new Planet('♄', "Saturn", 5.6834 * Math.pow(10, 26), 58232.0, 29.4475, 1426725413L),
                new Planet('⛢', "Uranus", 8.6810 * Math.pow(10, 25), 25362.0, 84.0205, 2870972220L),
                new Planet('♆', "Neptune", 1.02409 * Math.pow(10, 26), 24622.0, 164.79, 4498252900L)
        ));
    }

    public PlanetarySystem(String name, ArrayList<Planet> planets, Star star) {

        this.name = name;
        this.planets = planets;
        this.star = star;
    }

    public Planet getPlanet(String name) {

        for (Planet p : this.planets) {
            if (Objects.equals(p.getName().toLowerCase(), name.toLowerCase())) {
                return p;
            }
        }
        return null;
    }

    public Planet getPlanet(int position) {
        if (position < 1 || position > planets.size())
            return null;

        return planets.get(position - 1);
    }

    public ArrayList<Planet> getPlanets() {
        return this.planets;
    }

    public Star getStar() {
        return this.star;
    }

    public void sortByMass(boolean smallerToLarger) {

        Collections.sort(this.planets);
        if (!smallerToLarger) {
            Collections.reverse(this.planets);
        }
    }

    public void sortByDistanceToStar(boolean fromOuter) {

        Comparator<Planet> planetSorter = new PlanetComparator();
        if (fromOuter) {
            this.planets.sort(planetSorter.reversed());
        } else {
            this.planets.sort(planetSorter);
        }
    }

    public String getDistanceTo(Planet planet1, Planet planet2) {

        if (getPlanet(planet1.getName()) != null && getPlanet(planet2.getName()) != null) {

            long d = Math.abs(planet1.getDistanceToStarInKm() - planet2.getDistanceToStarInKm());
            return String.format("%,d", d) + " km";
        }
        return "No planets were found";
    }

    public void print() {

        System.out.println("The Star of " + this.name + " is: " + this.star);
        System.out.println("The " + planets.size() + " Planets of " + this.name + " are:");
        System.out.println("Symbol\tName\t\tMass\t\t\t\tVolume\t\t\tOrbital period\t\tDistance to " + star.name() + "\t");
        System.out.println("=".repeat(100));

        Consumer<List<Planet>> planetListConsumer = list ->
                list.forEach(s -> System.out.println(s + "\n" + "-".repeat(100)));
        planetListConsumer.accept(this.planets);
    }
}