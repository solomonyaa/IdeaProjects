public class Carpet
{
    private double cost;

    public Carpet(double cost)
    {
        /*if(cost < 0)
            this.cost = 0;
        else
            this.cost = cost;*/
        this.cost = (cost < 0) ? 0 : cost; // ternary operator
    }
    public double getCost()
    {
        return this.cost;
    }
}
