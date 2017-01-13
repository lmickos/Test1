package se.mickos.tactontests.test1;

/**
 * Created by Lars-Erik on 2017-01-04.
 */
public class Ordo1Fibonacci {
    static private final double squareFive = Math.sqrt(5.0d);
    static private final double smallPhiNeg = (1.0d-squareFive)/2;
    static private final double bigPhiPos = (1.0d+squareFive)/2;

    /**
     * This is a precision math based implementation of calculating the n:th fibonacciOrdo1 value
     * This implementation also supports negative values of n fulfilling the spec that fib(n)=fib(n-1)+fib(n-1)
     * E.g. fib(-1)=fib(-2)+fib(-3)
     * The function should be O(1) assuming that the Java Math.pow implementation is O(1),
     * which it should be in Java 7/8 on all major platforms).
     * Theoretically it should work for all long range values of n, but for n>64 the risk of
     * precision point rounding errors is prevalent. Likewise for negative values.
     * @param n The sequence number. Only supported for positive/negative numbers up to ~ +/- 64
     *          (positive - normally works to 71) due to precision point calculation losses.
     * @return The calculated number
     */
    static public long fibonacciOrdo1(long n){
        if (n>70) throw new IllegalArgumentException("Values of n above 70 is not supported due to lack of math precision. n="+n);
        if (n<-68) throw new IllegalArgumentException("Values of n below -68 is not supported due to lack of math precision. n="+n);
        return fibonacciOrdo1Internal(n);
    }

    /**
     * The internal (friendly to enable unit tests) implementation method for Ordo1
     * @param n The sequence number. Only supported for positive/negative numbers up to ~ +/- 64
     *          (positive - normally works to 71) due to precision point calculation losses.
     * @return The calculated number
     */
    static long fibonacciOrdo1Internal(long n){
        return Math.round((Math.pow(bigPhiPos,n) - Math.pow((smallPhiNeg),n))/squareFive);
    }
}
