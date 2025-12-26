import java.util.ArrayList;

public class Store {

    private static final ArrayList<ProductForSale> products = new ArrayList<>();
    //private static final ArrayList<OrderItem> order = new ArrayList<>();

    public static void main(String[] args) {

        Sweet chocolate = new Sweet
                ("Toblerone Chocolate", 15, "swiss chocolate bar", 25);
        Drink tea = new Drink
                ("Greenfield Tea", 10, "russian premium tea", 51);
        Fruit apple = new Fruit
                ("Jonathan Apples", 5.1, "american medium-sized sweet apple", 1000);

        addProduct(chocolate);
        addProduct(tea);
        addProduct(apple);

        //removeProduct(chocolate);

        displayProductsInStore();

        Order order1 = new Order();

        order1.addItemToOrder(chocolate, 7);
        order1.addItemToOrder(tea, 4);
        order1.addItemToOrder(apple, 24);

        order1.printOrder();

        Order order2 = new Order();

        order2.addItemToOrder(chocolate, 3);
        order2.addItemToOrder(tea, 2);
        order2.addItemToOrder(apple, 10);

        order2.printOrder();


        var milk = createProduct("Milk", 5, "3% fat pasteurized fresh milk", 90);
        addProduct(milk);
        updateStock(milk, 110);
        displayProductsInStore();

    }

    public static GeneralProduct createProduct(String type, double price, String description, int stock) {
        return new GeneralProduct(type, price, description, stock);
    }

    public static boolean addProduct(ProductForSale p) {

        var product = findProduct(p.getType());
        if (product == null) {
            products.add(p);
            return true;
        }
        return false;
    }

    public static boolean removeProduct(ProductForSale p) {

        var product = findProduct(p.getType());
        if (product != null) {
            products.remove(p);
            return true;
        }
        return false;
    }

    public static void updateStock(ProductForSale p, int stock) {
        p.stock = stock;
    }

    public static ProductForSale findProduct(String type) {

        for (ProductForSale p : products) {
            if (p.getType().equals(type)) {
                return p;
            }
        }
        return null;
    }

    public static void displayProductsInStore() {

        System.out.println("Products for sale: ");
        for (ProductForSale product : products) {
            System.out.println(product.showDetails());
        }
        System.out.println("-".repeat(100));
    }


    /*public static boolean addItemToOrder(ProductForSale product, int quantity) {

        //OrderItem orderItem = new OrderItem(product, quantity);
        ProductForSale p = orderItem.getProduct();
        if (findProduct(p.getType()) != null && quantity <= p.stock) {
            order.add(orderItem);
            p.stock -= quantity;
            return true;
        }
        return false;
    }*/

    /*public static void printOrder() {

        System.out.println("Items on order: ");
        for (OrderItem oi : order) {
            System.out.println(oi);
        }
        System.out.println("-".repeat(100));
    }*/

    //Store manages a list of products for sale, including displaying the product details.

    //Order class manges a new order(instance) which has list of OrderItem objects.
    //and has methods like adding an item to the order, and printing the ordered items.
}
