public class Main {

    public static void main(String[] args) {
        Car subaru = new GasPoweredCar
                ("Subaru Impreza 2002", 224, 10, 10, 4);
        testCar(subaru);

        Car tesla = new ElectricCar
                ("Tesla Model X", 250, 15, 200, 100);
        testCar(tesla);

        Car bmw = new HybridCar
                ("BMW i8", 250, 20, 47, 100, 3);
        testCar(bmw);
    }

    public static void testCar(Car car) {
        System.out.println(car);
        car.drive();
        System.out.println(car);
    }
}