package com.frivard.card.businessLogic;

import com.frivard.card.businessLogic.model.Card;
import com.frivard.card.businessLogic.model.CardColor;
import com.frivard.card.businessLogic.model.CardStrength;
import com.frivard.card.businessLogic.model.Hand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandTest {

    @Test
    void givenAnyCard_whenAddingCard_thenAddsCardToHand() {
        // Given
        Hand systemUnderTest = new Hand();
        Card anyCard = new Card(CardColor.CLUBS, CardStrength.FOUR);

        //When
        systemUnderTest.addCard(anyCard);

        //Then
        assertEquals(anyCard, systemUnderTest.getAllCards().get(0));
        assertEquals(1, systemUnderTest.getAllCards().size());
    }

    @Test
    void givenAnyHandWithCard_whenGettingTotalStrength_thenReturnsTotalStrength() {
        // Given
        Hand systemUnderTest = new Hand();
        Card anyCard = new Card(CardColor.CLUBS, CardStrength.FOUR);
        systemUnderTest.addCard(anyCard);

        //When
        int result = systemUnderTest.getStrength();

        //Then
        assertEquals(4, result);
    }

}