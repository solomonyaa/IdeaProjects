package dev.lpa.game;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class PirateGame extends Game<Pirate> {

    static List<List<Town>> levelMap;
    static List<Town> level1;
    static List<Town> level2;
    static List<Town> level3;

    public PirateGame(String gameName) {

        super(gameName);

        level1 = new ArrayList<>(List.of(
                new Town("Monsoon Cay", new Enemy("Jaded Gravedigger", 60, 20)),
                new Town("Island of Crocodiles", new Enemy("Mugger Crocodile", 100, 30)),
                new Town("Demon Lagoon", new Enemy("Undead Demon", 140, 40))));

        level2 = new ArrayList<>(List.of(
                new Town("Booty Cave", new Enemy("Guardian of Treasure", 150, 45)),
                new Town("Bay of Crosses", new Enemy("Unholy Executioner", 200, 50)),
                new Town("Lagoon of Marauders", new Enemy("Marooned Captain", 250, 55))));

        level3 = new ArrayList<>(List.of(
                new Town("Cave of Killer Whales", new Enemy("Ruthless Killer Whale", 225, 60)),
                new Town("Dead Men Sanctuary", new Enemy("Grim Reaper", 300, 65)),
                new Town("Sea Monster Port", new Enemy("Kraken", 400, 70))));

        levelMap = new ArrayList<>();

        levelMap.add(level1);
        levelMap.add(level2);
        levelMap.add(level3);
    }

    static List<Town> getGameStage(int level) {
        return levelMap.get(level);
    }

    @Override
    public Pirate createNewPlayer(String name) {
        return new Pirate(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {

        var map = new LinkedHashMap<>(Map.of(
                'A',
                new GameAction('A', "Attack", this::attack),
                'V',
                new GameAction('V', "Visit Next Town", this::visitTown),
                'T',
                new GameAction('T', "Get Visited Towns", this::getTownsVisited),
                'P',
                new GameAction('P', "Drink Healing Potion", this::drinkPotion)

        ));
        map.putAll(getStandardActions());
        return map;
    }

    private boolean attack(int playerIndex) {
        return getPlayer(playerIndex).attack();
    }

    private boolean visitTown(int playerIndex) {
        return getPlayer(playerIndex).visitTown();
    }

    private boolean getTownsVisited(int playerIndex) {
        return getPlayer(playerIndex).getTownsVisited();
    }

    private boolean drinkPotion(int playerIndex) {
        return getPlayer(playerIndex).drinkPotion();
    }
}
