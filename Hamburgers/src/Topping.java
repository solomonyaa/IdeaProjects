public class Topping extends Item{
    public Topping(String type) {
        this.type = type.toLowerCase();

        switch(this.type) {
            case "pickles":
                this.price = 1.0;
                break;
            case "lettuce":
                this.price = 1.5;
                break;
            case "tomatoes":
                this.price = 2.0;
                break;
            case "cheese":
            case "pineapple":
                this.price = 3.0;
                break;
            default:
                this.price = 0.0;
        }
    }
    @Override
    public String toString() {
        return this.getType() + ", price: " + this.getPrice();
    }
}
