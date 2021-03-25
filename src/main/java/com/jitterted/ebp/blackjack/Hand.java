package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {
    private List<Card> cardList = new ArrayList<Card>();

    public Hand() {
    }

    public Hand(List<Card> cardList) {
        this.cardList = cardList;
    }

    void dealCardFrom(Deck deck) {
        cardList.add(deck.draw());
    }

    //Goal: Maybe make this private
    private int handValueOf() {
        int handValue = cardList
            .stream()
            .mapToInt(Card::rankValue)
            .sum();

        // does the hand contain at least 1 Ace?
        boolean hasAce = cardList
            .stream()
            .anyMatch(card -> card.rankValue() == 1);

        // if the total hand value <= 11, then count the Ace as 11 by adding 10
        if (hasAce && handValue < 11) {
            handValue += 10;
        }

        return handValue;
    }

    void displayHandValueToSysOut() {
        System.out.println(" (" + handValueOf() + ")");
    }

    void displayAllCardsToSysOut() {
        System.out.println(cardList.stream()
                               .map(Card::display)
                               .collect(Collectors.joining(
                                   ansi().cursorUp(6).cursorRight(1).toString())));
    }

    Card getFirstCard() {
        return cardList.get(0);
    }

    boolean isBusted() {
        return handValueOf() > 21;
    }

    boolean beats(Hand otherHand) {
        return otherHand.handValueOf() < handValueOf();
    }

    boolean pushesWith(Hand otherHand) {
        return otherHand.handValueOf() == handValueOf();
    }

    boolean isNotBusted() {
        return handValueOf() <= 16;
    }

    public boolean hasValueOf(int i) {
        return handValueOf() == i;
    }
}
