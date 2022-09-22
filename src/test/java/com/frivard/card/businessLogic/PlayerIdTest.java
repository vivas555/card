package com.frivard.card.businessLogic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerIdTest {

    @Test
    void givenNullValue_whenCreatingInstance_thenThrowsException() {

        // Given
        String value = null;

        // Then
        assertThrows(IllegalArgumentException.class, () -> new PlayerId(value));

    }

    @Test
    void givenEmptyValue_whenCreatingInstance_thenThrowsException() {

        // Given
        String value = "";

        // Then
        assertThrows(IllegalArgumentException.class, () -> new PlayerId(value));

    }
}