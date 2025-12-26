package dev.lpa;

import java.io.Console;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, "A");
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Aces Of Hearts", 1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts); // Does not work!!
        System.out.println(cards);
        System.out.println("cards.size() = " + cards.size());


        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);


        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, "K");
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);


        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card Collection with Aces Added", 1);

        Collections.copy(cards, kingsOfClubs);
        Card.printDeck(cards, "Card Collection with Kings Copied", 1);

        cards = List.copyOf(kingsOfClubs); // unmodifiable list!
        Card.printDeck(cards, "List Copy of Kings", 1);


        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck", 4);

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed Deck", 4);

        var sortingAlgorithm = Comparator.comparing((Card card) -> card.rank)
                .thenComparing((Card card) -> card.suit);

        Collections.sort(deck, sortingAlgorithm); // same as deck.sort(sortingAlgorithm);
        Card.printDeck(deck, "Standard Deck Sorted by Rank, Suit", 13);

        Collections.reverse(deck);
        Card.printDeck(deck, "Sorted by Rank, Suit Reversed", 13);

        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "Kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(tens, "Tens in deck", 1);

        //Collections.shuffle(deck);

        int subListIndex = Collections.indexOfSubList(deck, tens); // index where tens start
        System.out.println("sublist index for tens = " + subListIndex);
        System.out.println("Contains = " + deck.containsAll(tens));

        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("disjoint = " + disjoint);

        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("disjoint = " + disjoint2);


        //#region deck.indexOf
        deck.sort(sortingAlgorithm);
        Card.printDeck(deck, "Standard Deck - 13 Rows", 13);

        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm);
        System.out.println("foundIndex of " + tenOfHearts + " is: " + foundIndex);
        System.out.println("Index Of " + deck.get(foundIndex) + " = " + deck.indexOf(tenOfHearts));

        System.out.println("equals = " + Objects.equals(tenOfHearts, deck.get(foundIndex)));
        //endregion

        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        Collections.replaceAll(deck, tenOfClubs, tenOfHearts);
        Card.printDeck(deck.subList(32, 36), "Tens Row", 1);

        Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
        Card.printDeck(deck.subList(32, 36), "Tens Row", 1);

        var booleanResult = Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
        if (booleanResult) {
            System.out.println("Tens of hearts was replaced with tens of clubs.");
        } else {
            System.out.println("No matching tens of hearts were found.");
        }

        System.out.println("Ten of Clubs Cards = " + Collections.frequency(deck, tenOfClubs));

        System.out.println("First Card = " + Collections.min(deck, sortingAlgorithm));
        System.out.println("Last Card = " + Collections.max(deck, sortingAlgorithm));

        var sortBySuit = Comparator.comparing((Card c) -> c.suit)
                .thenComparing((Card c) -> c.rank);
        deck.sort(sortBySuit);
        Card.printDeck(deck, "Sorted by Suit, Rank", 4);


        List<Card> copied = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copied, 2);
        System.out.println("Unrotated: " + deck.subList(0, 13));
        System.out.println("Rotated " + 2 + ": " + copied);

        System.out.println();

        copied = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copied, -2);
        System.out.println("Unrotated: " + deck.subList(0, 13));
        System.out.println("Rotated " + -2 + ": " + copied);

        System.out.println();

        copied = new ArrayList<>(deck.subList(0, 13));
        System.out.println("Before Reverse: " + copied);

        for (int i = 0; i < copied.size() / 2; i++) {
            Collections.swap(copied, i, copied.size() - 1 - i);
        }

        System.out.println("Manual Reverse: " + copied);

        // same as Collections.reverse
        copied = new ArrayList<>(deck.subList(0, 13));
        Collections.reverse(copied);
        System.out.println("Using Collections.reverse: " + copied);
        

    }
}