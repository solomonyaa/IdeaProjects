package dev.lpa.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Pirate implements Player {

    private final String name;
    private final List<Town> townsVisited;
    private int level;
    private List<Town> townsToVisit;
    private Weapon currentWeapon;
    private Town currentTown;
    private int health;
    private int healingPotions;

    public Pirate(String name) {
        this.name = name;
        this.level = 1;
        this.townsVisited = new ArrayList<>();
        this.currentWeapon = Weapon.getWeaponByLevel(this.level);
        this.townsToVisit = PirateGame.getGameStage(0);
        this.currentTown = null;
        this.health = 100;
        this.healingPotions = 5;

        System.out.println(this);
        visitTown();
    }

    @Override
    public String name() {
        return this.name;
    }

    public boolean getTownsVisited() {

        if (townsVisited.isEmpty())
            System.out.println("No towns were visited");
        else {
            for (Town t : townsVisited) {
                System.out.print(t + ", ");
                if (t.getIndex() % 3 == 0)
                    System.out.println();
            }
            System.out.println();
        }

        return false;
    }

    boolean attack() {

        if (currentTown == null) {
            System.out.println("No enemy in sight.");
            return false;
        }

        Enemy foe = currentTown.getEnemy();
        if (foe != null) {

            // randomize success of enemy attack
            var lot = new Random().nextInt(1, 11);
            if (lot >= 1 && lot <= 9) {

                var res = foe.damaged(currentWeapon.getHitPoints());
                System.out.println(name + " attacked the " + foe.getName() + " with the " + currentWeapon);
                if (!res)
                    System.out.println(foe.getName() + "'s " + foe.getHealth());
                else {
                    System.out.println(this.name + " has killed the " + foe.getName());
                    if (foe.getName().equals("Kraken")) {
                        System.out.println("Congrats! You Finished the Game!");
                        return true;
                    }
                    currentTown.setEnemy(null);

                    if (townsVisited.size() == 3 || townsVisited.size() == 6) {
                        updateLevel();
                    }
                }

            } else { // lot == 10 -> 10% chance
                System.out.println(name + " missed the " + foe.getName());
                return enemyAttacksPlayer();
            }

        } else {
            System.out.println("No enemy in sight.");
        }

        return false;
    }

    boolean visitTown() {

        if (!townsToVisit.isEmpty()) {
            if (canProceedToNextTown())
                currentTown = townsToVisit.remove(0);
            else
                return false;
        } else {
            return canProceedToNextTown();
        }

        if (currentTown != null) {
            Enemy enemy = currentTown.getEnemy();
            System.out.println(name + " is visiting the " + currentTown);
            System.out.println("Enemy: " + enemy + ", " + enemy.getHealth());

            boolean res = enemyAttacksPlayer();
            if(res) return true;
        }

        if (!townsVisited.contains(currentTown)) {
            townsVisited.add(currentTown);
        }

        return false;
    }

    private boolean enemyAttacksPlayer(){

        var status = playerGetsHit();
        System.out.println(currentTown.getEnemy() + " attacks " + name + "...");
        if (!status){
            System.out.println(name + "'s HP = " + health);
            return false;
        }
        else {
            System.out.println(name + " has been killed.\nGame Over!");
            return true;
        }
    }

    private void updateLevel() {

        this.level++;
        if (this.level <= 3) {
            this.currentWeapon = Weapon.getWeaponByLevel(this.level);
            this.townsToVisit = PirateGame.getGameStage(this.level - 1);
        }
        System.out.println("Level Up!\nWeapon upgraded to " + this.currentWeapon);
    }

    private boolean canProceedToNextTown() {

        if (currentTown == null)
            return true;

        if (currentTown.getEnemy() != null) {
            System.out.println("You first need to kill the " + currentTown.getEnemy());
            return false;
        }
        return true;
    }

    private boolean playerGetsHit() {

        this.health += (int) currentTown.getEnemy().enemyAttack();
        if (this.health <= 0) {
            this.health = 0;
            return true; // player died
        }
        return false; // player survives
    }

    boolean drinkPotion() {

        if (this.healingPotions <= 0) {
            System.out.println("No Healing Potions Left.");
            return false;
        }

        this.health += (int) ((100 - this.health) * 0.5);
        if (this.health > 100) {
            this.health = 100;
        }
        this.healingPotions--;
        System.out.println(name + " feels refreshed (HP = " + health + ")"
                           + "\nHealing potions left: " + this.healingPotions);
        return false;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Level: " + level +
               ", HP: " + health + ", Weapon: " + currentWeapon.toString();
    }
}
