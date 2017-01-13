package se.mickos.tactontests.test1;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by Lars-Erik on 2017-01-04.
 */
public class BigNumFibonacciTest {
    /** Verify the BigNum implementation for the first 8 positive and the first 6 negative values */
    @Test
    public void fibonacciBigNum() throws Exception {
        assertEquals(BigInteger.ZERO, BigNumFibonacci.fibonacciBigNum(BigInteger.ZERO));
        assertEquals(BigInteger.ONE, BigNumFibonacci.fibonacciBigNum(BigInteger.ONE));
        assertEquals(BigInteger.ONE, BigNumFibonacci.fibonacciBigNum(new BigInteger("2")));
        assertEquals(new BigInteger("2"), BigNumFibonacci.fibonacciBigNum(new BigInteger("3")));
        assertEquals(new BigInteger("3"), BigNumFibonacci.fibonacciBigNum(new BigInteger("4")));
        assertEquals(new BigInteger("5"), BigNumFibonacci.fibonacciBigNum(new BigInteger("5")));
        assertEquals(new BigInteger("8"), BigNumFibonacci.fibonacciBigNum(new BigInteger("6")));
        assertEquals(new BigInteger("13"), BigNumFibonacci.fibonacciBigNum(new BigInteger("7")));
        assertEquals(new BigInteger("21"), BigNumFibonacci.fibonacciBigNum(new BigInteger("8")));
        assertEquals(BigInteger.ONE, BigNumFibonacci.fibonacciBigNum(new BigInteger("-1")));
        assertEquals(BigInteger.ONE.negate(), BigNumFibonacci.fibonacciBigNum(new BigInteger("-2")));
        assertEquals(new BigInteger("2"), BigNumFibonacci.fibonacciBigNum(new BigInteger("-3")));
        assertEquals(new BigInteger("3").negate(), BigNumFibonacci.fibonacciBigNum(new BigInteger("-4")));
        assertEquals(new BigInteger("5"), BigNumFibonacci.fibonacciBigNum(new BigInteger("-5")));
        assertEquals(new BigInteger("8").negate(), BigNumFibonacci.fibonacciBigNum(new BigInteger("-6")));
    }

    /** Verify the BigNum implementation for very extreme values */
    @Test
    public void fibonacciBigNumLarge() throws Exception {
        assertEquals("A high fibbonaci number calculated using BigNum implementation should still fulfill the spec of fibonnacci X(n)=X(n-2)+X(n-1)",
                BigNumFibonacci.fibonacciBigNum(new BigInteger("100000")),
                BigNumFibonacci.fibonacciBigNum(new BigInteger("99998")).add(BigNumFibonacci.fibonacciBigNum(new BigInteger("99999"))));
        assertEquals("A low negative fibbonaci number calculated using BigNum implementation should still fulfill the spec of fibonnacci X(n)=X(n-2)+X(n-1)",
                BigNumFibonacci.fibonacciBigNum(new BigInteger("-99998")),
                BigNumFibonacci.fibonacciBigNum(new BigInteger("-100000")).add(BigNumFibonacci.fibonacciBigNum(new BigInteger("-99999"))));
    }

}