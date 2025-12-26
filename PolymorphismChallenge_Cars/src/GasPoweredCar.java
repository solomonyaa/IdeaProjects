public class GasPoweredCar extends Car{
    double avgKmPerLiter;
    int cylinders;
    double fuelInLiters;
    public GasPoweredCar(String description, double maxSpeed, double acceleration,
                         double avgKmPerLiter, int cylinders) {

        super(description, maxSpeed, acceleration);
        this.avgKmPerLiter = avgKmPerLiter;
        this.cylinders = cylinders;
        this.fuelInLiters = 100;
    }

    @Override
    public void drive() {
        if(fuelInLiters <= 0)
            throw new RuntimeException("Not enough fuel! Please refill.");
        super.drive();
        this.fuelInLiters -= (distanceTraveledInKm / avgKmPerLiter) * 1000;
    }
    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("All " + cylinders + " cylinders are working...");
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nAvgKmPerLiter = " + avgKmPerLiter + " km/L" +
                "\nFuel = " + df.format(fuelInLiters) + " L";
    }
}
