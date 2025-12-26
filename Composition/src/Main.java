public class Main
{
    public static void main(String[] args)
    {
        /*CoffeeMaker coffeeMaker = new CoffeeMaker();
        DishWasher dishWasher = new DishWasher();
        Refrigerator refrigerator = new Refrigerator();
        SmartKitchen smartKitchen2 = new SmartKitchen(coffeeMaker, dishWasher, refrigerator);*/

        SmartKitchen kitchen = new SmartKitchen();
        kitchen.setKitchenState(true, true, false);

        /*kitchen.getBrewMaster().brewCoffee();
        kitchen.getDishWasher().doDishes();
        kitchen.getIceBox().orderFood();*/

        kitchen.doKitchenWork();
    }
}