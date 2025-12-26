package dev.lpa.game;

import java.util.Scanner;

// Upper-Bounded Wildcard
public class GameConsole<T extends Game<? extends Player>> {

    private static final Scanner scanner = new Scanner(System.in);
    private final T game;

    public GameConsole(T game) {
        this.game = game;
    }

    public int addPlayer() {

        System.out.print("Enter your playing name: ");
        var name = scanner.nextLine();

        System.out.printf("Welcome to %s, %s!%n".formatted(game.getGameName(), name));
        return game.addPlayer(name);
    }

    public void playGame(int playerIndex) {

        boolean done = false;

        while (!done) {

            var gameActions = game.getGameActions(playerIndex);
            System.out.println("Select from one of the following actions: ");
            for (Character c : gameActions.keySet()) {
                String prompt = gameActions.get(c).prompt();
                System.out.println("\t" + prompt + " (" + c + ")");
            }
            System.out.print("Enter next action: ");

            char nextMove = ' ';
            try {
                nextMove = scanner.nextLine().toUpperCase().charAt(0);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("No character entered. Try again.");
            }

            GameAction gameAction = gameActions.get(nextMove);

            if (gameAction != null) {
                System.out.println("-".repeat(120));
                done = game.executeGameAction(playerIndex, gameAction);
                if (!done) {
                    System.out.println("-".repeat(120));
                }
            }
        }
    }
}
