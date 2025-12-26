package dev.lpa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Please enter your name: ");
        Player player1 = new Player(new Scanner(System.in).nextLine());
        System.out.println("Enjoy the Yahtzee Game, " + player1.getName());
        YahtzeeGame game1 = new YahtzeeGame(player1);
        game1.playGame();
        
    }
}
