package com.frivard.card.dataAccessLayer;

import com.frivard.card.businessLogic.Game;
import com.frivard.card.businessLogic.GameId;

public interface GamePersistence {
    GameId createGame();

    Game getGameById(GameId id);
}
