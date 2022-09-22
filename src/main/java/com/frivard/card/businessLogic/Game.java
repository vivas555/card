package com.frivard.card.businessLogic;

public class Game {
    private GameId id;
    private GameTable table;

    private Shoe shoe;

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
        shoe.addDeck();
    }

    public GameId getId() {
        return id;
    }

    public void addPlayer(Player player) {
        table.addPlayer(player);
    }

    public void removePlayer(PlayerId playerId) {
        table.removePlayer(playerId);
    }
}
