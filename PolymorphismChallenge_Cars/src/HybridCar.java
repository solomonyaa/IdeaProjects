public class HybridCar extends Car{
    double avgKmPerLiter;
    int batterySize;
    double batteryCharge;
    int cylinders;
    double fuelInLiters;
    public HybridCar(String description, double maxSpeed, double acceleration,
                     double avgKmPerLiter, int batterySize, int cylinders) {
        super(description, maxSpeed, acceleration);
        this.avgKmPerLiter = avgKmPerLiter;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
        this.fuelInLiters = 50;
        this.batteryCharge = 100;
    }
    @Override
    public void drive() {
        super.drive();
        this.fuelInLiters -= (distanceTraveledInKm / avgKmPerLiter) * 1000;
        this.batteryCharge -= (distanceTraveledInKm / 250) * 5000;

    }
    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Only " + ((cylinders / 2) + 1) + " out of " + cylinders +
                " cylinders are working...");
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nAvgKmPerLiter = " + avgKmPerLiter + " km/L" +
                "\nFuel = " + df.format(fuelInLiters) + " L" +
                "\nBattery Charge = " + df.format(batteryCharge) + "%";
    }
}
