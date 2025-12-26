public class Singleton {

    // Step 1: Create a private static variable to hold the single instance of the class
    private static Singleton singleInstance = null;

    // Step 2: Create a public variable
    public String str;

    // Step 3: Make the constructor private to restrict instantiation from other classes
    private Singleton() {
        str = "Hello, I am a singleton class!";
    }

    // Step 4: Create a static method to provide the single instance of the class
    public static Singleton getSingleInstance(){

        if(singleInstance == null)
            singleInstance = new Singleton();

        return singleInstance;
    }
}
