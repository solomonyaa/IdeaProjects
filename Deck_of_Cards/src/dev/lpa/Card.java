package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Card implements Comparable<Card> {

    protected Suit suit;
    protected String face;
    protected int rank;

    public Card(Suit suit, String face) {

        this.suit = suit;
        this.face = face;

        switch (this.face) {
            case "2" -> this.rank = 0;
            case "3" -> this.rank = 1;
            case "4" -> this.rank = 2;
            case "5" -> this.rank = 3;
            case "6" -> this.rank = 4;
            case "7" -> this.rank = 5;
            case "8" -> this.rank = 6;
            case "9" -> this.rank = 7;
            case "10" -> this.rank = 8;
            case "J" -> this.rank = 9;
            case "Q" -> this.rank = 10;
            case "K" -> this.rank = 11;
            case "A" -> this.rank = 12;
            default -> this.rank = -1;
        }

    }

    public static Card getNumericCard(Suit suit, int number) {

        if (number >= 2 && number <= 10)
            return new Card(suit, String.valueOf(number));

        System.out.println("Invalid Numeric Card Selected.");
        return null;
    }

    public static Card getFaceCard(Suit suit, String abbreviation) {

        var card = new Card(suit, abbreviation);
        if (card.rank != -1)
            return card;

        System.out.println("Invalid Face Card Selected.");
        return null;
    }

    public static List<Card> getStandardDeck() {

        List<Card> deck = new ArrayList<>(52);

        for (Suit s : Suit.getSuits()) {
            deck.addAll(getSuit(s));
        }
        return deck;
    }

    private static List<Card> getSuit(Suit suit) {

        List<Card> cardSuit = new ArrayList<>();

        for (int i = 2; i <= 10; i++) {
            cardSuit.add(getNumericCard(suit, i));
        }

        for (char c : new char[]{'J', 'Q', 'K', 'A'}) {
            cardSuit.add(getFaceCard(suit, String.valueOf(c)));
        }

        return cardSuit;
    }

    public static void printDeck(List<Card> deck) {
        printDeck(deck, "Current Deck", 4);
    }

    public static void printDeck(List<Card> deck, String description, int rows) {

        if (description != null)
            System.out.println("\n" + description + " (" + deck.size() + " Cards): ");

        int cardsInRow = deck.size() / rows;

        for (int i = 0; i < rows; i++) {
            int startIndex = i * cardsInRow;
            int endIndex = startIndex + cardsInRow;
            deck.subList(startIndex, endIndex).forEach(c -> System.out.print(c + " "));

            if (rows == 3 && i == rows - 1) {
                System.out.print(deck.get(deck.size() - 1));
            }
            System.out.println();
        }

        System.out.println("-".repeat(150));
        /*int counter = 1;
        while (counter <= deck.size()){

            System.out.print(deck.get(counter - 1) + " ");
            if(counter % cardsInRow == 0){
                System.out.println();
            }
            counter++;
        }*/

    }

    @Override
    public String toString() {
        //return String.format("%s%c(%d)", this.face, this.suit.getImage(), this.rank);
        return String.format("%s%c", this.face, this.suit.getImage());
    }

    @Override
    public int compareTo(Card otherCard) {
        return this.rank - otherCard.rank;
    }

    public String getName() {

        StringBuilder res = new StringBuilder();

        switch (this.rank) {
            case 0 -> res.append("Two");
            case 1 -> res.append("Three");
            case 2 -> res.append("Four");
            case 3 -> res.append("Five");
            case 4 -> res.append("Six");
            case 5 -> res.append("Seven");
            case 6 -> res.append("Eight");
            case 7 -> res.append("Nine");
            case 8 -> res.append("Ten");
            case 9 -> res.append("Jack");
            case 10 -> res.append("Queen");
            case 11 -> res.append("King");
            case 12 -> res.append("Ace");
            default -> res.append("-");
        }

        res.append(" of ");
        String suitStr = this.suit.toString().toLowerCase();
        var s1 = suitStr.substring(0, 1).toUpperCase();
        var s2 = suitStr.substring(1);
        res.append(s1).append(s2);
        res.append("s");
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {

        if(obj.getClass() == this.getClass()){
            Card card = (Card)obj;
            return (this.rank == card.rank) && (this.suit == card.suit);
        }
        return false;
    }

    public enum Suit {

        CLUB, DIAMOND, HEART, SPADE;

        public static Suit[] getSuits() {
            return Suit.values();
        }

        public char getImage() {

            return switch (this) {
                case CLUB -> 9827;
                case DIAMOND -> 9830;
                case HEART -> 9829;
                case SPADE -> 9824;
            };
        }
    }
}