package com.frivard.card.businessLogic.model;

import java.util.Objects;

public class PlayerName {
    private String value;

    public PlayerName(String playerName) {
        value = playerName;
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
        PlayerName name = (PlayerName) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
