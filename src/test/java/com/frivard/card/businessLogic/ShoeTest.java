package com.frivard.card.businessLogic;

import com.frivard.card.businessLogic.model.Card;
import com.frivard.card.businessLogic.model.Shoe;
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

    @Test
    void givenAnyShoe_whenShufflingCards_thenReorganizeCards() {
        // Given
        Shoe systemUnderTest = new Shoe();
        systemUnderTest.addDeck();
        List<Card> before = systemUnderTest.getAllCard();

        // When
        systemUnderTest.shuffle();

        // Then
        List<Card> after = systemUnderTest.getAllCard();
        assertEquals(before.size(), after.size());
        assertBothListAreNotInTheSameOrder(before, after);

    }

    private void assertBothListAreNotInTheSameOrder(List<Card> before, List<Card> after) {
        boolean different = false;
        for (int i = 0; i < before.size(); i++) {
            if (!before.get(i).equals(after.get(i))) {
                different = true;
                break;
            }
        }
        assertTrue(different);
    }
}