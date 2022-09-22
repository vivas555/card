package com.frivard.card.businessLogic;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void givenNullId_whenCreatingInstance_thenThrowException() {
        // Given
        GameId id = null;

        // Then
        assertThrows(IllegalArgumentException.class, () -> new Game(id));
    }

    @Test
    void givenAnyPlayerId_whenAddingPlayer_thenEmptyHandIsCreated() {

        // Given
        GameId gameId = new GameId(UUID.randomUUID().toString());
        Game systemUnderTest = new Game(gameId);
        PlayerId playerId = new PlayerId(UUID.randomUUID().toString());

        // When
        systemUnderTest.addPlayer(playerId);

        // Then
        assertNotNull(systemUnderTest.getPlayerHand(playerId));
    }

    @Test
    void givenInvalidPlayerId_whenListingPlayerHand_thenReturnNull() {

        // Given
        GameId gameId = new GameId(UUID.randomUUID().toString());
        Game systemUnderTest = new Game(gameId);
        PlayerId playerId = new PlayerId(UUID.randomUUID().toString());

        // When
        Hand playerHand = systemUnderTest.getPlayerHand(playerId);

        // Then
        assertNull(playerHand);
    }

    @Test
    void givenPlayerWithAnyHand_whenListingPlayerHand_thenReturnHand() {

        // Given
        GameId gameId = new GameId(UUID.randomUUID().toString());
        Game systemUnderTest = new Game(gameId);

        PlayerId playerId = new PlayerId(UUID.randomUUID().toString());
        systemUnderTest.addPlayer(playerId);

        systemUnderTest.addDeck();

        systemUnderTest.dealCardToPlayer(playerId);

        // When
        Hand playerHand = systemUnderTest.getPlayerHand(playerId);

        // Then
        assertEquals(1, playerHand.getAllCards().size());
    }

}