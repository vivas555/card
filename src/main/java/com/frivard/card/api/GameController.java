package com.frivard.card.api;

import com.frivard.card.businessLogic.GameId;
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

    @DeleteMapping("/{id}")
    public void deleteGameById(@PathVariable("id") String id) {
        gameService.deleteGameById(new GameId(id));
    }

    @PutMapping("/{id}/add-deck")
    public void addDeck(@PathVariable("id") String id) {
        gameService.addDeck(new GameId(id));
    }

    @PutMapping("/{id}/add-player/{player-name}")
    public void addPlayer(@PathVariable("id") String id, @PathVariable("player-name") String playerName) {
        gameService.addPlayer(new GameId(id), new PlayerName(playerName));
    }

   /* @PutMapping("/{game-id}/player/{player-id}/remove")
    public void removePlayer(@PathVariable("game-id") String id) {
        gameService.addDeck(new GameId(id));
    }*/

}
