package com.frivard.card.businessLogic;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GameTableTest {

    @Test
    void givenAnyPlayerId_whenAddingPlayer_thenEmptyHandIsCreated() {

        // Given
        GameTable systemUnderTest = new GameTable();
        PlayerId playerId = new PlayerId(UUID.randomUUID().toString());

        // When
        systemUnderTest.addPlayer(playerId);

        // Then
        assertNotNull(systemUnderTest.getPlayerHand(playerId));
    }

    @Test
    void givenInvalidPlayerId_whenListingPlayerHand_thenReturnNull() {

        // Given
        GameTable systemUnderTest = new GameTable();
        PlayerId playerId = new PlayerId(UUID.randomUUID().toString());

        // When
        Hand playerHand = systemUnderTest.getPlayerHand(playerId);

        // Then
        assertNull(playerHand);
    }

    @Test
    void givenPlayerWithAnyHand_whenListingPlayerHand_thenReturnHand() {

        // Given
        GameTable systemUnderTest = new GameTable();

        PlayerId playerId = new PlayerId(UUID.randomUUID().toString());
        systemUnderTest.addPlayer(playerId);

        Card anyCard = new Card(CardColor.CLUBS, CardStrength.FOUR);
        systemUnderTest.addCardToPlayerHand(playerId, anyCard);

        // When
        Hand playerHand = systemUnderTest.getPlayerHand(playerId);

        // Then
        assertEquals(anyCard, playerHand.getAllCards().get(0));
        assertEquals(1, playerHand.getAllCards().size());
    }

}