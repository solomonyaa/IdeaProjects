public class Main
{
    public static void main(String[] args)
    {
        //region textBlock and formatting
        /*String textBlock = """
                Grocery list:
                    • milk
                    • bread
                    • chocolate
                    • coffee
                Thanks!""";
        System.out.println(textBlock); *//* The textBlock displays the text as seen in the code. *//*

        int age = 33;
        System.out.printf("Your birth year is: %d%nYour age is: %d", 2023 - age, age);
        // d = decimal integer value

        System.out.printf("Your birth year is: %d%nYour age is: %.2f%n", 2023 - age, (float)age);
        // f = float value

        String formattedString = String.format("Your age is %d", age);
        System.out.println(formattedString);
        // or:
        formattedString = "Your age is %d".formatted(age);
        System.out.println(formattedString);*/
        //endregion

        //region String Inspection methods
        /*printStringInformation("cookie");
        printStringInformation("");
        printStringInformation("\t\n\t ");

        String helloWorld = "Hello World";
        int index = helloWorld.indexOf('r');
        System.out.printf("index of r is: %d %n", index);
        index = helloWorld.indexOf("World");
        System.out.printf("index of 'World' is: %d %n", index);

        System.out.println(helloWorld.indexOf('o',5)); // searches forward (from left to right)
        System.out.println(helloWorld.lastIndexOf('o',9)); // searches backward (from right to left)*/
        //endregion

        //region StringBuilder - a mutable version of String, easier to manipulate and change.
        String helloWorld = "Hello" + " World";
        helloWorld.concat(" and Goodbye"); // ignored because String is immutable

        StringBuilder helloWorldBuilder = new StringBuilder("Hello" + " World");
        helloWorldBuilder.append(" and Goodbye");

        printInfo(helloWorld);
        printInfo(helloWorldBuilder);

        StringBuilder builderPlus = new StringBuilder("Hello" + " World");
        builderPlus.append(" and Goodbye").deleteCharAt(16).insert(16, 'g');
        System.out.println(builderPlus);
        builderPlus.replace(16,17, "G");
        System.out.println(builderPlus);
        builderPlus.reverse().setLength(7);
        System.out.println(builderPlus);
        //endregion
    }
    public static void printStringInformation(String string)
    {
        int length = string.length();
        System.out.printf("Length = %d %n", length);
        if(string.isEmpty())
        {
            System.out.println("String is empty");
            return;
        }
        if(string.isBlank())
        {
            System.out.println("String is blank");
        }

        System.out.printf("First char = %c %n", string.charAt(0));
        System.out.printf("Last char = %c %n", string.charAt(length - 1));
        System.out.println(string.toUpperCase());
    }
    public static void printInfo(String string)
    {
        System.out.println("String = " + string);
        System.out.println("Length = " + string.length());
    }
    public static void printInfo(StringBuilder stringBuilder)
    {
        System.out.println("String Builder = " + stringBuilder);
        System.out.println("Length = " + stringBuilder.length());
    }
}
