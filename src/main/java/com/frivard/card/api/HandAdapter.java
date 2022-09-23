package com.frivard.card.api;

import com.frivard.card.businessLogic.model.Card;
import com.frivard.card.businessLogic.model.Hand;

import java.util.ArrayList;
import java.util.List;

public class HandAdapter {
    public static HandDto toDto(Hand hand) {

        if (hand == null)
            return null;

        List<CardDto> cardsDto = toCardDtos(hand.getAllCards());
        return new HandDto(cardsDto);
    }

    private static List<CardDto> toCardDtos(List<Card> allCards) {
        List<CardDto> cardDtos = new ArrayList<>();

        for (Card card : allCards) {
            CardDto dto = new CardDto(card.getColor(), card.getStrength());
            cardDtos.add(dto);
        }

        return cardDtos;
    }
}
