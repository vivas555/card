package com.frivard.card.dataAccessLayer;

import com.frivard.card.businessLogic.model.Game;
import com.frivard.card.businessLogic.model.GameId;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameInMemoryPersistenceTest {

    @Test
    void givenAnyGame_whenCreatingGame_thenReturnGameId() {

        // Given
        GameInMemoryPersistence systemUnderTest = new GameInMemoryPersistence();

        // When
        GameId result = systemUnderTest.createGame();

        // Then
        assertNotNull(result);
    }

    @Test
    void givenAnyGame_whenCreatingGame_thenGameIsSaved() {

        // Given
        GameInMemoryPersistence systemUnderTest = new GameInMemoryPersistence();

        // When
        GameId result = systemUnderTest.createGame();

        // Then
        assertNotNull(systemUnderTest.getGameById(result));
    }

    @Test
    void givenEmptyPersistence_whenGettingGameById_thenReturnEmptyOptional() {

        // Given
        GameId anyGameId = new GameId(UUID.randomUUID().toString());
        GameInMemoryPersistence systemUnderTest = new GameInMemoryPersistence();

        // When
        Optional<Game> result = systemUnderTest.getGameById(anyGameId);

        // Then
        assertFalse(result.isPresent());
    }

    @Test
    void givenAnyGame_whenDeletingGame_thenDeleteGame() {

        // Given
        GameInMemoryPersistence systemUnderTest = new GameInMemoryPersistence();
        GameId gameId = systemUnderTest.createGame();

        // When
        systemUnderTest.deleteGameById(gameId);

        // Then
        Optional<Game> result = systemUnderTest.getGameById(gameId);
        assertFalse(result.isPresent());
    }

    @Test
    void givenNoGame_whenDeletingGame_thenDoNothing() {

        // Given
        GameInMemoryPersistence systemUnderTest = new GameInMemoryPersistence();
        GameId anyGameId = new GameId(UUID.randomUUID().toString());

        // When
        systemUnderTest.deleteGameById(anyGameId);

        // Then
    }

    //TODO test update quand game was avoir des propriétés
}