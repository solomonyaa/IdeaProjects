public class Refrigerator
{
    protected boolean hasWorkToDo;
    public void orderFood()
    {
        if(hasWorkToDo)
        {
            System.out.println("Smart refrigerator is ordering food...");
            hasWorkToDo = false;
        }
    }
}
