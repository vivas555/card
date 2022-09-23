package com.frivard.card.api;

import com.frivard.card.businessLogic.Card;

import java.util.ArrayList;
import java.util.List;

import static com.frivard.card.businessLogic.CardColor.*;

public class CardAdapter {
    public static List<CardsCountDto> toCardsCountDtoList(List<Card> undealtCards) {
        List<CardsCountDto> dtoList = new ArrayList<>();
        int numberOfHeart = 0;
        int numberOfSpades = 0;
        int numberOfClubs = 0;
        int numberOfDiamonds = 0;

        for (Card card : undealtCards) {
            if (HEARTS.equals(card.getColor()))
                numberOfHeart++;
            if (SPADES.equals(card.getColor()))
                numberOfSpades++;
            if (CLUBS.equals(card.getColor()))
                numberOfClubs++;
            if (DIAMONDS.equals(card.getColor()))
                numberOfDiamonds++;
        }

        dtoList.add(new CardsCountDto(numberOfHeart, HEARTS));
        dtoList.add(new CardsCountDto(numberOfSpades, SPADES));
        dtoList.add(new CardsCountDto(numberOfClubs, CLUBS));
        dtoList.add(new CardsCountDto(numberOfDiamonds, DIAMONDS));
        return dtoList;
    }
}
