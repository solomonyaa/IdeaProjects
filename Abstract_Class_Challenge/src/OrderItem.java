public record OrderItem(ProductForSale product, int quantity) {

    @Override
    public String toString() {
        return this.product.printPricedItem(this.quantity);
    }
}
