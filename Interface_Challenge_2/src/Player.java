import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
    private String name;
    private int hitPoints;
    private int strength;
    private String weapon;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public List<String> write() {

        List<String> output = new ArrayList<>();
        output.add(0, name);
        output.add(1, Integer.toString(hitPoints));
        output.add(2, Integer.toString(strength));
        output.add(3, weapon);

        return output;
    }

    @Override
    public void read(List<String> input) {

        if (input == null || input.isEmpty()) {
            return;
        }
        this.name = input.get(0);
        this.hitPoints = Integer.parseInt(input.get(1));
        this.strength = Integer.parseInt(input.get(2));
        this.weapon = input.get(3);
    }

    @Override
    public String toString() {
        return "Player{" + "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' + '}';
    }
}
