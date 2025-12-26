public class SmartKitchen
{
    private CoffeeMaker brewMaster;
    private DishWasher dishWasher;
    private Refrigerator iceBox;

    public SmartKitchen()
    {
        brewMaster = new CoffeeMaker();
        dishWasher = new DishWasher();
        iceBox = new Refrigerator();
    }

    public SmartKitchen(CoffeeMaker brewMaster, DishWasher dishWasher, Refrigerator iceBox)
    {
        this.brewMaster = brewMaster;
        this.dishWasher = dishWasher;
        this.iceBox = iceBox;
    }

    public CoffeeMaker getBrewMaster()
    {
        return brewMaster;
    }

    public DishWasher getDishWasher()
    {
        return dishWasher;
    }

    public Refrigerator getIceBox()
    {
        return iceBox;
    }

    public void addWater()
    {
        brewMaster.hasWorkToDo = true;
    }
    public void pourMilk()
    {
        iceBox.hasWorkToDo = true;
    }
    public void loadDishwasher()
    {
        dishWasher.hasWorkToDo = true;
    }
    public void setKitchenState(boolean coffeeFlag, boolean dishWasherFlag, boolean fridgeFlag)
    {
        brewMaster.hasWorkToDo = coffeeFlag;
        dishWasher.hasWorkToDo = dishWasherFlag;
        iceBox.hasWorkToDo = fridgeFlag;
    }
    public void doKitchenWork()
    {
        brewMaster.brewCoffee();
        dishWasher.doDishes();
        iceBox.orderFood();
    }
}
