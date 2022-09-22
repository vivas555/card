package com.frivard.card.businessLogic;

import com.frivard.card.dataAccessLayer.GamePersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.*;

class DeleteGameTest {

    private GamePersistence persistence;

    @BeforeEach
    public void setUp() {
        persistence = mock(GamePersistence.class);
    }

    @Test
    void givenAnyGameId_whenCreatingNew_thenPersistenceIsCalled() {

        // Given
        GameId anyGameId = new GameId(UUID.randomUUID().toString());
        DeleteGame systemUnderTest = new DeleteGame(persistence);

        // When
        systemUnderTest.byId(anyGameId);

        // Then
        verify(persistence, times(1)).deleteGameById(anyGameId);
    }

}