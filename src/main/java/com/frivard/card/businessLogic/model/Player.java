package com.frivard.card.businessLogic.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id.equals(player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
