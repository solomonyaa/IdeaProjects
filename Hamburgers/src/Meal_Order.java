public class Meal_Order {
    private Hamburger hamburger;
    private Drink drink;
    private Side_Item sideItem;
    private double overallPrice;
    private static int index = 0;
    private final int orderNumber;

    public Meal_Order() {
        this.hamburger = new Hamburger("regular", 20.0);
        this.drink = new Drink("Coke", "small");
        this.sideItem = new Side_Item("Fries", "regular", 5.0);
        calculatePrice();
        index++;
        orderNumber = index;
    }

    public Meal_Order(Hamburger hamburger, Drink drink, Side_Item sideItem) {
        this.hamburger = hamburger;
        this.drink = drink;
        this.sideItem = sideItem;
        if(hamburger instanceof DeluxeHamburger)
            calculatePriceDeluxe();
        else
            calculatePrice();
        index++;
        orderNumber = index;
    }
    private void calculatePrice(){
        this.overallPrice = 0;
        this.overallPrice += hamburger.getPrice()
                + hamburger.getTopping1Price()
                + hamburger.getTopping2Price()
                + hamburger.getTopping3Price()
                + drink.getPrice() + sideItem.getPrice();
    }
    private void calculatePriceDeluxe(){
        this.overallPrice = 0;
        this.overallPrice += hamburger.getPrice();
    }
    public double getPrice() {
        return overallPrice;
    }

    public void AddToppings(String topping1, String topping2) {
        this.hamburger.AddToppings(topping1, topping2);
        calculatePrice();
    }
    public void AddToppings(String topping1, String topping2, String topping3) {
        this.hamburger.AddToppings(topping1, topping2, topping3);
        calculatePrice();
    }
    public void AddToppings(String topping1, String topping2, String topping3, String topping4) {
        if(this.hamburger instanceof DeluxeHamburger dh){
            dh.AddToppings(topping1, topping2, topping3, topping4);
            calculatePriceDeluxe();
        }
        else{
            this.hamburger.AddToppings(topping1, topping2, topping3);
            calculatePrice();
        }
    }
    public void AddToppings(String topping1, String topping2, String topping3, String topping4, String topping5) {
        if(this.hamburger instanceof DeluxeHamburger dh){
            dh.AddToppings(topping1, topping2, topping3, topping4, topping5);
            calculatePriceDeluxe();
        }
        else{
            this.hamburger.AddToppings(topping1, topping2, topping3);
            calculatePrice();
        }
    }
    public void changeDrink(String size) {
        var type = this.drink.getType();
        this.drink = new Drink(type, size);
        calculatePrice();
    }

    @Override
    public String toString() {
        return "Meal Order " + orderNumber + ": \n" + this.hamburger.toString() +
                "\nDrink = " + drink.getType() + ", size: " + drink.getSize() + ", price: " + drink.getPrice() +
                "\nSide item = " + sideItem.getType() + ", size: " + sideItem.getSize() + ", price: " + sideItem.getPrice() +
                "\nOverall price = " + this.getPrice() + "\n";
    }
}
