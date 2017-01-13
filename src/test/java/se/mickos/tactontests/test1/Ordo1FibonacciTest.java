package se.mickos.tactontests.test1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by Lars-Erik on 2017-01-04.
 */
public class Ordo1FibonacciTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /** Verify the Ordo1 implementation for the first 8 values */
    @Test
    public void fibonacciOrdo1() throws Exception {
        assertEquals(0, Ordo1Fibonacci.fibonacciOrdo1(0));
        assertEquals(1, Ordo1Fibonacci.fibonacciOrdo1(1));
        assertEquals(1, Ordo1Fibonacci.fibonacciOrdo1(2));
        assertEquals(2, Ordo1Fibonacci.fibonacciOrdo1(3));
        assertEquals(3, Ordo1Fibonacci.fibonacciOrdo1(4));
        assertEquals(5, Ordo1Fibonacci.fibonacciOrdo1(5));
        assertEquals(8, Ordo1Fibonacci.fibonacciOrdo1(6));
        assertEquals(13, Ordo1Fibonacci.fibonacciOrdo1(7));
        assertEquals(21, Ordo1Fibonacci.fibonacciOrdo1(8));
    }

    /** Compare the Ordo1 implementation for the supported positive span of n with BigNum implementation and verify error handling above max */
    @Test
    public void fibonacciOrdo1vsBigNumPos() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("above 70");
        expectedException.expectMessage("n=71");
        for (int i = 0; i < 1000; i++) {
            assertEquals("Fibonacci calculation should be equal to BigNum calculation for n="+i,
                    BigNumFibonacci.fibonacciBigNum(new BigInteger(String.valueOf(i))), // The BigNum calculation of fibonacci
                    new BigInteger(String.valueOf(Ordo1Fibonacci.fibonacciOrdo1(i))) // The Ordo1 calculation of fibonacci converted to BigInteger for comparison
            );
        }
        // Should not reach this point due to implemented exception
    }

    /** Compare the Ordo1 implementation for the supported negative span of n with BigNum implementation and verify error handling below min */
    @Test
    public void fibonacciOrdo1vsBigNumNeg() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("below -68");
        expectedException.expectMessage("n=-69");
        for (int i = -1; i > -1000; i--) {
            assertEquals("Fibonacci calculation should be equal to BigNum calculation for negative n="+i,
                    BigNumFibonacci.fibonacciBigNum(new BigInteger(String.valueOf(i))), // The BigNum calculation of fibonacci
                    new BigInteger(String.valueOf(Ordo1Fibonacci.fibonacciOrdo1(i))) // The Ordo1 calculation of fibonacci converted to BigInteger for comparison
            );
        }
        // Should not reach this point due to implemented exception
    }

    /** Verify the Ordo1 maximum range using the friendly internal method */
    @Test
    public void fibonacciOrdo1vsBigNumFlawPos() throws Exception {
        int i = 0;
        while ( // Loop until a discrepancy is found
                BigNumFibonacci.fibonacciBigNum(new BigInteger(String.valueOf(i))) // The BigNum calculation of fibonacci
                        .equals(new BigInteger(String.valueOf(Ordo1Fibonacci.fibonacciOrdo1Internal(i)))) // The OrdoN calculation of fibonacci converted to BigInteger for comparison
                ) i++;
        assertEquals("OrdoN calculation is expected to be incorrect for n=71 and correct below that",71,i);
    }

    /** Verify the Ordo1 minimum range using the friendly internal method */
    @Test
    public void fibonacciOrdoNvsBigNumFlawNeg() throws Exception {
        int i = 0;
        while ( // Loop until a discrepancy is found
                BigNumFibonacci.fibonacciBigNum(new BigInteger(String.valueOf(i))) // The BigNum calculation of fibonacci
                        .equals(new BigInteger(String.valueOf(Ordo1Fibonacci.fibonacciOrdo1Internal(i)))) // The OrdoN calculation of fibonacci converted to BigInteger for comparison
                ) i--;
        assertEquals("OrdoN calculation is expected to be incorrect for n=-69 but correct above that",-69,i);
    }

}