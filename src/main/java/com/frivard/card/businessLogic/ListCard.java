package com.frivard.card.businessLogic;

import com.frivard.card.dataAccessLayer.GamePersistence;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ListCard {
    private final GamePersistence persistence;

    public ListCard(GamePersistence persistence) {
        this.persistence = persistence;
    }

    public List<Card> listCardsStillInShoe(GameId gameId) {
        Game game = getGame(gameId);

        if (game == null) return Collections.emptyList();

        return game.listCardsStillInShoe();

    }

    private Game getGame(GameId gameId) {
        Optional<Game> gameOptional = persistence.getGameById(gameId);

        return gameOptional.orElse(null);

    }
}
