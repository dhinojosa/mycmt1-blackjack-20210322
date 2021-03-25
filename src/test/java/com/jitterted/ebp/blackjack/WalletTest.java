package com.jitterted.ebp.blackjack;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WalletTest {
    //Zero
    //One
    //Many
    //Boundary
    //Interface Definition
    //Exception


    @Test
    void testWalletCreationShouldStartWithZero() {
        Wallet wallet = new Wallet();
        boolean isEmpty = wallet.isEmpty();
        assertThat(isEmpty).isTrue();
    }

    @Test
    void testAddMoney() {
        Wallet wallet = new Wallet();
        wallet.addMoney(10);
        assertThat(wallet.isEmpty()).isFalse();
    }

    @Test
    void testBalanceAfterAdding30() {
        Wallet wallet = new Wallet();
        wallet.addMoney(30);
        int balance = wallet.getBalance();
        assertThat(balance).isEqualTo(30);
    }

    @Test
    void testBalanceAfterCreatingWalletShouldBeZero() {
        Wallet wallet = new Wallet();
        assertThat(wallet.getBalance()).isZero();
    }

    //Green Bar
    @Test
    void testBalanceAfterAdding30Then90() {
        Wallet wallet = new Wallet();
        wallet.addMoney(30);
        wallet.addMoney(90);
        int balance = wallet.getBalance();
        assertThat(balance).isEqualTo(30 + 90);
    }

    //Green Bar
    @Test
    void testAdding30Then90ShouldNotBeEmpty() {
        Wallet wallet = new Wallet();
        wallet.addMoney(30);
        wallet.addMoney(90);
        assertThat(wallet.isEmpty()).isFalse();
    }

    @Test
    void testThatWeCannotAddNegativeFunds() {
        Wallet wallet = new Wallet();
        assertThatThrownBy(() -> wallet.addMoney(-3))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Money should be positive");
    }
}
