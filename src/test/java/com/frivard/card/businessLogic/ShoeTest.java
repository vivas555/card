package com.frivard.card.businessLogic;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ShoeTest {

    @Test
    void givenEmptyShoe_whenDrawingCard_thenReturnEmptyOptional() {
        // Given
        Shoe systemUnderTest = new Shoe();

        // When
        Optional<Card> result = systemUnderTest.draw();

        // Then
        assertFalse(result.isPresent());
    }

    @Test
    void givenNotEmptyShoe_whenDrawingCard_thenReturnPresentOptional() {
        // Given
        Shoe systemUnderTest = new Shoe();
        systemUnderTest.addDeck();

        // When
        Optional<Card> result = systemUnderTest.draw();

        // Then
        assertTrue(result.isPresent());
    }


    @Test
    void givenEmptyShoe_whenGettingAllCard_thenReturnEmptyList() {
        // Given
        Shoe systemUnderTest = new Shoe();

        // When
        List<Card> result = systemUnderTest.getAllCard();

        // Then
        assertTrue(result.isEmpty());
    }

    @Test
    void givenNotEmptyShoe_whenGettingAllCard_thenReturnAllCards() {
        // Given
        Shoe systemUnderTest = new Shoe();
        systemUnderTest.addDeck();

        // When
        List<Card> result = systemUnderTest.getAllCard();

        // Then
        assertEquals(52, result.size());
    }
}