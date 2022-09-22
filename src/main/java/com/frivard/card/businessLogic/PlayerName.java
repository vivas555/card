package com.frivard.card.businessLogic;

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
}
