package com.frivard.card.dataAccessLayer;

import com.frivard.card.businessLogic.model.Player;
import com.frivard.card.businessLogic.model.PlayerId;
import com.frivard.card.businessLogic.model.PlayerName;

import java.util.Optional;

public interface PlayerPersistence {
    PlayerId createPlayer(PlayerName playerName);

    //TODO find clean way to guarantee record always exists
    Optional<Player> getPlayerById(PlayerId playerId);
}
