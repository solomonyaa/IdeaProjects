public class CoffeeMaker
{
    protected boolean hasWorkToDo;
    public void brewCoffee()
    {
        if(hasWorkToDo)
        {
            System.out.println("Smart coffee maker is brewing coffee...");
            hasWorkToDo = false;
        }
    }
}
