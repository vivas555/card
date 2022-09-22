package com.frivard.card.businessLogic;

import java.util.Objects;

public class GameId {
    private final String value;

    public GameId(String value) {
        this.value = value;

        validateInstance();
    }

    private void validateInstance() {
        validateNotNullValue();
        validateNotEmptyValue();
    }

    private void validateNotNullValue() {
        if (value == null)
            throw new IllegalArgumentException("Cannot construct " + getClass().getName() + "with null value");
    }

    private void validateNotEmptyValue() {
        if (value.isEmpty())
            throw new IllegalArgumentException("Cannot construct " + getClass().getName() + "with empty value");
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameId gameId = (GameId) o;
        return value.equals(gameId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
