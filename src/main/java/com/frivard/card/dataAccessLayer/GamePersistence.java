package com.frivard.card.dataAccessLayer;

import com.frivard.card.businessLogic.model.Game;
import com.frivard.card.businessLogic.model.GameId;

import java.util.Optional;

public interface GamePersistence {
    GameId createGame();

    //TODO find clean way to guarantee record always exists
    Optional<Game> getGameById(GameId id);

    void deleteGameById(GameId gameId);

    void updateGame(Game game);
}
