package se.mickos.tactontests.test1;

import java.math.BigInteger;

/**
 * Proof of concept class for command line execution
 * Created by Lars-Erik on 2017-01-04.
 */
public class Main {
    static public final BigInteger BIGINT1 = BigInteger.ONE;
    static public final BigInteger BIGINT2 = new BigInteger("2");
    static public final BigInteger BIGINT4 = new BigInteger("4");
    static public final BigInteger BIGINT8 = new BigInteger("8");
    static public final BigInteger BIGINT16 = new BigInteger("16");
    static public final BigInteger BIGINT32 = new BigInteger("32");
    static public final BigInteger BIGINT64 = new BigInteger("64");
    static public final BigInteger BIGINT10 = new BigInteger("10");
    static public final BigInteger BIGINT100 = new BigInteger("100");
    static public final BigInteger BIGINT1000 = new BigInteger("1000");
    static public final BigInteger BIGINT10000 = new BigInteger("10000");
    static public final BigInteger BIGINT100000 = new BigInteger("100000");
    static public final BigInteger BIGINT1000000 = new BigInteger("1000000");
    static public final BigInteger BIGINT200000 = new BigInteger("200000");
    static public final BigInteger BIGINT400000 = new BigInteger("400000");

    /**
     * Runnable Main function that prints out results and statistics for the fibonacci examples
     * @param args (Ignored)
     */
    static public void main(String[] args) {
        // Print out the first 10 values of the series using the Ordo1 implementation
        System.out.println("Ordo1 values:");
        for(int i=1;i<=10;i++){
            long fib = Ordo1Fibonacci.fibonacciOrdo1(i);
            System.out.println("n: " + i + " =>" + fib);
        }
        System.out.println();
        System.out.println("Timings Ordo1:");
        // Print out the time statistics when doubling n from 1 to 64 using the OrdoN implementation
        System.out.println("Ordo1 n=1->"+Timer.timeFormat(()-> Ordo1Fibonacci.fibonacciOrdo1(1),100000));
        System.out.println("Ordo1 n=2->"+Timer.timeFormat(()-> Ordo1Fibonacci.fibonacciOrdo1(2),100000));
        System.out.println("Ordo1 n=4->"+Timer.timeFormat(()-> Ordo1Fibonacci.fibonacciOrdo1(4),100000));
        System.out.println("Ordo1 n=8->"+Timer.timeFormat(()-> Ordo1Fibonacci.fibonacciOrdo1(8),100000));
        System.out.println("Ordo1 n=16->"+Timer.timeFormat(()-> Ordo1Fibonacci.fibonacciOrdo1(16),100000));
        System.out.println("Ordo1 n=32->"+Timer.timeFormat(()-> Ordo1Fibonacci.fibonacciOrdo1(32),100000));
        System.out.println("Ordo1 n=64->"+Timer.timeFormat(()-> Ordo1Fibonacci.fibonacciOrdo1(64),100000));
        // Print out the time statistics for max/min n using the Ordo1 implementation
        System.out.println("Ordo1 max n=70->"+Timer.timeFormat(()-> Ordo1Fibonacci.fibonacciOrdo1(70),100000));
        System.out.println("Ordo1 min n=-68->"+Timer.timeFormat(()-> Ordo1Fibonacci.fibonacciOrdo1(-68),100000));
        System.out.println();

        System.out.println("Timings OrdoN:");
        // Print out the time statistics when doubling n from 1 to 64 using the OrdoN implementation
        System.out.println("OrdoN n=1->"+Timer.timeFormat(()-> OrdoNFibonacci.fibonacciOrdoN(1),100000));
        System.out.println("OrdoN n=2->"+Timer.timeFormat(()-> OrdoNFibonacci.fibonacciOrdoN(2),100000));
        System.out.println("OrdoN n=4->"+Timer.timeFormat(()-> OrdoNFibonacci.fibonacciOrdoN(4),100000));
        System.out.println("OrdoN n=8->"+Timer.timeFormat(()-> OrdoNFibonacci.fibonacciOrdoN(8),100000));
        System.out.println("OrdoN n=16->"+Timer.timeFormat(()-> OrdoNFibonacci.fibonacciOrdoN(16),100000));
        System.out.println("OrdoN n=32->"+Timer.timeFormat(()-> OrdoNFibonacci.fibonacciOrdoN(32),100000));
        System.out.println("OrdoN n=64->"+Timer.timeFormat(()-> OrdoNFibonacci.fibonacciOrdoN(64),100000));
        // Print out the time statistics for max/min n using the OrdoN implementation
        System.out.println("OrdoN max n=92->"+Timer.timeFormat(()-> OrdoNFibonacci.fibonacciOrdoN(92),100000));
        System.out.println("OrdoN min n=-92->"+Timer.timeFormat(()-> OrdoNFibonacci.fibonacciOrdoN(-92),100000));
        System.out.println();

        // Print out the first 10 values of the fibonacci series using the Bignum implementation
        System.out.println("BigNum values:");
        for(int j=1;j<=10;j++){
            BigInteger fib = BigNumFibonacci.fibonacciBigNum(new BigInteger(String.valueOf(j)));
            System.out.println("n: " + j + " =>" + fib);
        }
        System.out.println("Timings BigNum:");
        // Print out the time statistics when doubling n from 1 to 64 using the BigNum implementation
        System.out.println("Bignum n=1->"+Timer.timeFormat(()-> BigNumFibonacci.fibonacciBigNum(BIGINT1),10000));
        System.out.println("Bignum n=2->"+Timer.timeFormat(()-> BigNumFibonacci.fibonacciBigNum(BIGINT2),10000));
        System.out.println("Bignum n=4->"+Timer.timeFormat(()-> BigNumFibonacci.fibonacciBigNum(BIGINT4),1000));
        System.out.println("Bignum n=8->"+Timer.timeFormat(()-> BigNumFibonacci.fibonacciBigNum(BIGINT8),1000));
        System.out.println("Bignum n=16->"+Timer.timeFormat(()-> BigNumFibonacci.fibonacciBigNum(BIGINT16),1000));
        System.out.println("Bignum n=32->"+Timer.timeFormat(()-> BigNumFibonacci.fibonacciBigNum(BIGINT32),1000));
        System.out.println("Bignum n=64->"+Timer.timeFormat(()-> BigNumFibonacci.fibonacciBigNum(BIGINT64),1000));
        // Print out the time statistics when tenfolding n from 1 to one million using the BigNum implementation with some doubled values above 100 000 where timing seems to converge notably
        System.out.println("Bignum n=1->"+Timer.timeFormat(()-> BigNumFibonacci.fibonacciBigNum(BIGINT1),10000));
        System.out.println("Bignum n=10->"+Timer.timeFormat(()-> BigNumFibonacci.fibonacciBigNum(BIGINT10),1000));
        System.out.println("Bignum n=100->"+Timer.timeFormat(()-> BigNumFibonacci.fibonacciBigNum(BIGINT100),1000));
        System.out.println("Bignum n=1000->"+Timer.timeFormat(()-> BigNumFibonacci.fibonacciBigNum(BIGINT1000),1000));
        System.out.println("Bignum n=10000->"+Timer.timeFormat(()-> BigNumFibonacci.fibonacciBigNum(BIGINT10000),100));
        System.out.println("Bignum n=100000->"+Timer.timeFormat(()-> BigNumFibonacci.fibonacciBigNum(BIGINT100000),3));
        System.out.println("Bignum n=200000->"+Timer.timeFormat(()-> BigNumFibonacci.fibonacciBigNum(BIGINT200000),1));
        System.out.println("Bignum n=400000->"+Timer.timeFormat(()-> BigNumFibonacci.fibonacciBigNum(BIGINT400000),1));
        System.out.println("Bignum n=1000000->"+Timer.timeFormat(()-> BigNumFibonacci.fibonacciBigNum(BIGINT1000000),1));
    }
}
