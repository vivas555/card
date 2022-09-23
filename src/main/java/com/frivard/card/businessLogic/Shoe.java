package com.frivard.card.businessLogic;

import org.javatuples.Pair;

import java.util.*;

public class Shoe {
    private List<Card> cards;

    public Shoe() {
        cards = new LinkedList<>();
    }

    public void addDeck() {
        for (CardColor color : CardColor.values()) {
            for (CardStrength strength : CardStrength.values()) {
                cards.add(new Card(color, strength));
            }
        }
    }

    public Optional<Card> draw() {
        if (cards.isEmpty())
            return Optional.empty();

        return Optional.ofNullable(cards.remove(0));
    }

    public List<Card> getAllCard() {
        return cards;
    }

    public void shuffle() {
        List<Pair<Double, Card>> newOrder = getNewOrder();

        List<Card> newCardsList = new ArrayList<>();

        for (Pair<Double, Card> pair : newOrder) {
            newCardsList.add(pair.getValue1());
        }

        cards = newCardsList;
    }

    private List<Pair<Double, Card>> getNewOrder() {
        List<Pair<Double, Card>> newOrder = new ArrayList<>();

        for (Card card : cards) {
            double random = Math.random();
            boolean randomIsPair = random % 2 == 0;

            if (randomIsPair)
                newOrder.add(new Pair<>(card.hashCode() + random, card));
            else
                newOrder.add(new Pair<>(card.hashCode() - random, card));

        }

        newOrder.sort(Comparator.comparingDouble(Pair::getValue0));
        return newOrder;
    }
}
