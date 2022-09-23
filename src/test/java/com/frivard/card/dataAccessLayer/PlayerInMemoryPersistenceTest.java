package com.frivard.card.dataAccessLayer;

import com.frivard.card.businessLogic.model.Player;
import com.frivard.card.businessLogic.model.PlayerId;
import com.frivard.card.businessLogic.model.PlayerName;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PlayerInMemoryPersistenceTest {

    @Test
    void givenAnyPlayer_whenCreatingPlayer_thenReturnPlayerId() {

        // Given
        PlayerInMemoryPersistence systemUnderTest = new PlayerInMemoryPersistence();
        PlayerName name = new PlayerName("anyName");

        // When
        PlayerId result = systemUnderTest.createPlayer(name);

        // Then
        assertNotNull(result);
    }

    @Test
    void givenAnyPlayer_whenCreatingPlayer_thenPlayerIsSaved() {

        // Given
        PlayerInMemoryPersistence systemUnderTest = new PlayerInMemoryPersistence();
        PlayerName name = new PlayerName("anyName");

        // When
        PlayerId result = systemUnderTest.createPlayer(name);

        // Then
        assertNotNull(systemUnderTest.getPlayerById(result));
    }

    @Test
    void givenEmptyPersistence_whenGettingPlayerById_thenReturnEmptyOptional() {

        // Given
        PlayerId anyPlayerId = new PlayerId(UUID.randomUUID().toString());
        PlayerInMemoryPersistence systemUnderTest = new PlayerInMemoryPersistence();

        // When
        Optional<Player> result = systemUnderTest.getPlayerById(anyPlayerId);

        // Then
        assertFalse(result.isPresent());
    }

}