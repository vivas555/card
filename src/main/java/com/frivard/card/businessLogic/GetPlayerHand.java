package com.frivard.card.businessLogic;

import com.frivard.card.dataAccessLayer.GamePersistence;
import com.frivard.card.dataAccessLayer.PlayerPersistence;

import java.util.*;

public class GetPlayerHand {
    private final GamePersistence gamePersistence;
    private final PlayerPersistence playerPersistence;

    public GetPlayerHand(GamePersistence gamePersistence, PlayerPersistence playerPersistence) {
        this.gamePersistence = gamePersistence;
        this.playerPersistence = playerPersistence;
    }

    public List<PlayerHand> getHandWithHandStrength(GameId gameId) {
        Game game = getGame(gameId);

        if (game == null) return Collections.emptyList();

        List<PlayerId> playerIds = game.listPlayers();

        List<PlayerHand> playerHands = buildPlayerHands(playerIds, game);

        sortByHandStrengthDescending(playerHands);

        return playerHands;
    }

    private void sortByHandStrengthDescending(List<PlayerHand> playerHands) {
        playerHands.sort(Comparator.comparingInt(PlayerHand::getHandStrength));
        Collections.reverse(playerHands);
    }

    private List<PlayerHand> buildPlayerHands(List<PlayerId> playerIds, Game game) {
        List<PlayerHand> playerHands = new ArrayList<>();

        for (PlayerId playerId : playerIds) {
            playerHands.add(buildPlayerHand(playerId, game));
        }

        return playerHands;
    }

    private PlayerHand buildPlayerHand(PlayerId playerId, Game game) {
        Player player = getPlayer(playerId);
        Hand hand = getHand(playerId, game);

        return new PlayerHand(player, hand);
    }

    private Hand getHand(PlayerId playerId, Game game) {
        return game.getPlayerHand(playerId);
    }

    private Player getPlayer(PlayerId playerId) {
        return playerPersistence.getPlayerById(playerId).get();
    }

    private Game getGame(GameId gameId) {
        Optional<Game> gameOptional = gamePersistence.getGameById(gameId);

        return gameOptional.orElse(null);

    }
}
