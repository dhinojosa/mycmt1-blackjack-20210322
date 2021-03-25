package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

public class GameBettingTest {
//ZOMBIES

    @Test
    void testNewGamePlayerBalanceIsZero() {
        Game game = new Game();
        assertThat(game.playerBalance()).isZero();
    }

    @Test
    void testPlayerWith100HasBalanceOf100() {
        Game game = new Game();
        game.playerDeposits(100);
        assertThat(game.playerBalance()).isEqualTo(100);
    }

    @Test
    void testPlayerShouldDepositMultipleTimes() {
        Game game = new Game();
        game.playerDeposits(100);
        game.playerDeposits(200);
        assertThat(game.playerBalance()).isEqualTo(100 + 200);
    }

    @Test
    void testPlayerWith300AndBets100ShouldHaveABalanceOf200() {
        Game game = new Game();
        game.playerDeposits(300);
        game.playerBets(100);
        assertThat(game.playerBalance()).isEqualTo(200);
    }

    @Test
    void testPlayerWith100Bets50AndWinsThenBalanceIs150() {
        Game game = new Game();
        game.playerDeposits(100);
        game.playerBets(50);
        game.playerWins(); //Make sure the names line with your sprouts.
        int balance = game.playerBalance();
        assertThat(balance).isEqualTo(100 - 50 + 100);
    }

    @Test
    void testPlayerWith120Bets120AndWinsThenBalanceIs240() {
        Game game = new Game();
        game.playerDeposits(120);
        game.playerBets(120);
        game.playerWins(); //Make sure the names line with your sprouts.
        int balance = game.playerBalance();
        assertThat(balance).isEqualTo(120 - 120 + 240);
    }

    @Test
    void testPlayerWith150Bets50AndThenBetsAnother50WinsThenBalanceIs250() {
        Game game = new Game();
        game.playerDeposits(150);
        game.playerBets(50);
        game.playerBets(50);
        game.playerWins(); //Make sure the names line with your sprouts.
        int balance = game.playerBalance();
        assertThat(balance).isEqualTo(150 - 50 - 50 + 200);
    }

    @Test
    void testPlayerWith150Bets50ThenWinsThenWinsAgain() {
        Game game = new Game();
        game.playerDeposits(150);
        game.playerBets(50);
        game.playerWins();
        game.playerWins();
        int balance = game.playerBalance();
        assertThat(balance).isEqualTo(150 - 50 + 100);
    }

    @Test
    void testPlayerWith50Bets25AndLosesThenBalanceIs25() {
        Game game = new Game();
        game.playerDeposits(50);
        game.playerBets(25);
        game.playerLoses();
        int balance = game.playerBalance();
        assertThat(balance).isEqualTo(50 - 25);
    }

    @Test
    void testPlayerWith50Bets25AndLosesTwiceThenBalanceIs25() {
        Game game = new Game();
        game.playerDeposits(50);
        game.playerBets(25);
        game.playerLoses();
        game.playerLoses();
        int balance = game.playerBalance();
        assertThat(balance).isEqualTo(50 - 25);
    }

    @Test
    void testPlayerWith75Bets50AndPushesThenTheBalanceIs75() {
        Game game = new Game();
        game.playerDeposits(75);
        game.playerBets(50);
        game.playerPushes();
        int balance = game.playerBalance();
        assertThat(balance).isEqualTo(75 - 50 + 50);
    }

    //Green Bar
    @Test
    void testPlayerWith100Bets50AndWinsThenLosesThenTheBalanceIs150() {
        Game game = new Game();
        game.playerDeposits(100);
        game.playerBets(50);
        game.playerWins();
        //player didn't bet
        game.playerLoses();
        int balance = game.playerBalance();
        assertThat(balance).isEqualTo(100 - 50 + 100);
    }
}
