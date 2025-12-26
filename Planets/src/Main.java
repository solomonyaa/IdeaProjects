import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {

        BiFunction<PlanetarySystem, String, String> systemPlanetFunction = (planetarySystem, parameter) -> {

            StringBuilder sb = new StringBuilder();

            for (Planet p : planetarySystem.getPlanets()) {
                sb.append(p.getName());

                switch (parameter) {
                    case "speed" -> sb.append("'s orbital speed: ").append(p.getOrbitalSpeed());
                    case "orbit" -> sb.append("'s orbit distance: ").append(p.getOrbitDistance());
                    case "gravity" -> sb.append("'s gravity: ").append(p.getSurfaceGravity());
                }
                sb.append("\n");
            }
            return sb.toString();
        };

        System.out.println();

        PlanetarySystem solarSystem = new PlanetarySystem();

        solarSystem.sortByMass(true);

        //solarSystem.print();

        solarSystem.sortByDistanceToStar(false);

        solarSystem.print();

        System.out.println(systemPlanetFunction.apply(solarSystem, "speed"));
        System.out.println(systemPlanetFunction.apply(solarSystem, "orbit"));
        System.out.println(systemPlanetFunction.apply(solarSystem, "gravity"));

        Planet earth = solarSystem.getPlanet("earth");

        for (Planet p : solarSystem.getPlanets()) {
            System.out.println(p.getName() + "'s average distance to " + earth.getName() + " is: " + solarSystem.getDistanceTo(earth, p));
        }


        PlanetarySystem TRAPPIST_1_System = new PlanetarySystem("TRAPPIST-1 System", new ArrayList<>(List.of(
                new Planet('b', "1b", 0.85 * earth.getMassInKg(), 1.09 * earth.getRadiusInKm(), 1.51 / 365.25, 1645577L),
                new Planet('c', "1c", 1.38 * earth.getMassInKg(), 1.06 * earth.getRadiusInKm(), 2.42 / 365.25, 2243968L),
                new Planet('d', "1d", 0.41 * earth.getMassInKg(), 0.77 * earth.getRadiusInKm(), 4.05 / 365.25, 3141555L),
                new Planet('e', "1e", 0.62 * earth.getMassInKg(), 0.92 * earth.getRadiusInKm(), 6.10 / 365.25, 4188740L),
                new Planet('f', "1f", 0.68 * earth.getMassInKg(), 1.04 * earth.getRadiusInKm(), 9.21 / 365.25, 5535121L),
                new Planet('g', "1g", 1.34 * earth.getMassInKg(), 1.13 * earth.getRadiusInKm(), 12.35 / 365.25, 6731904L),
                new Planet('h', "1h", 0.39 * earth.getMassInKg(), 0.76 * earth.getRadiusInKm(), 20 / 365.25, 8975872L)

        )), new Star('a', "TRAPPIST-1", 0.1796 * 2 * Math.pow(10, 30), false, 0, 0));


        System.out.println("-".repeat(100));
        TRAPPIST_1_System.sortByDistanceToStar(false);
        TRAPPIST_1_System.print();

        System.out.println(systemPlanetFunction.apply(TRAPPIST_1_System, "speed"));
        System.out.println(systemPlanetFunction.apply(TRAPPIST_1_System, "orbit"));
        System.out.println(systemPlanetFunction.apply(TRAPPIST_1_System, "gravity"));

        Planet TRAPPIST_1d = TRAPPIST_1_System.getPlanet("1d");

        for (Planet p : TRAPPIST_1_System.getPlanets()) {
            System.out.println(p.getName() + "'s average distance to " + TRAPPIST_1d.getName() + " is: " + TRAPPIST_1_System.getDistanceTo(TRAPPIST_1d, p));
        }


        var sun = solarSystem.getStar();
        System.out.println(sun.getPosition());


        PlanetarySystem ps1 = new PlanetarySystem("Solar System", new ArrayList<>(List.of(
                new Planet('♁', "Earth", 5.9722 * Math.pow(10, 24), 6371.0, 1.0, 149598023L),
                new Planet('♂', "Mars", 6.4171 * Math.pow(10, 23), 3389.5, 1.88085, 227936637L)

        )), new Star('☉', "The Sun", 1.988435 * Math.pow(10, 30), false, 0, 0));

        ps1.getPlanet("earth").setImagePath("src/images/earth01.jpg");
        ps1.getPlanet("mars").setImagePath("src/images/mars.jpg");


        generatePlanetAnimation(ps1);
    }

    public static void generatePlanetAnimation(PlanetarySystem ps) {

        var planets = ps.getPlanets();

        for (Planet planet : planets) {
            List<Point> pointList = new ArrayList<>();

            var res = planet.getOrbit();
            System.out.println("\n" + planet.getName() + "'s orbit (" + res.length + " points):");

            for (var point : res) {
                System.out.printf("(%.3f, %.3f)\n", point[0], point[1]);
            }

            int xFactor = 750;
            int yFactor = 350;

            for (var point : res) {
                pointList.add(new Point((int) point[0] + xFactor, (int) point[1] + yFactor));
            }

            SwingUtilities.invokeLater(() -> ImageAnimator.createAndShowGUI(planets, pointList));
            
        }
    }
}