package com.frivard.card.businessLogic;

public class Game {
    private GameId id;

    public Game(GameId id) {
        this.id = id;
        validateInstance();
    }

    private void validateInstance() {
        validateIdIsNotNull();
    }

    private void validateIdIsNotNull() {
        if (id == null)
            throw new IllegalArgumentException("Cannot construct " + getClass().getName() + "with null id");
    }

    public void addDeck() {

    }

    public GameId getId() {
        return id;
    }
}
