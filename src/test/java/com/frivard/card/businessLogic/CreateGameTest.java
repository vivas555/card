package com.frivard.card.businessLogic;

import com.frivard.card.dataAccessLayer.GamePersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CreateGameTest {

    private GamePersistence persistence;

    @BeforeEach
    public void setUp() {
        persistence = mock(GamePersistence.class);
    }

    @Test
    void givenAnyGame_whenCreatingNew_thenPersistenceIsCalled() {
        // Given
        CreateGame systemUnderTest = new CreateGame(persistence);

        // When
        systemUnderTest.create();

        // Then
        verify(persistence, times(1)).createGame();
    }

}