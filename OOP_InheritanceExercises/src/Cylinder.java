public class Cylinder extends Circle
{
    private double height;
    public Cylinder(double radius, double height)
    {
        super(radius); // calling the parent constructor to initialize the radius field
        this.height = (height < 0) ? 0 : height;
    }
    public double getHeight()
    {
        return height;
    }
    public double getVolume()
    {
        return height * this.getArea();
    }
}
