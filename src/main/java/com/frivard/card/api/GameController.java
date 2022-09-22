package com.frivard.card.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("card-game/v0/game")
public class GameController {

    @PostMapping
    public String createGame() {
        return "Yo ça marche";
    }

    @PostMapping("/shuffle")
    public String shuffleGame() {
        return "Yo ça aussi";
    }
}
