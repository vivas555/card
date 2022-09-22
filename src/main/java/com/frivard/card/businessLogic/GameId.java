package com.frivard.card.businessLogic;

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

}
