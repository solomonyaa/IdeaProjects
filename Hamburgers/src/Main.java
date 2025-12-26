public class Main {
    public static void main(String[] args) {

        Meal_Order meal1 = new Meal_Order();

        System.out.println(meal1);

        Hamburger hamburger2 = new Hamburger("Big", 22);
        hamburger2.AddToppings("pickles", "cheese", "tomatoes");
        Meal_Order meal2 = new Meal_Order(
                hamburger2,
                new Drink("Sprite", "Medium"),
                new Side_Item("Home Fries", "Big", 15));

        System.out.println(meal2);

        DeluxeHamburger deluxeHamburger = new DeluxeHamburger();
        Meal_Order meal3 = new Meal_Order(
                deluxeHamburger,
                new Drink("Fanta", "Big"),
                new Side_Item("Fries", "big", 15));
        meal3.AddToppings("pickles", "lettuce", "tomatoes", "cheese", "pineapple");

        System.out.println(meal3);


        meal1.AddToppings("tomatoes", "cheese");
        meal1.changeDrink("medium");

        System.out.println(meal1);
    }
}