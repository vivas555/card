package com.frivard.card.businessLogic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {

    @Test
    void givenNullId_whenCreatingInstance_thenThrowException() {
        // Given
        GameId id = null;

        // Then
        assertThrows(IllegalArgumentException.class, () -> new Game(id));
    }

}