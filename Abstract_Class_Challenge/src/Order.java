import java.util.ArrayList;

public class Order {
    private static int num = 0;
    private double price;
    private final ArrayList<OrderItem> itemsInOrder;

    public Order() {
        num += 1;
        itemsInOrder = new ArrayList<>();
    }

    public boolean addItemToOrder(ProductForSale product, int quantity) {

        OrderItem orderItem = new OrderItem(product, quantity);
        ProductForSale p = orderItem.product();
        if (Store.findProduct(p.getType()) != null && quantity <= p.stock) {
            itemsInOrder.add(orderItem);
            p.stock -= quantity;
            return true;
        }
        return false;
    }

    public void printOrder() {

        System.out.println("Items on order " + num + ": ");
        for (OrderItem oi : itemsInOrder) {
            System.out.println(oi);
        }
        System.out.println("Total: $" + getPrice());
        System.out.println("-".repeat(100));
    }
    private double getPrice(){
        for (OrderItem orderItem : itemsInOrder) {
            var quantity = orderItem.quantity();
            this.price += orderItem.product().getSalesPrice(quantity);
        }
        return this.price;
    }
}
