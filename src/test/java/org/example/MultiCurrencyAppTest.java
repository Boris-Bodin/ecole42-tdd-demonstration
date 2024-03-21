package org.example;

import org.example.bank.Bank;
import org.example.expression.Expression;
import org.example.money.Money;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MultiCurrencyAppTest {

    @Test
    public void testMultipication() {
        Money dollar = Money.dollar(5);
        assertEquals(Money.dollar(10), dollar.times(2));
        assertEquals(Money.dollar(15), dollar.times(3));
    }

    @Test
    public void testEquality() {
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(6), Money.dollar(8));
        assertNotEquals(Money.dollar(5), Money.euro(5));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("EUR", Money.euro(1).currency());
    }

    @Test
    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }
}
