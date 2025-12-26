import java.text.DecimalFormat;

public class Car {
    String description;
    private double velocityInKmPerHour;
    private boolean engineRunning;
    public final double maxSpeed;
    public final double acceleration;
    public double distanceTraveledInKm;
    public final int sleepTimeInMilliSeconds = 100;
    protected static final DecimalFormat df = new DecimalFormat("0.00");

    public Car(String description, double maxSpeed, double acceleration) {
        this.description = description;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.velocityInKmPerHour = 0;
        this.engineRunning = false;
        this.distanceTraveledInKm = 0;
    }
    public void drive(){
        this.runEngine();
        int iterations = 0;
        for (this.velocityInKmPerHour = 0; velocityInKmPerHour <= maxSpeed; velocityInKmPerHour += acceleration){
            System.out.println("Current Speed: " + velocityInKmPerHour + " km/h");
            try {
                Thread.sleep(sleepTimeInMilliSeconds);
                iterations++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        double timeInSeconds = (double) (sleepTimeInMilliSeconds * iterations) / 1000;
        this.distanceTraveledInKm = velocityInKmPerHour * (timeInSeconds / 3600);
        turnOffEngine();
    }
    public void startEngine(){
        System.out.println("\nEngine Started...");
    }
    protected void runEngine(){
        this.engineRunning = true;
        this.startEngine();
    }
    protected void turnOffEngine(){
        this.engineRunning = false;
        System.out.println("\nEngine turned off...");
    }

    @Override
    public String toString() {
        String des = this.getClass().getName().replaceAll("C", " C");
        if(des.charAt(0) == 'G'){
            des = des.replaceAll("s", "s ");
        }

        return "\nDescription = " + des + " " + description + "\n" +
                "Max Speed = " + maxSpeed + " km/h\n" +
                "Acceleration = " + acceleration + " (km/h)/sec\n" +
                "Engine running = " + engineRunning;
    }
}
