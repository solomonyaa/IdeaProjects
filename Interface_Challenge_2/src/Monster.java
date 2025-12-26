import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }


    @Override
    public List<String> write() {

        List<String> output = new ArrayList<>();
        output.add(0, name);
        output.add(1, Integer.toString(hitPoints));
        output.add(2, Integer.toString(strength));

        return output;
    }

    @Override
    public void read(List<String> input) {

        if(input == null || input.isEmpty()){
            return;
        }
        this.name = input.get(0);
        this.hitPoints = Integer.parseInt(input.get(1));
        this.strength = Integer.parseInt(input.get(2));
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }
}
