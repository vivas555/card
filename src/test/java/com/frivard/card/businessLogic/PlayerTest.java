package com.frivard.card.businessLogic;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {

    @Test
    void givenNullId_whenCreatingInstance_thenThrowException() {
        // Given
        PlayerId id = null;
        PlayerName name = new PlayerName("anyName");

        // Then
        assertThrows(IllegalArgumentException.class, () -> new Player(id, name));
    }

    @Test
    void givenNullName_whenCreatingInstance_thenThrowException() {
        // Given
        PlayerId id = new PlayerId(UUID.randomUUID().toString());
        PlayerName name = null;

        // Then
        assertThrows(IllegalArgumentException.class, () -> new Player(id, name));
    }
}