package dev.lpa.game;

public enum Weapon {

    CUTLASS(30, 1),
    PISTOL(50, 2),
    BLUNDERBUSS(75, 3);

    // Fields for each Weapon
    private final int hitPoints;
    private final int minLevel;

    Weapon(int hitPoints, int minLevel) {
        this.hitPoints = hitPoints;
        this.minLevel = minLevel;
    }

    public static Weapon getWeaponByLevel(int level) {

        return switch (level) {
            case 1 -> CUTLASS;
            case 2 -> PISTOL;
            case 3 -> BLUNDERBUSS;
            default -> CUTLASS;
        };
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getMinLevel() {
        return minLevel;
    }

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase()
               + " (Damage: " + hitPoints + ")";
    }
}

