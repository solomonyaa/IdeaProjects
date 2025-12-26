public class ElectricCar extends Car{
    double avgKmPerCharge;
    int batterySize;
    double batteryCharge;
    public ElectricCar(String description, double maxSpeed, double acceleration,
                       double avgKmPerCharge, int batterySize) {

        super(description, maxSpeed, acceleration);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
        this.batteryCharge = 100;
    }
    @Override
    public void drive() {
        super.drive();
        this.batteryCharge -= (distanceTraveledInKm / avgKmPerCharge) * 5000;
    }
    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("This electric car's engine is silent...\n" +
                "Current battery charge is " + batteryCharge + "%.");
    }
    @Override
    public String toString() {
        return super.toString() +
                "\navgKmPerCharge = " + avgKmPerCharge + " km/Charge" +
                "\nBattery Charge = " + df.format(batteryCharge) + "%";
    }
}
