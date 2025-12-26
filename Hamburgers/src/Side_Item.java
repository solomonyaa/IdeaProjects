public class Side_Item extends Item{
    private String size;
    public Side_Item(String type, String size, double price) {
        super(type, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
