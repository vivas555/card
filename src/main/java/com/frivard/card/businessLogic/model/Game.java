package com.frivard.card.businessLogic.model;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Game {
    private GameId id;
    private GameTable table;

    private Shoe shoe;

    public Game(GameId id) {
        this.id = id;
        shoe = new Shoe();
        table = new GameTable();
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

    public void addPlayer(PlayerId playerId) {
        table.addPlayer(playerId);
    }

    public void removePlayer(PlayerId playerId) {
        table.removePlayer(playerId);
    }

    public void dealCardToPlayer(PlayerId playerId) {
        Optional<Card> card = shoe.draw();

        if (!card.isPresent())
            return;

        table.addCardToPlayerHand(playerId, card.get());
    }

    public List<PlayerId> listPlayers() {
        return table.getAllPlayer();
    }

    public Hand getPlayerHand(PlayerId playerId) {
        return table.getPlayerHand(playerId);
    }

    public List<Card> listCardsStillInShoe() {
        return shoe.getAllCard();
    }

    public void shuffleShoe() {
        shoe.shuffle();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
