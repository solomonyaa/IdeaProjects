package dev.lpa;

import java.util.LinkedHashMap;
import java.util.Map;

public class Player {

    private final String name;
    private final Map<String, Integer> scoringBoard;
    private int scoreSum;
    private int rolls;
    private boolean isScored;

    public Player(String name) {
        this.name = name;
        this.scoreSum = 0;
        this.rolls = 3;
        this.isScored = false;
        this.scoringBoard = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getScoreSum() {
        return scoreSum;
    }

    public int getRolls() {
        return rolls;
    }

    public void decreaseRolls() {
        if (this.rolls > 0)
            this.rolls--;
    }

    public void resetRolls() {
        this.rolls = 3;
    }

    public boolean isScored() {
        return isScored;
    }

    public void setScored(boolean scored) {
        isScored = scored;
    }

    public boolean setPlayerScore(String category, int score) {
        if (!scoringBoard.containsKey(category)) {
            this.scoringBoard.put(category, score);
            this.scoreSum += score;
            return true;
        } else {
            return false;
        }
    }

    public void printScoringBoard() {
        System.out.println(name + "'s score board: ");
        scoringBoard.forEach((k, v) -> System.out.println(k + " = " + v));
        System.out.println("Overall Score = " + scoreSum);
    }

    @Override
    public String toString() {
        return "\nName: " + this.name +
               "\nRolls: " + this.rolls;
    }
}
