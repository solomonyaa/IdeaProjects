public class DeluxeHamburger extends Hamburger{
    private Topping topping4;
    private Topping topping5;

    public DeluxeHamburger() {
        super("Deluxe", 50.0);
    }

    public void AddToppings(String type1, String type2, String type3,
                            String type4, String type5) {
        super.AddToppings(type1, type2, type3);
        this.topping4 = new Topping(type4);
        this.topping5 = new Topping(type5);
    }
    public void AddToppings(String type1, String type2, String type3, String type4) {
        super.AddToppings(type1, type2, type3);
        this.topping4 = new Topping(type4);
    }

    public double getTopping4Price(){
        if(topping4 != null)
            return topping4.getPrice();
        return 0;
    }
    public double getTopping5Price(){
        if(topping5 != null)
            return topping5.getPrice();
        return 0;
    }

    @Override
    public String toString() {
        return "DELUXE - All items are free of charge! \n" + super.toString() + "\n" +
                "Topping 4: " + (this.topping4 == null ? "none" : this.topping4) + "\n" +
                "Topping 5: " + (this.topping5 == null ? "none" : this.topping5);
    }
}
