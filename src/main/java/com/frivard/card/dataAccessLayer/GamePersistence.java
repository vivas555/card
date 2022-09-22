package com.frivard.card.dataAccessLayer;

import com.frivard.card.businessLogic.Game;
import com.frivard.card.businessLogic.GameId;

import java.util.Optional;

public interface GamePersistence {
    GameId createGame();

    Optional<Game> getGameById(GameId id);
}
