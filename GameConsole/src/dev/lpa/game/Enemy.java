package dev.lpa.game;

import java.util.Random;

public class Enemy {

    private final String name;
    private int health;
    private int strike;

    public Enemy(String name, int health, int strike) {
        this.name = name;
        this.health = health;
        this.strike = strike;
    }

    public String getName() {
        return name;
    }

    public String getHealth() {
        return "HP = " + health;
    }

    boolean damaged(int damage){

        this.health -= damage;
        if(this.health <= 0){
            this.health = 0;
            return true; //dead
        }
        return false; //alive
    }

    double enemyAttack(){
        return new Random().nextDouble(0.1, 0.5) * strike * -1;
    }

    @Override
    public String toString() {
        return name;
    }
}
