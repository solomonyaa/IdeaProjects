public class Animal
{
    protected String type; // protected = let any class that is subclass access this field.
    private String size;
    private double weight;
    public Animal() {} // empty constructor
    public Animal(String type, String size, double weight)
    {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return "Animal{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }
    public void makeNoise()
    {
        System.out.println(type + " makes some kind of noise");
    }
    public void move(String speed)
    {
        System.out.println(type + " moves " + speed);
    }

}
