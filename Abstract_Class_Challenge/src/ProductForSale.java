
public abstract class ProductForSale {
    protected String type;
    protected double price;
    protected String description;
    protected int stock;

    public ProductForSale(String type, double price, String description, int stock) {
        this.type = type;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    public double getSalesPrice(int quantity){
        return (quantity * price);
    }

    public String printPricedItem(int quantity){
        return "Type: " + type + " (" + this.getClass().getSimpleName() + "s)" +
                ", Quantity: " + quantity + ", Price: $" + price +
                ", Total: $" + getSalesPrice(quantity);
    }

    public abstract String showDetails();
    // show Details - an abstract method, which represents what might be displayed on a
    // product page, product type, description, price, and so on.
}
