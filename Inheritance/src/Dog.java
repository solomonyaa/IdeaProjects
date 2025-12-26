public class Dog extends Animal
{
    private String earShape;
    private String tailShape;

    public Dog()
    {
        super("Unknown type of dog", "unknown", 25); //calling the default constructor in Animal class
    }

    public Dog(String type, double weight)
    {
        this(type, weight, "Perky", "Curled"); // if not specified all dogs have perky ears and curled a tail
    }

    public Dog(String type, double weight, String earShape, String tailShape)
    {
        super(type, weight < 15 ? "small" : (weight < 35 ? "medium" : "large"), weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    @Override
    public String toString()
    {
        return "Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString();
    }

    public void makeNoise()
    {
        if(type == "Wolf")
            System.out.println("Ow Wooooo! ");
        bark();
        System.out.println();
    }

    @Override
    public void move(String speed)
    {
        super.move(speed); // invoking the method of the 'father' class
        // and adding additional behavior:

        if(speed == "slow")
        {
            walk();
            wagTail();
        }
        else
        {
            run();
            bark();
        }
        System.out.println();
    }
    private void bark()
    {
        System.out.print("Woof! ");
    }
    private void run()
    {
        System.out.print("Dog Running ");
    }
    private void walk()
    {
        System.out.print("Dog Walking ");
    }
    private void wagTail()
    {
        System.out.print("Tail Wagging ");
    }
}
