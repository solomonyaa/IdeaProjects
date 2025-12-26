package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private double balance;
    private List<Card> hand;
    private int points;
    private List<GameResult> score;


    public Player() {

        this.balance = 2500;
        this.hand = new ArrayList<>();
        this.points = 0;
        this.score = new ArrayList<>();
    }

    protected double getBalance() {
        return balance;
    }

    protected void addToBalance(double amount) {
        this.balance += amount;
    }

    protected void subtractFromBalance(double amount) {
        this.balance -= amount;
    }

    protected List<Card> getHand() {
        return hand;
    }

    protected void setHand(List<Card> hand) {
        this.hand = hand;
    }

    protected void updateHand(Card c) {
        List<Card> copied = new ArrayList<>(this.hand);
        copied.add(c);
        this.hand = copied;
    }

    protected int getPoints() {
        return this.points;
    }

    protected void setPoints(int points) {
        this.points = points;
    }

    protected List<GameResult> getScore() {
        return score;
    }

    protected void setScore(List<GameResult> score) {
        this.score = score;
    }

    protected void updateScore(GameResult gameResult) {
        this.score.add(gameResult);
    }
}
