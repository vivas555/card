package com.frivard.card.businessLogic;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}