package com.frivard.card.businessLogic;

public class PlayerHand {
    private Player player;
    private Hand hand;

    public PlayerHand(Player player, Hand hand) {
        this.player = player;
        this.hand = hand;
    }

    public Player getPlayer() {
        return player;
    }

    public Hand getHand() {
        return hand;
    }

    public int getHandStrength() {
        return hand.getStrength();
    }
}
