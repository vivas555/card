package com.frivard.card.businessLogic;

import com.frivard.card.businessLogic.model.GameId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class GameIdTest {

    @Test
    void givenNullValue_whenCreatingInstance_thenThrowsException() {

        // Given
        String value = null;

        // Then
        assertThrows(IllegalArgumentException.class, () -> new GameId(value));

    }

    @Test
    void givenEmptyValue_whenCreatingInstance_thenThrowsException() {

        // Given
        String value = "";

        // Then
        assertThrows(IllegalArgumentException.class, () -> new GameId(value));

    }
}