package com.frivard.card.api;

import com.frivard.card.businessLogic.model.PlayerHand;

import java.util.ArrayList;
import java.util.List;

public class PlayerHandAdapter {
    public static List<PlayerHandDto> toDtos(List<PlayerHand> playerHands) {
        List<PlayerHandDto> dtos = new ArrayList<>();

        for (PlayerHand playerHand : playerHands) {
            dtos.add((toDto(playerHand)));
        }
        return dtos;
    }

    private static PlayerHandDto toDto(PlayerHand playerHand) {
        return new PlayerHandDto(new PlayerDto(playerHand.getPlayer().getId().getValue(), playerHand.getPlayer().getName().getValue()), playerHand.getHandStrength());
    }
}
