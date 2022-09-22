package com.frivard.card.businessLogic;

import com.frivard.card.dataAccessLayer.GamePersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class GetHandTest {

    private GamePersistence gamePersistence;

    @BeforeEach
    public void setUp() {
        gamePersistence = Mockito.mock(GamePersistence.class);
    }

    @Test
    void givenInvalidGameId_whenListingPlayerHand_thenReturnNull() {

        // Given
        GameId gameId = new GameId(UUID.randomUUID().toString());
        when(gamePersistence.getGameById(gameId)).thenReturn(Optional.empty());
        GetHand systemUnderTest = new GetHand(gamePersistence);
        PlayerId playerId = new PlayerId(UUID.randomUUID().toString());

        // When
        Hand playerHand = systemUnderTest.getHandOfPlayer(gameId, playerId);

        // Then
        assertNull(playerHand);
    }

    @Test
    void givenInvalidPlayerId_whenListingPlayerHand_thenReturnNull() {

        // Given
        GameId gameId = new GameId(UUID.randomUUID().toString());
        Game anyGame = new Game(gameId);
        when(gamePersistence.getGameById(gameId)).thenReturn(Optional.of(anyGame));
        GetHand systemUnderTest = new GetHand(gamePersistence);
        PlayerId playerId = new PlayerId(UUID.randomUUID().toString());

        // When
        Hand playerHand = systemUnderTest.getHandOfPlayer(gameId, playerId);

        // Then
        assertNull(playerHand);
    }
}