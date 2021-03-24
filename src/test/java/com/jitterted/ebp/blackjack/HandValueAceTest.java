package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

  @Test
  public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
    Game game = new Game();
    List<Card> cards = List.of(new Card(Suit.SPADES, "A"),
                               new Card(Suit.SPADES, "5"));

    Hand hand = new Hand(cards);
    assertThat(hand.handValueOf())
        .isEqualTo(11 + 5);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
    Game game = new Game();
    List<Card> cards = List.of(new Card(Suit.SPADES, "A"),
                               new Card(Suit.SPADES, "8"),
                               new Card(Suit.SPADES, "3"));

    Hand hand = new Hand(cards);
    assertThat(hand.handValueOf())
        .isEqualTo(1 + 8 + 3);
  }

}
