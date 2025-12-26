package dev.lpa;

import java.util.Scanner;

public class MainGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        Player player = new Player();
        BlackjackGameManager gameManager = new BlackjackGameManager(player);
        int gamesPlayed = 0;

        do {
            if (gamesPlayed % 5 == 0)
                gameManager.newDeck();
            playNewBlackJackGame(player, gameManager);
            System.out.print("Play again? (Y/N): ");
            String reply = scanner.nextLine();
            playAgain = reply.equalsIgnoreCase("Y");
            System.out.println("Casino funds: " + gameManager.getCasinoFunds());
            gamesPlayed++;
        } while (playAgain);

    }

    public static void playNewBlackJackGame(Player player, BlackjackGameManager gameManager) {

        Scanner scanner = new Scanner(System.in);
        double bet = Double.MAX_VALUE;

        System.out.print("Place your bet (current balance: " + player.getBalance() + "): ");
        while (bet >= player.getBalance()) {
            bet = scanner.nextDouble();

            if (bet >= player.getBalance())
                System.out.print("Please enter a bet less than " + player.getBalance() + ": ");
        }

        gameManager.play(bet);
        int userReply = 0;

        String message = "\n1 - Hit\n2 - Stand\nBalance = " + player.getBalance();

        if (player.getPoints() != 21) {
            System.out.println("\nPlease choose an option: " + message);
            userReply = scanner.nextInt();
        } else {
            System.out.println("Blackjack! (x2.5)");
            System.out.println("Balance = " + player.getBalance());

        }

        while (player.getPoints() < 21) {

            if (userReply == 1)
                gameManager.hit();
            else if (userReply == 2) {
                gameManager.stand();
                System.out.println("Balance = " + player.getBalance());
                break;
            }

            if (player.getPoints() >= 21) {
                System.out.println("Balance = " + player.getBalance());
                break;
            }

            System.out.println("Please choose an option: " + message);
            userReply = scanner.nextInt();
        }
    }
}
