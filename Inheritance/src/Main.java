public class Main extends Object
{
    public static void main(String[] args)
    {
        Animal animal = new Animal("Generic Animal", "Huge", 400);
        doAnimalStuff(animal, "slow");

        Dog dog = new Dog();
        doAnimalStuff(dog, "fast");

        Dog yorkie = new Dog("Yorkie", 15);
        doAnimalStuff(yorkie, "fast");

        Dog retriever = new Dog("Labrador Retriever", 65, "Floppy", "Swimmer");
        doAnimalStuff(retriever, "slow");

        Animal wolf = new Dog("Wolf", 50);
        doAnimalStuff(wolf, "slow");

        Fish goldie = new Fish("Goldfish", 0.5, 2, 5);
        doAnimalStuff(goldie, "fast");
    }
    public static void doAnimalStuff(Animal animal, String speed)
    {
        animal.makeNoise();
        animal.move(speed);
        System.out.println(animal); // toString
        System.out.println("________");
    }
}