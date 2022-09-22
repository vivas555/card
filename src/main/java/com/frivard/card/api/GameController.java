package com.frivard.card.api;

import com.frivard.card.businessLogic.GameId;
import com.frivard.card.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card-game/v0/game")
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

}
