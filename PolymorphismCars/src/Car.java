public class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;
    private final String className = this.getClass().getSimpleName();

    public Car(int cylinders, String name){
        this.engine = true;
        this.wheels = 4;
        this.cylinders = cylinders;
        this.name = name;
    }
    public String startEngine(){
        return className + " starts engine.";
    }
    public String accelerate(){
        return className + " is accelerating.";
    }
    public String brake(){
        return className + " is braking.";
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}
