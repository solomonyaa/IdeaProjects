package dev.lpa;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class YahtzeeGame {

    private final Player player;
    private List<Integer> currentDice;
    private Random random;

    public YahtzeeGame(Player p1) {

        this.random = new Random();
        this.currentDice = new ArrayList<>();
        this.player = p1;
    }

    private static String getCategoryString(int categoryIndex) {
        String category = "";

        switch (categoryIndex) {
            case 1 -> category = "Ones";
            case 2 -> category = "Twos";
            case 3 -> category = "Threes";
            case 4 -> category = "Fours";
            case 5 -> category = "Fives";
            case 6 -> category = "Sixes";
            case 7 -> category = "Chance";
            case 8 -> category = "Three Of A Kind";
            case 9 -> category = "Four Of A Kind";
            case 10 -> category = "Full House";
            case 11 -> category = "Small Straight";
            case 12 -> category = "Large Straight";
            case 13 -> category = "Yahtzee";
        }
        return category;
    }

    public void playGame() {

        do {
            if (player.getRolls() <= 0) {
                System.out.println("Rolls = " + player.getRolls());
                continue;
            }
            rollDice(currentDice);
            System.out.println("Rolls = " + player.getRolls());
        } while (!userChoice(currentDice));

        if (!player.isScored()) {
            printScoring(currentDice);
        }

        System.out.print("Play another game? ");
        String userAnswer = new Scanner(System.in).nextLine();

        if (userAnswer.toLowerCase().startsWith("y")) {
            resetGame();
            playGame();
        } else {
            System.out.println("Game Over. Your final score is " + player.getScoreSum());
        }
    }

    private void rollDice(List<Integer> currentDice) {

        int randomCount = 5 - currentDice.size();

        var newDice = random.
                ints(randomCount, 1, 7)
                .sorted()
                .boxed()
                .toList();

        currentDice.addAll(newDice);
        Collections.sort(currentDice);
        System.out.println("Your dice are: " + currentDice);
        player.decreaseRolls();
    }

    private boolean userChoice(List<Integer> currentDice) {

        String prompt = """
                Press enter to score.
                Type "ALL" to re-roll all the dice.
                List numbers (separated by spaces) to re-roll selected dice.
                """;

        System.out.print(prompt + "-->  ");
        String userInput = new Scanner(System.in).nextLine();

        if (userInput.isBlank()) { // user presses enter

            printScoring(currentDice);
            this.player.setScored(true);
            return true;
        }

        try {                   // user enters numbers or "ALL"
            removeDice(currentDice, userInput.split(" "));
        } catch (Exception e) { // user enters bad input
            e.printStackTrace(System.out);
            System.out.println("Bad input, please try again.");
        }

        return false;
    }

    private void removeDice(List<Integer> currentDice, String[] selected) {

        if (player.getRolls() <= 0) return;

        if (selected.length == 1 && selected[0].toUpperCase().contains("ALL")) {
            currentDice.clear();
        } else {

            for (String removed : selected) {
                currentDice.remove(Integer.valueOf(removed));
            }
        }
    }

    private Map<String, Integer> getScoreMap(List<Integer> currentDice) {

        Map<String, Integer> categoryScore = new LinkedHashMap<>();

        for (int i = 1; i <= 6; i++) {

            var res = upperSection(currentDice, i);
            String category = "";
            switch (i) {
                case 1 -> category = "Ones";
                case 2 -> category = "Twos";
                case 3 -> category = "Threes";
                case 4 -> category = "Fours";
                case 5 -> category = "Fives";
                case 6 -> category = "Sixes";
            }

            categoryScore.put(category, res);
        }

        categoryScore.put("Chance", chance(currentDice));
        categoryScore.put("Three Of A Kind", threeOfAKind(currentDice));
        categoryScore.put("Four Of A Kind", fourOfAKind(currentDice));
        categoryScore.put("Full House", fullHouse(currentDice));
        categoryScore.put("Small Straight", smallStraight(currentDice));
        categoryScore.put("Large Straight", largeStraight(currentDice));
        categoryScore.put("Yahtzee", yahtzee(currentDice));

        return categoryScore;
    }

    private int upperSection(List<Integer> currentDice, int category) {

        int res = 0;

        for (Integer x : currentDice) {
            if (x == category) {
                res += x;
            }
        }

        return res;
    }

    private int chance(List<Integer> currentDice) {

        int sum = 0;
        for (Integer i : currentDice) {
            sum += i;
        }

        return sum;
    }

    private int threeOfAKind(List<Integer> currentDice) {

        if (currentDice.get(0).equals(currentDice.get(1)) &&
            currentDice.get(1).equals(currentDice.get(2))) {
            return chance(currentDice);
        } else if (currentDice.get(1).equals(currentDice.get(2)) &&
                   currentDice.get(2).equals(currentDice.get(3))) {
            return chance(currentDice);
        } else if (currentDice.get(2).equals(currentDice.get(3)) &&
                   currentDice.get(3).equals(currentDice.get(4))) {
            return chance(currentDice);
        }

        return 0;
    }

    private int fourOfAKind(List<Integer> currentDice) {

        if (currentDice.get(0).equals(currentDice.get(1)) &&
            currentDice.get(1).equals(currentDice.get(2)) &&
            currentDice.get(2).equals(currentDice.get(3))) {
            return chance(currentDice);
        } else if (currentDice.get(1).equals(currentDice.get(2)) &&
                   currentDice.get(2).equals(currentDice.get(3)) &&
                   currentDice.get(3).equals(currentDice.get(4))) {
            return chance(currentDice);
        }

        return 0;
    }

    private int fullHouse(List<Integer> currentDice) {

        if (!currentDice.get(0).equals(currentDice.get(1))) {
            return 0;
        } else {
            if (currentDice.get(2).equals(currentDice.get(3)) &&
                currentDice.get(3).equals(currentDice.get(4))) {
                return 25;
            } else if (currentDice.get(1).equals(currentDice.get(2)) &&
                       currentDice.get(3).equals(currentDice.get(4))) {
                return 25;
            } else {
                return 0;
            }
        }
    }

    private int smallStraight(List<Integer> currentDice) {

        if (currentDice.get(0).equals(currentDice.get(1) - 1) &&
            currentDice.get(1).equals(currentDice.get(2) - 1) &&
            currentDice.get(2).equals(currentDice.get(3) - 1)) {
            return 30;
        } else if (currentDice.get(1).equals(currentDice.get(2) - 1) &&
                   currentDice.get(2).equals(currentDice.get(3) - 1) &&
                   currentDice.get(3).equals(currentDice.get(4) - 1)) {
            return 30;
        }

        return 0;
    }

    private int largeStraight(List<Integer> currentDice) {

        for (int i = 1; i < currentDice.size(); i++) {

            if (!currentDice.get(i - 1).equals(currentDice.get(i) - 1)) {
                return 0;
            }
        }

        return 40;
    }

    private int yahtzee(List<Integer> currentDice) {

        for (int i = 1; i < currentDice.size(); i++) {

            if (!currentDice.get(i - 1).equals(currentDice.get(i))) {
                return 0;
            }
        }

        return 50;
    }

    private void printScoring(List<Integer> currentDice) {

        Collections.sort(currentDice);
        var map = getScoreMap(currentDice);
        AtomicInteger index = new AtomicInteger();

        map.forEach((k, v) ->
                System.out.println(index.incrementAndGet() + " - " + k + " Score: " + v));

        var res = false;

        while (!res) {
            System.out.print("Please enter the index of category which score you want to save: ");

            var categoryIndex = new Scanner(System.in).nextLine();
            int num;

            try {
                num = Integer.parseInt(categoryIndex);
            } catch (Exception pe) {
                pe.printStackTrace(System.out);
                continue;
            }

            String category = getCategoryString(num);
            res = player.setPlayerScore(category, map.get(category));
        }

        System.out.println("Score was saved.");
        player.printScoringBoard();
    }

    private void resetGame() {

        player.resetRolls();
        player.setScored(false);
        this.random = new Random();
        this.currentDice = new ArrayList<>();
    }
}
