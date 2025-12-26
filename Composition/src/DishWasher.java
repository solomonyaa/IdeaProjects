public class DishWasher
{
    protected boolean hasWorkToDo;
    public void doDishes()
    {
        if(hasWorkToDo)
        {
            System.out.println("Smart dishwasher is washing the dishes...");
            hasWorkToDo = false;
        }
    }
}
