package dev.lpa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BlackjackGameManager {

    private double casinoFunds;
    private List<Card> dealerHand;
    private final Player player;
    private double playerBet;
    private List<Card> deck;
    private int points;

    public BlackjackGameManager(Player player) {

        this.player = player;
        this.casinoFunds = 1000000;
        this.dealerHand = new ArrayList<>();
        this.deck = Card.getStandardDeck();
        this.points = 0;
    }

    public void play(double bet) {

        this.casinoFunds += bet;
        this.dealerHand = new ArrayList<>();
        this.points = 0;

        System.out.println("New Blackjack Game");
        System.out.println("Shuffling...");
        Collections.shuffle(deck);
        //Card.printDeck(deck);
        this.playerBet = bet;
        player.subtractFromBalance(bet);

        player.setHand(List.of(drawCard(), drawCard()));
        dealerHand.addAll(List.of(drawCard(), drawCard()));

        int playerPoints = calculatePoints(player.getHand());
        player.setPoints(playerPoints);
        this.points = calculatePoints(dealerHand);

        fixAcesPlayer();
        fixAcesDealer();

        if (player.getPoints() == 21) {
            stand();
            return;
        }

        printHands(false);
    }

    private void fixAcesPlayer() {

        int playerPoints = calculatePoints(player.getHand());
        int playerAceCount = aceFrequency(player.getHand());

        while (playerPoints > 21 && playerAceCount > 0) {
            playerPoints -= 10;
            playerAceCount--;
        }

        player.setPoints(playerPoints);
    }

    private void fixAcesDealer() {

        int dealerPoints = calculatePoints(dealerHand);
        int dealerAceCount = aceFrequency(dealerHand);

        while (dealerPoints > 21 && dealerAceCount > 0) {
            dealerPoints -= 10;
            dealerAceCount--;
        }

        this.points = dealerPoints;
    }

    public void hit() {

        Card card = drawCard();
        player.updateHand(card);

        fixAcesPlayer();

        if (player.getPoints() > 21) {
            printHands(true);
            var res = gameResult();
            player.updateScore(res);
            System.out.println(res);
            return;
        }

        if (player.getPoints() == 21) {
            stand();
            return;
        }

        printHands(false);
    }

    public void stand() {

        while (this.points < 17 && player.getPoints() <= 21) {
            dealerHand.add(drawCard());
            this.points = calculatePoints(dealerHand);
            fixAcesDealer();
        }

        printHands(true);

        var res = gameResult();
        player.updateScore(res);
        payProfit(res, this.playerBet);
        System.out.println(res);
    }

    private Card drawCard() {

        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }

    private int getValue(Card card) {

        return switch (card.face) {
            case "2" -> 2;
            case "3" -> 3;
            case "4" -> 4;
            case "5" -> 5;
            case "6" -> 6;
            case "7" -> 7;
            case "8" -> 8;
            case "9" -> 9;
            case "10", "J", "Q", "K" -> 10;
            case "A" -> 11;
            default -> 0;
        };
    }

    private int calculatePoints(List<Card> cards) {

        int sum = 0;
        for (Card card : cards) {
            sum += getValue(card);
        }
        return sum;
    }

    private int aceFrequency(List<Card> cards) {

        int aceFrequency = 0;
        for (Card card : cards) {

            if (Objects.equals(card.face, "A")) {
                aceFrequency++;
            }
        }
        return aceFrequency;
    }

    public void printHands(boolean showFullHand) {

        System.out.println("Player's Hand: " + player.getHand() + ", Points: " + player.getPoints());
        if (showFullHand)
            System.out.println("Dealer: " + this.dealerHand + ", Points: " + this.points);
        else {
            System.out.print("Dealer: [" + this.dealerHand.get(0));

            for (int i = 1; i < this.dealerHand.size(); i++) {
                System.out.print(", **");
            }
            System.out.print("]\n");
        }
    }

    private GameResult gameResult() {

        if (player.getPoints() > 21)
            return GameResult.LOSS;

        if (this.points > player.getPoints() && this.points <= 21)
            return GameResult.LOSS;

        if (this.points < player.getPoints() && player.getPoints() <= 21)
            return GameResult.WIN;

        if (player.getPoints() <= 21 && this.points > 21)
            return GameResult.WIN;

        return GameResult.DRAW;
    }

    private void payProfit(GameResult gameResult, double bet) {

        if (gameResult == GameResult.DRAW) {
            this.casinoFunds -= bet;
            this.player.addToBalance(bet);
        } else if (gameResult == GameResult.WIN) {
            if(checkBlackJack()){ //BJ
                this.casinoFunds -= (bet * 2.5);
                this.player.addToBalance(bet * 2.5);
            } else {
                this.casinoFunds -= (bet * 2);
                this.player.addToBalance(bet * 2);
            }
        }
    }

    public double getCasinoFunds() {
        return casinoFunds;
    }
    public void newDeck(){
        this.deck = Card.getStandardDeck();
    }
    private boolean checkBlackJack(){
        if(this.player.getHand().size() == 2){
            return calculatePoints(this.player.getHand()) == 21;
        }
        return false;
    }
}
