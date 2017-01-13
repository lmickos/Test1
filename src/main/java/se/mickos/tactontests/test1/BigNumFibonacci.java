package se.mickos.tactontests.test1;

import java.math.BigInteger;

/**
 * Created by Lars-Erik on 2017-01-04.
 */
public class BigNumFibonacci {
    /**
     * This is a loop based implementation supporting positive values of
     * @param n The sequence number. Only supported for positive numbers
     * @return The calculated number
     */
    static public BigInteger fibonacciBigNum(BigInteger n){
        BigInteger last = BigInteger.ZERO,beforeLast=BigInteger.ONE, result=BigInteger.ZERO;
        if (n.signum()==-1) {
            result = fibonacciBigNum(n.negate());
            return (n.testBit(0))?result:result.negate();
        }
        for(BigInteger i=BigInteger.ZERO;i.compareTo(n)==-1;i=i.add(BigInteger.ONE)){
            result=last.add(beforeLast);
            beforeLast=last;
            last=result;
        }
        return result;
    }
}
