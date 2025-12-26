public class GeneralProduct extends ProductForSale{
    public GeneralProduct(String type, double price, String description, int stock) {
        super(type, price, description, stock);
    }
    @Override
    public String showDetails() {
        return "Type: " + this.type + ", Price: $" + this.price +
                ", Description: " + this.description + ", In stock: " + this.stock;
    }
}
