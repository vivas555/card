package com.frivard.card.api;

import com.frivard.card.businessLogic.GameId;
import com.frivard.card.businessLogic.PlayerId;
import com.frivard.card.businessLogic.PlayerName;
import com.frivard.card.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card-game/v0/games")
public class GameController {

    private GameService gameService;

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
    public void deleteGameById(@PathVariable("game-id") String id) {
        gameService.deleteGameById(new GameId(id));
    }

    @PutMapping("/{game-id}/add-deck")
    public void addDeck(@PathVariable("game-id") String id) {
        gameService.addDeck(new GameId(id));
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
    public void listCards(@PathVariable("game-id") String id, @PathVariable("player-id") String playerId) {
        gameService.deal(new GameId(id), new PlayerId(playerId));
    }

}
