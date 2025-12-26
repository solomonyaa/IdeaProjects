public class Point
{
    private int x;
    private int y;
    public Point()
    {
        this(0, 0);
    }
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }
    public double distance()
    {
        //Point p0 = new Point(0,0);
        return calcDistance(new Point(0,0));
    }
    public double distance(int x, int y)
    {
        //Point otherP = new Point(x,y);
        return calcDistance(new Point(x,y));
    }
    public double distance(Point otherP)
    {
        return calcDistance(otherP);
    }
    private double calcDistance(Point p)
    {
        return Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
    }
}
