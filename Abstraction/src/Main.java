import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog("Wolf", "medium", 50);
        //dog.makeNoise();
        //doAnimalStuff(dog);

        Fish goldfish = new Fish("Goldfish", "small", 5);
        //doAnimalStuff(goldfish);

        Fish shark = new Fish("Shark", "big", 400);
        //doAnimalStuff(shark);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard", "medium", 30));
        animals.add(goldfish);
        animals.add(shark);
        animals.add(new Horse("Clydesdale", "large", 300));

        for (Animal animal : animals) {
            doAnimalStuff(animal);
            if(animal instanceof Mammal currentMammal){
                currentMammal.shedHair();
            }
        }

    }
    private static void doAnimalStuff(Animal animal){
        animal.makeNoise();
        animal.move("slow");
    }
}