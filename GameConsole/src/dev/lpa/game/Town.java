package dev.lpa.game;

public class Town {

    private static int lastIndex = 1;
    private final int index;
    private final String name;
    private Enemy enemy;

    public Town(String name, Enemy enemy) {
        this.index = lastIndex++;
        this.name = name;
        this.enemy = enemy;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public String toString() {
        return "%s (%d)".formatted(name, index);
    }
}
