public class Hello
{
    public static void main(String[] args)
    {
        System.out.println("Hello, Sol");
        boolean isAlien = false;
        if(!isAlien)
        {
            System.out.println("It is not an alien!");
            System.out.println("And I'm scared of aliens.");
        }
        int topScore = 80;
        if(topScore < 100)
        {
            System.out.println("You got the high score!");
        }

        int secondTopScore = 95;
        if((topScore > secondTopScore) && (topScore < 100))
        {
            System.out.println("Greater than second top score and less than 100.");
        }
        if((topScore > 90) || (secondTopScore <= 90))
        {
            System.out.println("Either or both of the conditions are true.");
        }
        int newValue = 50;
        if(newValue == 50)
        {
            System.out.println("This is true.");
        }
        boolean isCar = false;
        if(isCar) // = if(isCar == true)
            System.out.println("This is a car.");
        if(!isCar) // = if(isCar == false)
            System.out.println("This is not a car.");

        // Ternary Operator
        String makeOfCar = "Volkswagen";
        boolean isDomestic = makeOfCar == "Volkswagen" ? false : true;
        System.out.println("Is the car " + makeOfCar + " domestic to our country? " + isDomestic);

        boolean isDomestic2 = !(makeOfCar == "Volkswagen");
        System.out.println(isDomestic2);

        String s = (isDomestic) ? "This car is domestic" : "This car is not domestic";
        System.out.println(s);
    }
}
