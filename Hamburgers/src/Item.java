public class Item {
    protected String type;
    protected double price;

    public Item(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public Item() {}

    public double getPrice() {
        return this.price;
    }
    public String getType() {
        return this.type;
    }
}
