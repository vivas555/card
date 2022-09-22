package com.frivard.card.businessLogic;

public class Player {

    private PlayerId id;
    private PlayerName name;

    public Player(PlayerId id, PlayerName name) {
        this.id = id;
        this.name = name;

        validateInstance();
    }

    private void validateInstance() {
        validateIdMustNotBeNull();
        validateNameMustNotBeNull();
    }

    private void validateIdMustNotBeNull() {
        if (id == null)
            throw new IllegalArgumentException("Cannot construct " + getClass().getName() + "with null id");
    }

    private void validateNameMustNotBeNull() {
        if (name == null)
            throw new IllegalArgumentException("Cannot construct " + getClass().getName() + "with null name");
    }

    public PlayerId getId() {
        return id;
    }

    public PlayerName getName() {
        return name;
    }
}
