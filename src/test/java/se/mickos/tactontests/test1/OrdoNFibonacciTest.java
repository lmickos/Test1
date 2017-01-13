package se.mickos.tactontests.test1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by Lars-Erik on 2017-01-04.
 */
public class OrdoNFibonacciTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /** Verify the OrdoN implementation for the first 8 values */
    @Test
    public void fibonacciOrdoN() throws Exception {
        assertEquals(0, OrdoNFibonacci.fibonacciOrdoN(0));
        assertEquals(1, OrdoNFibonacci.fibonacciOrdoN(1));
        assertEquals(1, OrdoNFibonacci.fibonacciOrdoN(2));
        assertEquals(2, OrdoNFibonacci.fibonacciOrdoN(3));
        assertEquals(3, OrdoNFibonacci.fibonacciOrdoN(4));
        assertEquals(5, OrdoNFibonacci.fibonacciOrdoN(5));
        assertEquals(8, OrdoNFibonacci.fibonacciOrdoN(6));
        assertEquals(13, OrdoNFibonacci.fibonacciOrdoN(7));
        assertEquals(21, OrdoNFibonacci.fibonacciOrdoN(8));
        assertEquals(1, OrdoNFibonacci.fibonacciOrdoN(-1));
        assertEquals(-1, OrdoNFibonacci.fibonacciOrdoN(-2));
        assertEquals(2, OrdoNFibonacci.fibonacciOrdoN(-3));
        assertEquals(-3, OrdoNFibonacci.fibonacciOrdoN(-4));
        assertEquals(5, OrdoNFibonacci.fibonacciOrdoN(-5));
        assertEquals(-8, OrdoNFibonacci.fibonacciOrdoN(-6));
    }

    /** Compare the OrdoN implementation for the supported positive span of n with BigNum implementation and verify error handling above max */
    @Test
    public void fibonacciOrdoNvsBigNumPos() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("above 92");
        expectedException.expectMessage("n=93");
        for (int i = 0; i < 1000; i++) {
            assertEquals("Fibonacci calculation should be equal to BigNum calculation for n="+i,
                    BigNumFibonacci.fibonacciBigNum(new BigInteger(String.valueOf(i))), // The BigNum calculation of fibonacci
                    new BigInteger(String.valueOf(OrdoNFibonacci.fibonacciOrdoN(i))) // The OrdoN calculation of fibonacci converted to BigInteger for comparison
            );
        }
    }

    /** Compare the OrdoN implementation for the supported positive span of n with BigNum implementation and verify error handling above max */
    @Test
    public void fibonacciOrdoNvsBigNumNeg() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("below -92");
        expectedException.expectMessage("n=-93");
        for (int i = 0; i > -1000; i--) {
            assertEquals("Fibonacci calculation should be equal to BigNum calculation for n="+i,
                    BigNumFibonacci.fibonacciBigNum(new BigInteger(String.valueOf(i))), // The BigNum calculation of fibonacci
                    new BigInteger(String.valueOf(OrdoNFibonacci.fibonacciOrdoN(i))) // The OrdoN calculation of fibonacci converted to BigInteger for comparison
            );
        }
    }

    /** Verify the OrdoN maximum range using the friendly internal method. Negative range is the same due to implementation reuse of positive implementation */
    @Test
    public void fibonacciOrdoNvsBigNumFlaw() throws Exception {
        int i = 0;
        while ( // Loop until a discrepancy is found
                BigNumFibonacci.fibonacciBigNum(new BigInteger(String.valueOf(i))) // The BigNum calculation of fibonacci
                        .equals(new BigInteger(String.valueOf(OrdoNFibonacci.fibonacciOrdoNInternal(i)))) // The OrdoN calculation of fibonacci converted to BigInteger for comparison
                ) i++;
        assertEquals("OrdoN calculation is expected to be incorrect for n=93 and correct below that",93,i);
    }


}