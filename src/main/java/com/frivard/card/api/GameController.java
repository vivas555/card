package com.frivard.card.api;

import com.frivard.card.businessLogic.*;
import com.frivard.card.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("card-game/v0/games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public String createGame() {
        GameId id = gameService.createGame();

        return id.getValue();
    }

    @DeleteMapping("/{game-id}")
    public void deleteGameById(@PathVariable("game-id") String gameId) {
        gameService.deleteGameById(new GameId(gameId));
    }

    @PutMapping("/{game-id}/add-deck")
    public void addDeck(@PathVariable("game-id") String gameId) {
        gameService.addDeck(new GameId(gameId));
    }

    @PutMapping("/{game-id}/add-player/{player-name}")
    public String addPlayer(@PathVariable("game-id") String id, @PathVariable("player-name") String playerName) {
        PlayerId playerId = gameService.addPlayer(new GameId(id), new PlayerName(playerName));

        return playerId.getValue();
    }

    @PutMapping("/{game-id}/players/{player-id}/remove")
    public void removePlayer(@PathVariable("game-id") String id, @PathVariable("player-id") String playerId) {
        gameService.removePlayer(new GameId(id), new PlayerId(playerId));
    }

    @PutMapping("/{game-id}/players/{player-id}/deal")
    public void deal(@PathVariable("game-id") String id, @PathVariable("player-id") String playerId) {
        gameService.deal(new GameId(id), new PlayerId(playerId));
    }

    @GetMapping("/{game-id}/players/{player-id}/list-cards")
    public HandDto listCards(@PathVariable("game-id") String id, @PathVariable("player-id") String playerId) {
        Hand hand = gameService.getHand(new GameId(id), new PlayerId(playerId));

        return HandAdapter.toDto(hand);
    }

    @GetMapping("/{game-id}/players")
    public List<PlayerHandDto> listPlayersWithHandStrength(@PathVariable("game-id") String gameId) {
        List<PlayerHand> playerHands = gameService.listPlayersWithHandStrength(new GameId(gameId));

        return PlayerHandAdapter.toDtos(playerHands);
    }

    @GetMapping("/{game-id}/undealt-cards")
    public List<CardsCountDto> getUndealtCards(@PathVariable("game-id") String gameId) {
        List<Card> undealtCards = gameService.listCardsStillInShoe(new GameId(gameId));


        return CardAdapter.toCardsCountDtoList(undealtCards);
    }
}
