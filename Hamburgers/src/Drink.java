public class Drink extends Item{
    private String size;
    public Drink(String type, String size) {

        this.size = size;
        this.type = type;

        switch(this.size.toLowerCase()) {
            case "small":
                this.price = 5.0;
                break;
            case "medium":
                this.price = 7.5;
                break;
            case "large":
                this.price = 10.0;
                break;
            default:
                this.price = 5.0;
        }
    }

    public String getSize() {
        return size;
    }
}
