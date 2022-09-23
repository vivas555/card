package com.frivard.card.api;

import com.frivard.card.businessLogic.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.frivard.card.businessLogic.CardColor.*;

public class CardAdapter {
    public static List<CardsCountDto> toCardsCountDtoList(List<Card> cards) {
        List<CardsCountDto> dtoList = new ArrayList<>();
        int numberOfHeart = 0;
        int numberOfSpades = 0;
        int numberOfClubs = 0;
        int numberOfDiamonds = 0;

        for (Card card : cards) {
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

    public static List<CardDto> toCardsDtosSortedBySuitAndValue(List<Card> cards) {
        List<CardDto> dtos = toCardsDtos(cards);

        sortByValues(dtos);
        Collections.reverse(dtos);
        sortBySuit(dtos);

        return dtos;
    }

    private static void sortByValues(List<CardDto> dtos) {
        dtos.sort(Comparator.comparing(dto -> dto.getStrength().getValue()));
    }

    private static void sortBySuit(List<CardDto> dtos) {
        dtos.sort(Comparator.comparing(dto -> dto.getColor().name()));
    }

    private static List<CardDto> toCardsDtos(List<Card> cards) {
        List<CardDto> dtos = new ArrayList<>();

        for (Card card : cards) {
            dtos.add(new CardDto(card.getColor(), card.getStrength()));
        }

        return dtos;
    }
}
