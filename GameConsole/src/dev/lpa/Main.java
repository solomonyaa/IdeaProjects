package dev.lpa;

import dev.lpa.game.GameConsole;
import dev.lpa.game.PirateGame;

public class Main {

    public static void main(String[] args) {

/*        var console = new GameConsole<>(new ShooterGame("The Shootout Game",
                "machine gun"));

        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);*/

        PirateGame pirateGame = new PirateGame("The Pirate Game");
        var console = new GameConsole<>(pirateGame);
        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);
    }
}
