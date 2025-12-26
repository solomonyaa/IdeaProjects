package dev.lpa.game;

public sealed interface Player permits Pirate, Shooter {

    String name();
}
