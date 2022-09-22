package com.frivard.card.businessLogic;

import com.frivard.card.dataAccessLayer.GamePersistence;
import com.frivard.card.dataAccessLayer.PlayerPersistence;

public class DealCard {
    private GamePersistence gamePersistence;
    private PlayerPersistence playerPersistence;

    public DealCard(GamePersistence gamePersistence, PlayerPersistence playerPersistence) {
        this.gamePersistence = gamePersistence;
        this.playerPersistence = playerPersistence;
    }

    public void dealToPlayer(GameId gameId, PlayerId playerId) {
        
    }
}
