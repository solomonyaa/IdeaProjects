public class Hamburger extends Item{

    protected Topping topping1;
    protected Topping topping2;
    protected Topping topping3;

    public Hamburger(String type, double price) {
        super(type, price);
    }
    public void AddToppings(String type){
        this.topping1 = new Topping(type);
    }
    public void AddToppings(String type1, String type2){
        this.topping1 = new Topping(type1);
        this.topping2 = new Topping(type2);
    }
    public void AddToppings(String type1, String type2, String type3){
        this.topping1 = new Topping(type1);
        this.topping2 = new Topping(type2);
        this.topping3 = new Topping(type3);
    }

    public double getTopping1Price(){
        if(topping1 != null)
            return topping1.getPrice();
        return 0;
    }
    public double getTopping2Price(){
        if(topping2 != null)
            return topping2.getPrice();
        return 0;
    }
    public double getTopping3Price(){
        if(topping3 != null)
            return topping3.getPrice();
        return 0;
    }
    @Override
    public String toString() {
        return "Hamburger = " + this.type + ", price: " + this.price + "\n" +
                "Topping 1: " + (this.topping1 == null ? "none" : this.topping1) + "\n" +
                "Topping 2: " + (this.topping2 == null ? "none" : this.topping2) + "\n" +
                "Topping 3: " + (this.topping3 == null ? "none" : this.topping3);
    }
}
