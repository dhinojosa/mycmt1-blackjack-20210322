package com.jitterted.ebp.blackjack;

import java.util.Optional;

public enum Suit {
    SPADES("♠"), DIAMONDS("♦"), HEARTS("♥"), CLUBS("♣");

    private String value;

    Suit(String value) {
        this.value = value;
    }

    public String displayValue() {
        return value;
    }

    boolean isRed() {
        return "♥♦".contains(value);
    }
}
