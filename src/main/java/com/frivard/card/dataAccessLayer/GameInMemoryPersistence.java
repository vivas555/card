package com.frivard.card.dataAccessLayer;

import com.frivard.card.businessLogic.Game;
import com.frivard.card.businessLogic.GameId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class GameInMemoryPersistence implements GamePersistence {

    private static List<Game> games;

    public GameInMemoryPersistence() {
        games = new ArrayList<>();
    }

    @Override
    public GameId createGame() {
        GameId gameId = new GameId(UUID.randomUUID().toString());
        games.add(new Game(gameId));

        return gameId;
    }
}
