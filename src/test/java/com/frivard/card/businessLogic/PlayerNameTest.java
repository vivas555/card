package com.frivard.card.businessLogic;

import com.frivard.card.businessLogic.model.PlayerName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerNameTest {

    @Test
    void givenNullValue_whenCreatingInstance_thenThrowsException() {

        // Given
        String value = null;

        // Then
        assertThrows(IllegalArgumentException.class, () -> new PlayerName(value));

    }

    @Test
    void givenEmptyValue_whenCreatingInstance_thenThrowsException() {

        // Given
        String value = "";

        // Then
        assertThrows(IllegalArgumentException.class, () -> new PlayerName(value));

    }
}