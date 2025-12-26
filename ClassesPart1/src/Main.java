public class Main
{
    public static void main(String[] args)
    {
        Car car1 = new Car();
        car1.setManufacturer("Subaru");
        car1.setModel("Impreza");
        car1.setDoors(4);
        car1.setColor("Silver");
        car1.setConvertible(false);
        car1.setYear(2003);
        System.out.println(car1.describeCar());

        Car car2 = new Car();
        car2.setManufacturer("Audi");
        car2.setModel("R8 Spyder");
        car2.setDoors(2);
        car2.setColor("Yellow");
        car2.setConvertible(true);
        car2.setYear(2020);
        System.out.println(car2.describeCar());
    }
}