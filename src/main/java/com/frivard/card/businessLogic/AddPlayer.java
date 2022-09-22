package com.frivard.card.businessLogic;

import com.frivard.card.dataAccessLayer.GamePersistence;
import com.frivard.card.dataAccessLayer.PlayerPersistence;

import java.util.Optional;

public class AddPlayer {
    private final GamePersistence gamePersistence;
    private final PlayerPersistence playerPersistence;

    public AddPlayer(GamePersistence gamePersistence, PlayerPersistence playerPersistence) {
        this.gamePersistence = gamePersistence;
        this.playerPersistence = playerPersistence;
    }

    public void add(GameId gameId, PlayerName playerName) {
        Player player = createPlayer(playerName);

        Game game = addPlayerToGame(gameId, player);
        if (game == null)
            return;

        saveGame(game);
    }

    private Player createPlayer(PlayerName playerName) {
        PlayerId playerId = playerPersistence.createPlayer(playerName);
        return playerPersistence.getPlayerById(playerId).get();
    }

    private Game addPlayerToGame(GameId gameId, Player player) {
        Game game = getGame(gameId);

        if (game == null)
            return null;

        game.addPlayer(player);

        return game;
    }

    private void saveGame(Game game) {
        gamePersistence.updateGame(game);
    }

    private Game getGame(GameId gameId) {
        Optional<Game> gameOptional = gamePersistence.getGameById(gameId);

        return gameOptional.orElse(null);

    }
}
