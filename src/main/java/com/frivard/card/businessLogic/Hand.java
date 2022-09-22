package com.frivard.card.businessLogic;

import java.util.LinkedList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new LinkedList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}
